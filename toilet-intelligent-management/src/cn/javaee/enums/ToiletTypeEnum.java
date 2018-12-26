package cn.javaee.enums;

public enum ToiletTypeEnum {
	WOMEN(0,"女厕"),
	MAN(1,"男厕"),
	ALL(2,"公共厕所"),
	DISABLE(3,"残疾人厕所"),
	ELSE(4,"其他")
	;
	private Integer code;
	private String type;
	private ToiletTypeEnum(Integer code,String type) {
		this.code = code;
		this.type = type;
	}
	
	public static String getTypeByCode(Integer code) {
		for(ToiletTypeEnum enum1:ToiletTypeEnum.values()) {
			if(enum1.code.equals(code)) {
				return enum1.type;
			}
		}
		return null;
	}

}
