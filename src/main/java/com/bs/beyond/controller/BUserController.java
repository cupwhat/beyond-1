package com.bs.beyond.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bs.beyond.AppConst;
import com.bs.beyond.bo.BUserBO;
import com.bs.beyond.core.BsConst;
import com.bs.beyond.core.BsController;
import com.bs.beyond.core.annotation.BLogger;
import com.bs.beyond.service.BUserService;

@Controller
public class BUserController extends BsController {

	@Autowired
	private BUserService bUserService;

	/***
	 * 
	 * @return
	 */
	@BLogger()
	@RequestMapping(value="showLogin")
	public ModelAndView showLogin(
        HttpSession session,
        HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView(AppConst.URL.VIEW_LOGIN);

//        mv.addObject("userName", "Test");

		return mv;
	}

	/***
	 * 
	 * @return
	 */
	@BLogger()
	@RequestMapping(value="register")
	public ModelAndView register(
        HttpSession session,
        HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView(AppConst.URL.VIEW_REGISTER);

//        mv.addObject("userName", "Test");

		return mv;
	}

	/***
	 * 
	 * @return
	 */
	@BLogger()
	@RequestMapping(value="login", method = RequestMethod.POST)
	@ResponseBody
	public BUserBO login(HttpSession session, BUserBO bUserBO)
	{
		BUserBO bo = bUserService.validateUser(bUserBO);

		if (BsConst.ResultCode.SUCCESS.equals(bUserBO.getBsResult()))
		{
			session.setAttribute(AppConst.BEYOND_TOKEN, bo);
		}
		
		return bo;
	}

	/***
	 * 
	 * @return
	 */
	@BLogger()
	@RequestMapping(value="logout")
	public ModelAndView logout(HttpSession session)
	{
		session.setAttribute(AppConst.BEYOND_TOKEN, null);
		
		ModelAndView mv = new ModelAndView(AppConst.URL.VIEW_MAIN);

		return mv;
	}

}
