package cn.slkj.slclgl.module.bean;

public class Menus {

	private String menuid;
	private String icon;
	private String menuname;
	private String url;
	private Menus menus;
	private Menus child;
	public String getMenuid() {
		return menuid;
	}
	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Menus getMenus() {
		return menus;
	}
	public void setMenus(Menus menus) {
		this.menus = menus;
	}
	public Menus getChild() {
		return child;
	}
	public void setChild(Menus child) {
		this.child = child;
	}
	
	
}
