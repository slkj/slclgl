package cn.slkj.slclgl.prove.bean;

public class Prove {
	private String id;
	private String uid;//操作人
	private String number;//证明编号
	private String address;//使用地区
	private String ustype;//使用类型
	private String usman;//领用人
	private String usriqi;//领用时间
	private String wangjian;//网监员
	private String inspector;//安检员
	private String riqi;//测试日期
	private Integer state;
	private String remark;//备注
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUstype() {
		return ustype;
	}
	public void setUstype(String ustype) {
		this.ustype = ustype;
	}
	public String getUsman() {
		return usman;
	}
	public void setUsman(String usman) {
		this.usman = usman;
	}
	public String getUsriqi() {
		return usriqi;
	}
	public void setUsriqi(String usriqi) {
		this.usriqi = usriqi;
	}
	public String getWangjian() {
		return wangjian;
	}
	public void setWangjian(String wangjian) {
		this.wangjian = wangjian;
	}
	public String getInspector() {
		return inspector;
	}
	public void setInspector(String inspector) {
		this.inspector = inspector;
	}
	public String getRiqi() {
		return riqi;
	}
	public void setRiqi(String riqi) {
		this.riqi = riqi;
	}
	
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	 

}
