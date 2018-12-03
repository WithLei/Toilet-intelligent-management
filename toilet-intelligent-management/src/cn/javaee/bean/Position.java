package cn.javaee.bean;

import java.util.Date;

import cn.javaee.utils.TimeUtils;

// 蹲位
public class Position {
	/**
	 * 编号 primary key 也用于显示
	 */
	private long id;
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
	private Date start_time;
	/**
	 * 蹲位类型
	 * seat 坐便
	 * squat 蹲便
	 */
	private String type;
	
	public Position() {
		super();
	}

	public Position(long id, boolean isUsing, boolean isServing, Date start_time, String type) {
		super();
		this.id = id;
		this.isUsing = isUsing;
		this.isServing = isServing;
		this.start_time = start_time;
		this.type = type;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public Date getStart_time() {
		return start_time;
	}

	public void setStart_time(Date start_time) {
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
		return "Position[ id = " + this.id +
                ",isUsing = " + this.isUsing +
                ",isServing = " + this.isServing +
                ",start_time = " + TimeUtils.dateToString(this.start_time) +
                ",type = " + this.type +
                " ]";
	}
}
