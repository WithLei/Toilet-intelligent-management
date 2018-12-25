package cn.javaee.VO;

import java.util.Date;

public class ResultToiletVO {
	private Integer id;
	private String name;
	private String type;
	private String cleaner_name;
	private String cleaner_phone;
	private Date pre_clean;
	private Date next_clean;
	private String isServer;
	private String floor_name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCleaner_name() {
		return cleaner_name;
	}
	public void setCleaner_name(String cleaner_name) {
		this.cleaner_name = cleaner_name;
	}
	public String getCleaner_phone() {
		return cleaner_phone;
	}
	public void setCleaner_phone(String cleaner_phone) {
		this.cleaner_phone = cleaner_phone;
	}
	public Date getPre_clean() {
		return pre_clean;
	}
	public void setPre_clean(Date pre_clean) {
		this.pre_clean = pre_clean;
	}
	public Date getNext_clean() {
		return next_clean;
	}
	public void setNext_clean(Date next_clean) {
		this.next_clean = next_clean;
	}
	public String getIsServer() {
		return isServer;
	}
	public void setIsServer(String isServer) {
		this.isServer = isServer;
	}
	public String getFloor_name() {
		return floor_name;
	}
	public void setFloor_name(String floor_name) {
		this.floor_name = floor_name;
	}
	@Override
	public String toString() {
		return "ResultToiletVO [id=" + id + ", name=" + name + ", type=" + type + ", cleaner_name=" + cleaner_name
				+ ", cleaner_phone=" + cleaner_phone + ", pre_clean=" + pre_clean + ", next_clean=" + next_clean
				+ ", isServer=" + isServer + ", floor_name=" + floor_name + "]";
	}
	
	
}
