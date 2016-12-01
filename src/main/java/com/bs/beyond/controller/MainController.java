package com.bs.beyond.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bs.beyond.AppConst;
import com.bs.beyond.bo.BUserBO;
import com.bs.beyond.core.BsController;
import com.bs.beyond.core.annotation.BLogger;
import com.bs.beyond.entity.BUser;

@Controller
public class MainController extends BsController {

	/***
	 * 
	 * @return
	 */
	@BLogger()
	@RequestMapping(value="main")
	public ModelAndView main(
        HttpSession session,
        HttpServletRequest request)
	{
		Object objToken = session.getAttribute(AppConst.BEYOND_TOKEN);
		String sUserName = null;
		if (objToken != null)
		{
			BUserBO bUserBO = (BUserBO)objToken;
			sUserName = bUserBO.getUserName();
		}

		ModelAndView mv = new ModelAndView(AppConst.URL.VIEW_MAIN);

		if (sUserName != null)
		{
            mv.addObject("userName", sUserName);
		}

		return mv;
	}
	

	/***
	 * 
	 * transfer Json to Object by @ResponseBody
	 * @return
	 */
	@BLogger()
	@RequestMapping(value="ajax", method = RequestMethod.POST)
	@ResponseBody
	public BUser ajax(@RequestBody BUser bUser)
	{
		BUser bUserRtn = new BUser();
		bUserRtn.setUserName("AJAX : UserName :" + bUser.getUserName());
		
	    return bUserRtn;
	}
	

	/***
	 * 
	 */
	@BLogger()
	@RequestMapping(value="test")
	public ModelAndView test()
	{
		ModelAndView mv = new ModelAndView(AppConst.URL.VIEW_MAIN);

        mv.addObject("testLabel", "Hello Test");
	    return mv;
	}
}
