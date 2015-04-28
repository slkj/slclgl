package cn.slkj.slclgl.sim.bean;

public class Sim {

	private String id;
	private int type;
	private String cardType;
	private String listnum;
	private String telnum;
	private int state;
	private String intime;
	private String outtime;
	private String kktime;
	private String fhtime;
	private String renewtime;
	private String business;
	private String beizhu;
	private String gys;
	private String lyr;
	private String lrr;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getListnum() {
		return listnum;
	}
	public void setListnum(String listnum) {
		this.listnum = listnum;
	}
	public String getTelnum() {
		return telnum;
	}
	public void setTelnum(String telnum) {
		this.telnum = telnum;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getIntime() {
		return intime;
	}
	public void setIntime(String intime) {
		this.intime = intime;
	}
	public String getOuttime() {
		return outtime;
	}
	public void setOuttime(String outtime) {
		this.outtime = outtime;
	}
	public String getKktime() {
		return kktime;
	}
	public void setKktime(String kktime) {
		this.kktime = kktime;
	}
	public String getFhtime() {
		return fhtime;
	}
	public void setFhtime(String fhtime) {
		this.fhtime = fhtime;
	}
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	public String getLyr() {
		return lyr;
	}
	public void setLyr(String lyr) {
		this.lyr = lyr;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getGys() {
		return gys;
	}
	public void setGys(String gys) {
		this.gys = gys;
	}
	public String getLrr() {
		return lrr;
	}
	public void setLrr(String lrr) {
		this.lrr = lrr;
	}
	public String getRenewtime() {
		return renewtime;
	}
	public void setRenewtime(String renewtime) {
		this.renewtime = renewtime;
	}
	public String getBusiness() {
		return business;
	}
	public void setBusiness(String business) {
		this.business = business;
	}
	@Override
	public String toString() {
		return "Sim [id=" + id + ", type=" + type + ", cardType=" + cardType + ", listnum="
				+ listnum + ", telnum=" + telnum + ", state=" + state + ", intime=" + intime
				+ ", outtime=" + outtime + ", kktime=" + kktime + ", fhtime=" + fhtime
				+ ", renewtime=" + renewtime + ", business=" + business + ", beizhu=" + beizhu
				+ ", gys=" + gys + ", lyr=" + lyr + ", lrr=" + lrr + "]";
	}
	
}
