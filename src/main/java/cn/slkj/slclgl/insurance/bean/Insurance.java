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
	 * 品牌
	 */
	private String carBrand;
	/**
	 * 型号
	 */
	private String carModel;
	/**
	 * 投保人名称
	 */
	private String regCompanyName;
	/**
	 * 车辆类型
	 */
	private String carType;
	/**
	 * 车架号
	 */
	private String carVin;
	/**
	 * 联系人
	 */
	private String carman;
	/**
	 * 联系电话
	 */
	private String carphone;
	/**
	 * 总质量
	 */
	private String carTotalmass;
	/**
	 * 使用性质
	 */
	private String carUseNatu;
	/**
	 * 发动机号
	 */
	private String carEngNum;
	/**
	 * 核定载客
	 */
	private String carApprGuest;
	/**
	 * 核定载重量
	 */
	private String carApproved;
	/**
	 * 排量
	 */
	private String carDisplacement;
	/**
	 * 功率
	 */
	private String carPower;
	/**
	 * 登记日期
	 */
	private String carCertDate;
	/**
	 * 费用
	 */
	private String feiyong;
	/**
	 * 保险类型
	 */
	private Integer insuranceType;
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
	private Integer insuranceCompany;
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
	public String getCarBrand() {
		return carBrand;
	}
	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}
	public String getRegCompanyName() {
		return regCompanyName;
	}
	public void setRegCompanyName(String regCompanyName) {
		this.regCompanyName = regCompanyName;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	
	public String getCarVin() {
		return carVin;
	}
	public void setCarVin(String carVin) {
		this.carVin = carVin;
	}
	public String getCarman() {
		return carman;
	}
	public void setCarman(String carman) {
		this.carman = carman;
	}
	public String getCarphone() {
		return carphone;
	}
	public void setCarphone(String carphone) {
		this.carphone = carphone;
	}
	
	public String getCarTotalmass() {
		return carTotalmass;
	}
	public void setCarTotalmass(String carTotalmass) {
		this.carTotalmass = carTotalmass;
	}
	
	
	public String getCarUseNatu() {
		return carUseNatu;
	}
	public void setCarUseNatu(String carUseNatu) {
		this.carUseNatu = carUseNatu;
	}
	public String getCarEngNum() {
		return carEngNum;
	}
	public void setCarEngNum(String carEngNum) {
		this.carEngNum = carEngNum;
	}
	public String getCarApprGuest() {
		return carApprGuest;
	}
	public void setCarApprGuest(String carApprGuest) {
		this.carApprGuest = carApprGuest;
	}
	public String getCarApproved() {
		return carApproved;
	}
	public void setCarApproved(String carApproved) {
		this.carApproved = carApproved;
	}
	public String getCarDisplacement() {
		return carDisplacement;
	}
	public void setCarDisplacement(String carDisplacement) {
		this.carDisplacement = carDisplacement;
	}
	public String getCarPower() {
		return carPower;
	}
	public void setCarPower(String carPower) {
		this.carPower = carPower;
	}
	public String getCarCertDate() {
		return carCertDate;
	}
	public void setCarCertDate(String carCertDate) {
		this.carCertDate = carCertDate;
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
	
	
	public Integer getInsuranceType() {
		return insuranceType;
	}
	public void setInsuranceType(Integer insuranceType) {
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
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Integer getInsuranceCompany() {
		return insuranceCompany;
	}
	public void setInsuranceCompany(Integer insuranceCompany) {
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
	
	
	
}
