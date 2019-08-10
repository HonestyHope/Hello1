package controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pojo.Users;
import service.UsersService;


@Controller
public class UsersController {
	@Resource
	private UsersService usersService;
	@RequestMapping("/login")
	public String login(Users users,HttpSession session) {
		Users user = usersService.login(users);
		if(user!=null) {
			session.setAttribute("user", user);
			return "redirect:/main.jsp";
		}else {
			return "redirect:/index.jsp";
		}
	}
}
