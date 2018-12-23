package cn.javaee.bean;

import java.util.List;


public class menu {
	public String icon;
	public String name;
	public String dataUrl;
	public List<menu>children;
	
	// 父节点
	public menu(String icon,String name,List<menu>children){
		this.icon = icon;
		this.name = name;
		this.children = children;
	}
	
	// 子节点
	public menu(String icon,String name,String dataurl){
		this.icon = icon;
		this.name = name;
		this.dataUrl = dataurl;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<menu> getChildren() {
		return children;
	}

	public void setChildren(List<menu> children) {
		this.children = children;
	}

	public String getDataUrl() {
		return dataUrl;
	}

	public void setDataUrl(String dataUrl) {
		this.dataUrl = dataUrl;
	}
	
	
}
