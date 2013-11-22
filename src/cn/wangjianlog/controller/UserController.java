package cn.wangjianlog.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.wangjianlog.model.User;

@Controller
@RequestMapping("/user")
public class UserController {

	private Map<String,User> users = new HashMap<>(); 
	
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
	public String add(@Validated User user,BindingResult br){//一定要紧跟Validated之后写验证信息
		if(br.hasErrors()){
			return "user/add";
		}
		users.put(user.getUsername(), user);
		return "redirect:/user/users";
	}
	
}
