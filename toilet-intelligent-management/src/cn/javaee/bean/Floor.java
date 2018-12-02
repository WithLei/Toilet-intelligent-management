package cn.javaee.bean;

import java.util.List;

//楼层
public class Floor {
	/**
	 * 楼层编号 primary key
	 */
	private int id;
	/**
	 * 楼层名 eg:2B楼3层
	 */
	private String name;
	/**
	 * 该层厕所表
	 */
	private List<Toilet>toiletList;

}
