package cn.slkj.slclgl.devices.bean;

public class Devices {
	private String id;
	private String listnum;
	private String firm;
	private String model;
	private String genre;
	private String rktime;
	private String state;
	private String fhtime;
	private String lyr;
	private String lytime;
	private String test;
	private String phone;
	private String cstime;
	private String tresult;
	// private String lyr;
	// private String lytime;
	// private String test;
	// private String phone;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getListnum() {
		return listnum;
	}
	public void setListnum(String listnum) {
		this.listnum = listnum;
	}
	public String getFirm() {
		return firm;
	}
	public void setFirm(String firm) {
		this.firm = firm;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getRktime() {
		return rktime;
	}
	public void setRktime(String rktime) {
		this.rktime = rktime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getFhtime() {
		return fhtime;
	}
	public void setFhtime(String fhtime) {
		this.fhtime = fhtime;
	}
	public String getLyr() {
		return lyr;
	}
	public void setLyr(String lyr) {
		this.lyr = lyr;
	}
	public String getLytime() {
		return lytime;
	}
	public void setLytime(String lytime) {
		this.lytime = lytime;
	}
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCstime() {
		return cstime;
	}
	public void setCstime(String cstime) {
		this.cstime = cstime;
	}
	public String getTresult() {
		return tresult;
	}
	public void setTresult(String tresult) {
		this.tresult = tresult;
	}
	@Override
	public String toString() {
		return "Devices [id=" + id + ", listnum=" + listnum + ", firm=" + firm + ", model=" + model
				+ ", genre=" + genre + ", rktime=" + rktime + ", state=" + state + ", fhtime="
				+ fhtime + ", lyr=" + lyr + ", lytime=" + lytime + ", test=" + test + ", phone="
				+ phone + ", cstime=" + cstime + ", tresult=" + tresult + "]";
	}

}
