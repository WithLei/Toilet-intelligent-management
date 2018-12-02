package cn.javaee.bean;

import java.util.List;

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
	private String next_cleaned_time;
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
}
