package cn.javaee.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {
	/**
     * 获取从startTime到现在的时间
     * @return passTime
     * 一分钟内：x秒前
     * 一小时内：x分钟前
     * 24小时内：x小时前
     * 一年内：x天前
     * 更多：x年前
     */
    public static String getFromNowOnTime(long startTime){
        long x =  System.currentTimeMillis() - startTime;
        if (x < 0) {
            return "error";
        }

        // 一分钟内
        if (x/60000 < 1)
            return x%60000 + "秒前";
        x /= 60000;
        
        // 一小时内
        if (x/60 < 1)
            return x%60 + "分钟前";
        x /= 60;

        // 24小时内
        if (x/24 < 1)
            return x%24 + "小时前";
        x /= 24;

        // 一年内
        if (x/365 < 1)
            return x%365 + "天前";

        return x/365 + "年前";
    }
	
	/**
	 * 将String转为秒钟int类型
	 * @param str
	 * @return
	 */
	public static long stringToMiles(String str){
        try {
            return stringToDate(str).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
	
	public static String dateToString(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

    public static Date stringToDate(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.parse(date);
    }
    
    
}
