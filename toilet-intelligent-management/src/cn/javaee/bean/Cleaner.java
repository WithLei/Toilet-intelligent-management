package cn.javaee.bean;

// 保洁人员
public class Cleaner {
	private long id;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 手机号
	 */
	private String phone;
	/**
	 * 所属公司
	 */
	private String company;
	
	public Cleaner() {
		super();
	}

	public Cleaner(long id, String name, String phone, String company) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.company = company;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	@Override
	public String toString() {
		return "Cleaner[ id = " + this.id +
                ",name = " + this.name +
                ",phone = " + this.phone +
                ",company = " + this.company +
                " ]";
	}
}

