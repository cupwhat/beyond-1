package com.bs.beyond.core.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import com.bs.beyond.AppConst;

@Component
public class MessageUtil
{
	@Autowired
    private MessageSource messageSource;

    /**
     * get the message without params
     * 
     * @param key - message key
     * @return message
     */
    public String getMessage(String key)
    {
        return messageSource.getMessage(key, null, AppConst.locale);
    }

    /**
     * get the message with params
     * 
     * @param key - message key
     * @param arg - param list
     * @return message
     */
    public String getMessage(String key, Object... arg)
    {
        return messageSource.getMessage(key, arg, AppConst.locale);
    }

}
