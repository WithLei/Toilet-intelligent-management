package cn.javaee.bean;

import java.util.Date;

// 蹲位
public class Position {
	/**
	 * 编号 primary key 也用于显示
	 */
	private int id;
	/**
	 * 是否使用中
	 */
	private boolean isUsing;
	/**
	 * 是否在服务中
	 * true 可使用
	 * false 不可使用-或在维修中
	 */
	private boolean isServing;
	/**
	 * 开始使用时间
	 */
	private Date start_time;
	/**
	 * 蹲位类型
	 * seat 坐便
	 * squat 蹲便
	 */
	private String type;
}
