package cn.javaee.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class timeUtils {
	/**
	 * 计算参数时间到现在时间之差
	 * 返回 分钟数
	 */
	public static int getTime(Date oldTime) {
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
		// TODO:对time进行处理-now处理
		return 0;
	}
	
	public static int getTime(String oldTime) {
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
		// TODO:对time进行处理-now处理
		return 0;
	}
	
	/**
	 * 将Date转为秒钟int类型
	 * @param date
	 * @return
	 */
	public static int dateToSec(Date date) {
		// TODO:
		return 0;
	}
}
