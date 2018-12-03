package cn.javaee.bean;

import java.util.Date;

// 清扫日志
public class CleanLog {
	private long id;
	private Date last_cleaned_time;
	private Date next_clean_time;
	private Cleaner cleaner;
}
