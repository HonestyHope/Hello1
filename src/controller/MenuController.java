package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.Menu;
import pojo.Users;

@Controller
public class MenuController {
	@RequestMapping("getMenu")
	@ResponseBody
	private List<Menu> getMenu(HttpSession session) {
		return ((Users)session.getAttribute("user")).getMenus();
	}
}
