package cn.javaee.enums;

public enum PositionTypeEnum {
	POSITION_SQUAT(1,"squat"),
	POSITION_SEAT(2,"seat")
;
	private Integer type;
	private String name;
	PositionTypeEnum(Integer type,String name) {
		this.type = type;
		this.name = name;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
