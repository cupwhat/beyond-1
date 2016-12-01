package com.bs.beyond.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bs.beyond.Const;
import com.bs.beyond.core.BsController;
import com.bs.beyond.core.annotation.BLogger;
import com.bs.beyond.entity.BUser;

@Controller
public class LoginController extends BsController {

	/***
	 * 
	 * @return
	 */
	@BLogger()
	@RequestMapping(value="login")
	public ModelAndView login(
        HttpSession session,
        HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView(Const.URL.VIEW_LOGIN);

        mv.addObject("userName", "Test");

		return mv;
	}
	

}
