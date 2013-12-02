package cn.wangjianlog.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import cn.wangjianlog.model.User;
import cn.wangjianlog.model.UserException;
import cn.wangjianlog.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	private Map<String,User> users = new HashMap<>(); 
	private IUserService userService;
	
	
	
	public IUserService getUserService() {
		return userService;
	}
	@Resource
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	public UserController (){
		users.put("1", new User("1","1","1","1"));
		users.put("2", new User("2","2","2","2"));
		users.put("3", new User("3","3","3","3"));
		users.put("4", new User("4","4","4","4"));
	}
	@RequestMapping(value = "/users",method=RequestMethod.GET)
	public String list(Model model){
		model.addAttribute("users", users);
		return "user/list";
	}
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(@ModelAttribute("user") User user){
		//开启modelDriven 方式一
		//model.addAttribute(new User());
		return "user/add";
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@Validated User user,BindingResult br,@RequestParam("attachs")MultipartFile[] attachs,HttpServletRequest req){//一定要紧跟Validated之后写验证信息
		if(br.hasErrors()){
			return "user/add";
		}
		String realPath = req.getSession().getServletContext().getRealPath("/resources/upload");
		System.out.println(realPath);
		for(MultipartFile attach:attachs){
			if(attach.isEmpty()) continue;
			File  f = new File(realPath +"/" +attach.getOriginalFilename());
			try {
				FileUtils.copyInputStreamToFile(attach.getInputStream(), f);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				throw new MaxUploadSizeExceededException(5000);
			}
			System.out.println(attach.getName()+","+attach.getOriginalFilename()+","+attach.getContentType());
		}
		users.put(user.getUsername(), user);
		return "redirect:/user/users";
	}
	@RequestMapping(value = "/{username}",method=RequestMethod.GET)
	public String show(@PathVariable String username ,Model model){
		model.addAttribute(users.get(username));
		
		return "user/show";
	}
	
	@RequestMapping(value = "/{username}",method=RequestMethod.GET,params="json")
	@ResponseBody
	public User show(@PathVariable String username){
		return users.get(username);
	}
	
	@RequestMapping(value="/{username}/update",method=RequestMethod.GET)
	public String update(@PathVariable String username,Model model){
		User user = users.get(username);
		System.out.println("username:"+username);
		System.out.println("user:"+user);
		
		model.addAttribute(user);
		return "user/update";
	}
	@RequestMapping(value="/{username}/update",method=RequestMethod.POST)
	public String update(@PathVariable String username,@Validated User user,BindingResult br){
		System.out.println("usernameUpdate:" +username);
		if(br.hasErrors()){
			return "user/update";
		}
		users.put(username, user);
		return "redirect:/user/users";
	}
	@RequestMapping(value="/{username}/delete",method=RequestMethod.GET)
	public String delete(@PathVariable String username){
		users.remove(username);
		return "redirect:/user/users";
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(String username,String password,HttpSession session){
		if(!users.containsKey(username)){
			throw new UserException("用户名不存在");
		}
		User user = users.get(username);
		if(!users.containsKey(password)){
			throw new UserException("用户密码不正确");
		}
		session.setAttribute("loginUser", user);
		return "redirect:/user/users";
	}
	/**
	 * 局部异常处理，仅仅只能处理这个控制器中的异常
	 * @param e
	 * @param req
	 * @return
	 */
	/*@ExceptionHandler(value={UserException.class})
	public String handlerException(UserException e ,HttpServletRequest req){
		req.setAttribute("exception", e);
		return "error";
	}*/
}
