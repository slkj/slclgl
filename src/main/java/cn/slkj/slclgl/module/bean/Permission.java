package cn.slkj.slclgl.module.bean;

public class Permission {

	private int id;
	private String pName;
	private String pDesc;
	private String iconCls;
	private String pid;
	private String pLevel;
	private int sort;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpDesc() {
		return pDesc;
	}
	public void setpDesc(String pDesc) {
		this.pDesc = pDesc;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getpLevel() {
		return pLevel;
	}
	public void setpLevel(String pLevel) {
		this.pLevel = pLevel;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	@Override
	public String toString() {
		return "Permission [id=" + id + ", pName=" + pName + ", pDesc=" + pDesc + ", iconCls="
				+ iconCls + ", pid=" + pid + ", pLevel=" + pLevel + ", sort=" + sort + "]";
	}
	
}
