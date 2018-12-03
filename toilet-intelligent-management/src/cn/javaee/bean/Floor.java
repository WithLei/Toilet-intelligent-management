package cn.javaee.bean;

import java.util.List;

//楼层
public class Floor {
	/**
	 * 楼层编号 primary key
	 */
	private long id;
	/**
	 * 楼层名 eg:2B楼3层
	 */
	private String name;
	/**
	 * 该层厕所表
	 */
	private List<Toilet>toiletList;
	
	public Floor() {
		super();
	}

	public Floor(long id, String name, List<Toilet> toiletList) {
		super();
		this.id = id;
		this.name = name;
		this.toiletList = toiletList;
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

	public List<Toilet> getToiletList() {
		return toiletList;
	}

	public void setToiletList(List<Toilet> toiletList) {
		this.toiletList = toiletList;
	}
	
	@Override
	public String toString() {
		return "Floor[ id = " + this.id +
                ",name = " + this.name +
//                ",toiletList = " + this.toiletList.toString() +
                " ]";
	}
}
