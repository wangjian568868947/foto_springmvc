package cn.wangjianlog.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	/**
	 * Map<String,Object> context 也可以给页面传值
	 * @param username
	 * @param context
	 * @return
	 */
	@RequestMapping("/test")
	public String test(String username,Model model){
		System.out.println("test");
		//context.put("username", username);
		model.addAttribute("username", username);
		//此时用作哪个作为key？默认是使用对象的类型作为key-->model.addAttribute("string", username);
		model.addAttribute( username);
		return "test";
	}
}
