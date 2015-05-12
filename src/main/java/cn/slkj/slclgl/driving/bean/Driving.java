package cn.slkj.slclgl.driving.bean;


/**
 * 行驶证年检
 * 
 * @author maxh
 *
 */
public class Driving {

	/**
	 * 编号
	 */
	private String id;
	/**
	 * 档案编号
	 */
	private String fileNumber;
	/**
	 * 车辆信息外键
	 */
	private String vId;
	/**
	 * 车牌号
	 */
	private String carNumber;
	/**
	 * 检测机关
	 */
	private String testOrgan;
	/**
	 * 到期日期
	 */
	private String endDate;
	
	/**
	 * 注册日期
	 */
	private String driRegDate;
	/**
	 * 发证时间
	 */
	private String driCertDate;
	/**
	 * 强制报废期止
	 */
	private String baoFeiDate;
	/**
	 * 备注
	 */
	private String remark;
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

	public String getFileNumber() {
		return fileNumber;
	}

	public void setFileNumber(String fileNumber) {
		this.fileNumber = fileNumber;
	}

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

	public String getDriRegDate() {
		return driRegDate;
	}

	public void setDriRegDate(String driRegDate) {
		this.driRegDate = driRegDate;
	}

	public String getDriCertDate() {
		return driCertDate;
	}

	public void setDriCertDate(String driCertDate) {
		this.driCertDate = driCertDate;
	}

	public String getBaoFeiDate() {
		return baoFeiDate;
	}

	public void setBaoFeiDate(String baoFeiDate) {
		this.baoFeiDate = baoFeiDate;
	}


	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getTestOrgan() {
		return testOrgan;
	}

	public void setTestOrgan(String testOrgan) {
		this.testOrgan = testOrgan;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
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

	@Override
	public String toString() {
		return "Driving [id=" + id + ", fileNumber=" + fileNumber + ", vId=" + vId + ", carNumber="
				+ carNumber + ", testOrgan=" + testOrgan + ", endDate=" + endDate + ", driRegDate="
				+ driRegDate + ", driCertDate=" + driCertDate + ", baoFeiDate=" + baoFeiDate
				+ ", introd=" + remark + "]";
	}
	
}
