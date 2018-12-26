package cn.javaee.bean;

import java.util.Date;
import java.util.List;

import cn.javaee.utils.TimeUtils;

public class Toilet {
	/**
	 * 编号 primary key
	 */
	private int id;
	/**
	 * 厕所名 eg:茶水间厕所
	 */
	private String name;
	/**
	 * 厕所类型
	 * 0 女用
	 * 1 男用 
	 * 2 都可用
	 * 3 残疾人
	 * 4 其它
	 */
	private int type;
	/**
	 * 保洁人员ID
	 */
	private Cleaner cleaner;
	/**
	 * 上一次打扫时间
	 * 存数据库中使用time字段
	 */
	private String last_cleaned_time;
	/**
	 * 下一次打扫时间
	 */
	private String next_clean_time;
	/**
	 * 该厕所蹲位表
	 */
	private List<Position>positionList;
	/**
	 * 是否服务中
	 * true 服务中
	 * false 打扫维护中
	 */
	private boolean isService;
	
	private Floor floor;
	
	public Toilet() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Cleaner getCleaner() {
		return cleaner;
	}

	public void setCleaner(Cleaner cleaner) {
		this.cleaner = cleaner;
	}

	public String getLast_cleaned_time() {
		return last_cleaned_time;
	}

	public void setLast_cleaned_time(String last_cleaned_time) {
		this.last_cleaned_time = last_cleaned_time;
	}

	public String getNext_clean_time() {
		return next_clean_time;
	}

	public void setNext_clean_time(String next_clean_time) {
		this.next_clean_time = next_clean_time;
	}

	public List<Position> getPositionList() {
		return positionList;
	}

	public void setPositionList(List<Position> positionList) {
		this.positionList = positionList;
	}

	public boolean isService() {
		return isService;
	}

	public void setService(boolean isService) {
		this.isService = isService;
	}

	public Floor getFloor() {
		return floor;
	}

	public void setFloor(Floor floor) {
		this.floor = floor;
	}

	@Override
	public String toString() {
		return "Toilet [id=" + id + ", name=" + name + ", type=" + type + ", cleaner=" + cleaner
				+ ", last_cleaned_time=" + last_cleaned_time + ", next_clean_time=" + next_clean_time
				+ ", positionList=" + positionList + ", isService=" + isService + ", floor=" + floor + "]";
	}
	
	
}
