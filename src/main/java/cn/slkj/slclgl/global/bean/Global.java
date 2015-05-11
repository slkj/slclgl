package cn.slkj.slclgl.global.bean;

/**
 * 卫星服务实体对象
 * 
 * @author maxh
 *
 */
public class Global {
	private String id;
	/**
	 * 车辆外键id
	 */
	private String vId;
	/**
	 * 车牌号
	 */
	private String carNumber;
	/**
	 * 联系人
	 */
	private String contacts;
	/**
	 * 联系电话
	 */
	private String contactsTel;
	/**
	 * 车辆种类
	 */
	private String classify;
	/**
	 * 车辆类型 
	 */
	private String carType;
	/**
	 * 所属公司
	 */
	private String companyName;
	/**
	 * 设备号
	 */
	private String equitment;
	/**
	 * SIM卡
	 */
	private String simNumber;
	/**
	 * 运营商
	 */
	private String facilitator;
	/**
	 * 入网证明编号 
	 */
	private String networkNo;
	/**
	 * 安装证明编号
	 */
	private String azzm;
	/**
	 * 安装日期
	 */
	private String installtime;

	/**
	 * 安装人
	 */
	private String installer;
	/**
	 * 安装地点
	 */
	private String insAdderss;

	/**
	 * 维保日期
	 */
	private String endriqi;

	/**
	 * 备注
	 */
	private String remark;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getvId() {
		return vId;
	}

	public void setvId(String vId) {
		this.vId = vId;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getContactsTel() {
		return contactsTel;
	}

	public void setContactsTel(String contactsTel) {
		this.contactsTel = contactsTel;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getEquitment() {
		return equitment;
	}

	public void setEquitment(String equitment) {
		this.equitment = equitment;
	}

	public String getSimNumber() {
		return simNumber;
	}

	public void setSimNumber(String simNumber) {
		this.simNumber = simNumber;
	}

	public String getFacilitator() {
		return facilitator;
	}

	public void setFacilitator(String facilitator) {
		this.facilitator = facilitator;
	}

	public String getNetworkNo() {
		return networkNo;
	}

	public void setNetworkNo(String networkNo) {
		this.networkNo = networkNo;
	}

	public String getAzzm() {
		return azzm;
	}

	public void setAzzm(String azzm) {
		this.azzm = azzm;
	}

	public String getInstalltime() {
		return installtime;
	}

	public void setInstalltime(String installtime) {
		this.installtime = installtime;
	}

	public String getInstaller() {
		return installer;
	}

	public void setInstaller(String installer) {
		this.installer = installer;
	}

	public String getEndriqi() {
		return endriqi;
	}

	public void setEndriqi(String endriqi) {
		this.endriqi = endriqi;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public String getInsAdderss() {
		return insAdderss;
	}

	public void setInsAdderss(String insAdderss) {
		this.insAdderss = insAdderss;
	}

	@Override
	public String toString() {
		return "Global [id=" + id + ", vId=" + vId + ", carNumber=" + carNumber + ", contacts="
				+ contacts + ", contactsTel=" + contactsTel + ", classify=" + classify
				+ ", carType=" + carType + ", companyName=" + companyName + ", equitment="
				+ equitment + ", simNumber=" + simNumber + ", facilitator=" + facilitator
				+ ", networkNo=" + networkNo + ", azzm=" + azzm + ", installtime=" + installtime
				+ ", installer=" + installer + ", endriqi=" + endriqi + ", remark=" + remark + "]";
	}

}
