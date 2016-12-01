package com.bs.beyond.util;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class MessageUtil
{

	@Autowired
    private MessageSource messageSource;

    private Locale locale = Locale.ENGLISH;

    public MessageUtil()
    {
    }

    /**
     * get the message without params
     * 
     * @param key - message key
     * @return message
     */
    public String getMessage(String key)
    {
        return messageSource.getMessage(key, null, locale);
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
        return messageSource.getMessage(key, arg, locale);
    }
}
