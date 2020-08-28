package com.itaem.crazy.shirodemo.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtil
{

    private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);
    
    public static final String date_pattern = "yyyy-MM-dd";
    


    public static Date parseDate(String datestr)
    {
        try
        {
            return new SimpleDateFormat(date_pattern).parse(datestr);
        }
        catch (ParseException e)
        {
            logger.error("ParseException{}", e);
        }
        
        return null;
    }
    
    public static Date parseDate(String datestr, String pattern)
    {
        try
        {
            return new SimpleDateFormat(pattern).parse(datestr);
        }
        catch (ParseException e)
        {
            logger.error("ParseException {}", e);
        }
        
        return null;
    }
    
}
