package cn.javaee.bean;

import cn.javaee.utils.TimeUtils;

// 用户
public class User {
	private int id;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 手机号
	 */
	private String phone;
	/**
	 * 密码
	 */
	private String pwd;
	/**
	 * 头像
	 */
	private String avatar;
	
	public User() {
		super();
	}

	// 此构造器无avatar属性
	public User(int id, String name, String phone, String pwd) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.pwd = pwd;
	}
	
	public User(String name, String phone, String pwd,String avatar) {
		this.name = name;
		this.phone = phone;
		this.pwd = pwd;
		this.avatar=avatar;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@Override
	public String toString() {
		return "User[ id = " + this.id +
                ",name = " + this.name +
                ",phone = " + this.phone +
                ",pwd = " + this.pwd +
                ",avatar = " + this.avatar +
                " ]";
	}
}
