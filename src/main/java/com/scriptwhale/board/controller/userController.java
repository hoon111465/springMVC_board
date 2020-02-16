package com.scriptwhale.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scriptwhale.board.service.UserService;
import com.scriptwhale.board.vo.UserVO;

@Controller
public class userController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(UserVO userVO, HttpSession ses, Model model) {
		
		ses.setAttribute("userConfig",  userService.userLogin(userVO));
		//ses.setMaxInactiveInterval(180); // 세션유지시간 3분

		return "redirect:/";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession ses, @RequestHeader String referer) {
        // 세션 제거
		ses.invalidate();
		
		 return "redirect:"+referer;
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		
		return "join";
	}

	@RequestMapping(value = "/joinCreate", method = RequestMethod.POST)
	public String joinCreate(HttpServletRequest req) {
		
		UserVO userVO = new UserVO();
		
		
		String id1= req.getParameter("id1");
		String id2= req.getParameter("id2");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		
		String id = id1+'@'+id2;
		System.out.println("파라미터");
		System.out.println(id);
		System.out.println(password);
		System.out.println(name);
		
		if(id2.equals("email")) {
			return "error";
		}else {
			
			userVO.setId(id);
			userVO.setPassword(password);
			userVO.setName(name);
			
			System.out.println("VO 값");
			System.out.println(userVO.getId());
			System.out.println(userVO.getPassword());
			System.out.println(userVO.getName());
			
			int result = userService.userJoin(userVO);
			
			System.out.println("login result : "+result);
			if(result!=1) {
				return "error";
			}
			return "board";
		}
		
		
	}
	

}
