package com.framework.base.util.apacheCommonsUtil.lang;

import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;

public class DateUtilTest {

	/**
	 * @param args
	 *@author lyj [May 26, 2015]
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date day1 = new Date();    
        /*  
         * 由于Aache的DateUtils和DateFormatUtils并没有Joda强大,  
         *  所以在这里只作简单的示例  
         */    
            
        // 增加一天    
        DateUtils.addDays(day1, 1);    
        // 减少一年    
        DateUtils.addYears(day1, -1);    
    
        // 格式化时间,第三参数为国际化,表示按美国时间显示    
        DateFormatUtils.format(day1, "yyyy-MM-dd", Locale.UK);    

	}

}
