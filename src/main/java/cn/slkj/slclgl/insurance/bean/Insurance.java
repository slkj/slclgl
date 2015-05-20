package cn.slkj.slclgl.insurance.bean;

/**
 * 
 * @ClassName: Insurance
 * @Description: 保险实体对象
 * @author wangling
 * @date 2014年12月12日上午11:50:28
 */
public class Insurance {

	private String id;
	/**
	 * 保单号
	 */
	private String policy;   
	/**
	 * 车牌号
	 */
	private String vid;
	/**
	 * 车牌号
	 */
	private String viotureNumber;
	
	
	/**
	 * 费用
	 */
	private String feiyong;
	/**
	 * 保险类型
	 */
	private String insuranceType;
	/**
	 * 投保日期
	 */
	private String riqi;
	/**
	 * 投保起止日期
	 */
	private String startTime;
	/**
	 * 投保起止日期
	 */
	private String endTime;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 受保人
	 */
	private String insurant;
	/**
	 * 受保人电话
	 */
	private String insurantPhone;
	/**
	 * 受保人地址
	 */
	private String insurantAddress;
	/**
	 * 保险类型
	 */
	private String typeName;
	/**
	 * 承保单位
	 */
	private String insuranceCompany;
	/**
	 * 承保单位
	 */
	private String companyName;
	/**
	 * 核保人
	 */
	private String checkMan;
	/**
	 * 制单人
	 */
	private String makeMan;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPolicy() {
		return policy;
	}
	public void setPolicy(String policy) {
		this.policy = policy;
	}
	
	public String getVid() {
		return vid;
	}
	public void setVid(String vid) {
		this.vid = vid;
	}
	
	
	public String getFeiyong() {
		return feiyong;
	}
	public void setFeiyong(String feiyong) {
		this.feiyong = feiyong;
	}
	public String getRiqi() {
		return riqi;
	}
	public void setRiqi(String riqi) {
		this.riqi = riqi;
	}
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	public String getInsuranceType() {
		return insuranceType;
	}
	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getInsurant() {
		return insurant;
	}
	public void setInsurant(String insurant) {
		this.insurant = insurant;
	}
	public String getInsurantPhone() {
		return insurantPhone;
	}
	public void setInsurantPhone(String insurantPhone) {
		this.insurantPhone = insurantPhone;
	}
	public String getInsurantAddress() {
		return insurantAddress;
	}
	public void setInsurantAddress(String insurantAddress) {
		this.insurantAddress = insurantAddress;
	}
	
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getInsuranceCompany() {
		return insuranceCompany;
	}
	public void setInsuranceCompany(String insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCheckMan() {
		return checkMan;
	}
	public void setCheckMan(String checkMan) {
		this.checkMan = checkMan;
	}
	public String getMakeMan() {
		return makeMan;
	}
	public void setMakeMan(String makeMan) {
		this.makeMan = makeMan;
	}
	public String getViotureNumber() {
		return viotureNumber;
	}
	public void setViotureNumber(String viotureNumber) {
		this.viotureNumber = viotureNumber;
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
	
	
	
}
