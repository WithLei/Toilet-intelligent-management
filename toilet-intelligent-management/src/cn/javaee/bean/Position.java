package cn.javaee.bean;

import java.sql.*;

import cn.javaee.utils.TimeUtils;

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
	 * false 不可使用-或被预约/在维修中
	 */
	private boolean isServing;
	/**
	 * 开始使用时间
	 */
	private String start_time;
	/**
	 * 蹲位类型
	 * seat 坐便
	 * squat 蹲便
	 */
	private String type;
	
	/**
	 * 对应的厕所 
	 **/
	private Toilet toilet;
	
	
	
	
	public Toilet getToilet() {
		return toilet;
	}

	public void setToilet(Toilet toilet) {
		this.toilet = toilet;
	}

	public Position() {
		super();
	}

	
	public Position turn() {
		this.setServing(!this.isServing());
		return this;
	}
	public Position(int id, boolean isUsing, boolean isServing, String start_time, String type, Toilet toilet) {
		super();
		this.id = id;
		this.isUsing = isUsing;
		this.isServing = isServing;
		this.start_time = start_time;
		this.type = type;
		this.toilet = toilet;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isUsing() {
		return isUsing;
	}

	public void setUsing(boolean isUsing) {
		this.isUsing = isUsing;
	}

	public boolean isServing() {
		return isServing;
	}

	public void setServing(boolean isServing) {
		this.isServing = isServing;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Position [id=" + id + ", isUsing=" + isUsing + ", isServing=" + isServing + ", start_time=" + start_time
				+ ", type=" + type + ", toilet=" + toilet + "]";
	}
	
	
}
