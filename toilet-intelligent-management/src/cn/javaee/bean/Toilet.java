package cn.javaee.bean;

import java.util.Date;
import java.util.List;

import cn.javaee.utils.TimeUtils;

public class Toilet {
	/**
	 * 编号 primary key
	 */
	private long id;
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
	private Date last_cleaned_time;
	/**
	 * 下一次打扫时间
	 */
	private Date next_clean_time;
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
	
	public Toilet() {
		super();
	}
	
	public Toilet(long id, String name, int type, Cleaner cleaner, Date last_cleaned_time, Date next_clean_time,
			List<Position> positionList, boolean isService) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.cleaner = cleaner;
		this.last_cleaned_time = last_cleaned_time;
		this.next_clean_time = next_clean_time;
		this.positionList = positionList;
		this.isService = isService;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public Date getLast_cleaned_time() {
		return last_cleaned_time;
	}

	public void setLast_cleaned_time(Date last_cleaned_time) {
		this.last_cleaned_time = last_cleaned_time;
	}

	public Date getNext_clean_time() {
		return next_clean_time;
	}

	public void setNext_clean_time(Date next_clean_time) {
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

	@Override
	public String toString() {
		return "Toilet[ id = " + this.id +
                ",name = " + this.name +
                ",type = " + this.type +
                ",cleaner = " + this.cleaner.toString() +
                ",last_cleaned_time = " + TimeUtils.dateToString(this.last_cleaned_time) +
                ",next_clean_time = " + TimeUtils.dateToString(this.next_clean_time) +
                ",isService = " + this.isService +
//                ",positionList = " + this.positionList.toString() +
                " ]";
	}
}
