package com.bs.beyond.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bs.beyond.AppConst;
import com.bs.beyond.core.BsController;
import com.bs.beyond.core.annotation.BLogger;

@Controller
public class RegularController extends BsController {

	/***
	 * 
	 * @return
	 */
	@BLogger()
	@RequestMapping(value="regular")
	public ModelAndView regular()
	{
		ModelAndView mv = new ModelAndView(AppConst.URL.VIEW_REGULAR);

		return mv;
	}
}
