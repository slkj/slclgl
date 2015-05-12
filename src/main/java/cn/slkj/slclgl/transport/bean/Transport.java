package cn.slkj.slclgl.transport.bean;


/**
 * 行驶证年检
 * 
 * @author maxh
 *
 */
public class Transport {

	/**
	 * 编号
	 */
	private String id;
	
	/**
	 * 车辆信息外键
	 */
	private String vId;
	/**
	 * 车牌号
	 */
	private String carNumber;
	/**
	 * 冀交运管 字
	 */
	private String traWord;
	/**
	 * 冀交运管 号
	 */
	private String traCode;
	/**
	 * 经营许可证
	 */
	private String traBusLicNo;
	/**
	 * 经营许可证核发日期
	 */
	private String traBusLicDate;
	/**
	 * 经济类型
	 */
	private String traEcoType;
	/**
	 * 备注
	 */
	private String remark;	
	
	/**
	 * 检测机关
	 */
	private String testOrgan;
	/**
	 * 到期日期
	 */
	private String endDate;
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
	public String getTraWord() {
		return traWord;
	}
	public void setTraWord(String traWord) {
		this.traWord = traWord;
	}
	public String getTraCode() {
		return traCode;
	}
	public void setTraCode(String traCode) {
		this.traCode = traCode;
	}
	public String getTraBusLicNo() {
		return traBusLicNo;
	}
	public void setTraBusLicNo(String traBusLicNo) {
		this.traBusLicNo = traBusLicNo;
	}
	public String getTraBusLicDate() {
		return traBusLicDate;
	}
	public void setTraBusLicDate(String traBusLicDate) {
		this.traBusLicDate = traBusLicDate;
	}
	public String getTraEcoType() {
		return traEcoType;
	}
	public void setTraEcoType(String traEcoType) {
		this.traEcoType = traEcoType;
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
	
	
}
