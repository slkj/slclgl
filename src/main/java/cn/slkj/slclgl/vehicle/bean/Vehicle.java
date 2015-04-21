/**
 * 
 */
package cn.slkj.slclgl.vehicle.bean;

/**
 * @author maxh
 *
 */
public class Vehicle {

	private String id;
	/**
	 * 所属公司
	 */
	private String companyId;
	private String companyName;
	/**
	 * 业户/车主
	 */
	private String carOwner;
	/**
	 * 证明类型
	 */
	private String carOwnersType;
	/**
	 * 证明号码
	 */
	private String carOwnersCard;
	/**
	 * 联系人
	 */
	private String contacts;
	/**
	 * 联系方式
	 */
	private String contactsTel;
	/**
	 * 车牌号(主)
	 */
	private String carNumber;
	/**
	 * 车牌号(挂)
	 */
	private String carNumberG;
	/**
	 * 车牌颜色
	 */
	private String plateColor;
	/**
	 * 车辆类型
	 */
	private String classify;
	/**
	 * 车辆类型
	 */
	private String carType;
	/**
	 * 车辆品牌
	 */
	private String carBrand;

	/**
	 * 辆型号
	 */
	private String carModel;
	/**
	 * 车身颜色
	 */
	private String carColor;
	/**
	 * 车辆识别代号/车架号
	 */
	private String carVin;
	/**
	 * 国产/进口
	 */
	private String carProType;
	
	/**
	 * 外廓尺寸(长)
	 */
	private String carOutLength;
	/**
	 * 外廓尺寸(宽)
	 */
	private String carOutWidth;
	/**
	 * 外廓尺寸(高)
	 */
	private String carOutHeight;
	/**
	 * 总质量
	 */
	private String carTotalmass;
	/**
	 * 发动机号
	 */
	private String carEngNum;
	/**
	 * 发动机型号
	 */
	private String carEngModel;
	/**
	 * 燃料种类
	 */
	private String carFuelType;
	/**
	 * 排量
	 */
	private String carDisplacement;
	/**
	 * 功率
	 */
	private String carPower;
	/**
	 * 制造厂名称
	 */
	private String carManuName;
	/**
	 * 转向形式
	 */
	private String carModality;
	/**
	 * 轮距(前)
	 */
	private String carTreadBe;
	/**
	 * 轮距(后)
	 */
	private String carTreadAfter;
	/**
	 * 轮胎数
	 */
	private String carTireNum;
	/**
	 * 轮胎规格
	 */
	private String carTireSpe;
	/**
	 * 钢板弹簧片数
	 */
	private String carNumOfSpring;
	/**
	 * 轴距
	 */
	private String carAxleDist;
	/**
	 * 轴数
	 */
	private String carAxleNum;
	
	/**
	 * 货箱内部尺寸(长)
	 */
	private String carContLength;
	/**
	 * 货箱内部尺寸(宽)
	 */
	private String carContWidth;
	/**
	 * 货箱内部尺寸(高)
	 */
	private String carContHeight;

	/**
	 * 核定载质量(吨位/座位)
	 */
	private String carApproved;
	/**
	 * 核定载客
	 */
	private String carApprGuest;
	/**
	 * 准牵引总质量
	 */
	private String carTrac;
	/**
	 * 驾驶室载客
	 */
	private String carCabGuest;
	/**
	 * 使用性质
	 */
	private String carUseNatu;
	/**
	 * 使用性质
	 */
	private String carUseNatuName;
	/**
	 * 车辆获取方式
	 */
	private String carObtWay;
	/**
	 * 车辆出厂日期
	 */
	private String carFacDate;
	/**
	 * 设备号
	 */
	private String equitment;
	/**
	 * sim 卡号
	 */
	private String simNumber;
	/**
	 * 入网证明编号 
	 */
	private String networkNo;
	/**
	 * 安装人
	 */
	private String installers;
	/**
	 * 服务人员
	 */
	private String attendants;
	/**
	 * 安装日期
	 */
	private String installtime;
	/**
	 * 安装地点
	 */
	private String installAddress;
	/**
	 * 服务费
	 */
	private String fees;
	/**
	 * 服务到期时间
	 */
	private String feeseEnd;
	/**
	 * 到期提醒
	 */
	private String isNotice;
	/**
	 * SIM卡缴费人
	 */
	private String simPayer;
	/**
	 * 缴费时间
	 */
	private String payerTime;
	/**
	 * 营运线路
	 */
	private String CTradingLine;
	/**
	 * 载客数
	 */
	private String CCatchMenbers;

	/**
	 * 车辆正面彩色照片
	 */
	private String carImg;
	/**
	 * 录入时间
	 */
	private String entryTime;
	/**
	 * 录入人id
	 */
	private String entryId;
	/**
	 * 录入人名称
	 */
	private String entryName;
	/**
	 * 录入人单位
	 */
	private String depId;
	
	private String remark;
	
	/**
	 * 省
	 */
	private String areaCode;
	/**
	 * 市
	 */
	private String cityId;
	/**
	 * 县
	 */
	private String county;
	
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCarOwner() {
		return carOwner;
	}
	public void setCarOwner(String carOwner) {
		this.carOwner = carOwner;
	}
	public String getCarOwnersType() {
		return carOwnersType;
	}
	public void setCarOwnersType(String carOwnersType) {
		this.carOwnersType = carOwnersType;
	}
	public String getCarOwnersCard() {
		return carOwnersCard;
	}
	public void setCarOwnersCard(String carOwnersCard) {
		this.carOwnersCard = carOwnersCard;
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
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public String getCarNumberG() {
		return carNumberG;
	}
	public void setCarNumberG(String carNumberG) {
		this.carNumberG = carNumberG;
	}
	public String getPlateColor() {
		return plateColor;
	}
	public void setPlateColor(String plateColor) {
		this.plateColor = plateColor;
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
	public String getCarBrand() {
		return carBrand;
	}
	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public String getCarColor() {
		return carColor;
	}
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	public String getCarVin() {
		return carVin;
	}
	public void setCarVin(String carVin) {
		this.carVin = carVin;
	}
	public String getCarProType() {
		return carProType;
	}
	public void setCarProType(String carProType) {
		this.carProType = carProType;
	}
	public String getCarOutLength() {
		return carOutLength;
	}
	public void setCarOutLength(String carOutLength) {
		this.carOutLength = carOutLength;
	}
	public String getCarOutWidth() {
		return carOutWidth;
	}
	public void setCarOutWidth(String carOutWidth) {
		this.carOutWidth = carOutWidth;
	}
	public String getCarOutHeight() {
		return carOutHeight;
	}
	public void setCarOutHeight(String carOutHeight) {
		this.carOutHeight = carOutHeight;
	}
	public String getCarTotalmass() {
		return carTotalmass;
	}
	public void setCarTotalmass(String carTotalmass) {
		this.carTotalmass = carTotalmass;
	}
	public String getCarEngNum() {
		return carEngNum;
	}
	public void setCarEngNum(String carEngNum) {
		this.carEngNum = carEngNum;
	}
	public String getCarEngModel() {
		return carEngModel;
	}
	public void setCarEngModel(String carEngModel) {
		this.carEngModel = carEngModel;
	}
	public String getCarFuelType() {
		return carFuelType;
	}
	public void setCarFuelType(String carFuelType) {
		this.carFuelType = carFuelType;
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
	public String getCarManuName() {
		return carManuName;
	}
	public void setCarManuName(String carManuName) {
		this.carManuName = carManuName;
	}
	public String getCarModality() {
		return carModality;
	}
	public void setCarModality(String carModality) {
		this.carModality = carModality;
	}
	public String getCarTreadBe() {
		return carTreadBe;
	}
	public void setCarTreadBe(String carTreadBe) {
		this.carTreadBe = carTreadBe;
	}
	public String getCarTreadAfter() {
		return carTreadAfter;
	}
	public void setCarTreadAfter(String carTreadAfter) {
		this.carTreadAfter = carTreadAfter;
	}
	public String getCarTireNum() {
		return carTireNum;
	}
	public void setCarTireNum(String carTireNum) {
		this.carTireNum = carTireNum;
	}
	public String getCarTireSpe() {
		return carTireSpe;
	}
	public void setCarTireSpe(String carTireSpe) {
		this.carTireSpe = carTireSpe;
	}
	public String getCarNumOfSpring() {
		return carNumOfSpring;
	}
	public void setCarNumOfSpring(String carNumOfSpring) {
		this.carNumOfSpring = carNumOfSpring;
	}
	public String getCarAxleDist() {
		return carAxleDist;
	}
	public void setCarAxleDist(String carAxleDist) {
		this.carAxleDist = carAxleDist;
	}
	public String getCarAxleNum() {
		return carAxleNum;
	}
	public void setCarAxleNum(String carAxleNum) {
		this.carAxleNum = carAxleNum;
	}
	public String getCarContLength() {
		return carContLength;
	}
	public void setCarContLength(String carContLength) {
		this.carContLength = carContLength;
	}
	public String getCarContWidth() {
		return carContWidth;
	}
	public void setCarContWidth(String carContWidth) {
		this.carContWidth = carContWidth;
	}
	public String getCarContHeight() {
		return carContHeight;
	}
	public void setCarContHeight(String carContHeight) {
		this.carContHeight = carContHeight;
	}
	public String getCarApproved() {
		return carApproved;
	}
	public void setCarApproved(String carApproved) {
		this.carApproved = carApproved;
	}
	public String getCarApprGuest() {
		return carApprGuest;
	}
	public void setCarApprGuest(String carApprGuest) {
		this.carApprGuest = carApprGuest;
	}
	public String getCarTrac() {
		return carTrac;
	}
	public void setCarTrac(String carTrac) {
		this.carTrac = carTrac;
	}
	public String getCarCabGuest() {
		return carCabGuest;
	}
	public void setCarCabGuest(String carCabGuest) {
		this.carCabGuest = carCabGuest;
	}
	public String getCarUseNatu() {
		return carUseNatu;
	}
	public void setCarUseNatu(String carUseNatu) {
		this.carUseNatu = carUseNatu;
	}
	public String getCarUseNatuName() {
		return carUseNatuName;
	}
	public void setCarUseNatuName(String carUseNatuName) {
		this.carUseNatuName = carUseNatuName;
	}
	public String getCarObtWay() {
		return carObtWay;
	}
	public void setCarObtWay(String carObtWay) {
		this.carObtWay = carObtWay;
	}
	public String getCarFacDate() {
		return carFacDate;
	}
	public void setCarFacDate(String carFacDate) {
		this.carFacDate = carFacDate;
	}
	public String getInstallers() {
		return installers;
	}
	public void setInstallers(String installers) {
		this.installers = installers;
	}
	public String getAttendants() {
		return attendants;
	}
	public void setAttendants(String attendants) {
		this.attendants = attendants;
	}
	public String getInstalltime() {
		return installtime;
	}
	public void setInstalltime(String installtime) {
		this.installtime = installtime;
	}
	public String getInstallAddress() {
		return installAddress;
	}
	public void setInstallAddress(String installAddress) {
		this.installAddress = installAddress;
	}
	public String getFees() {
		return fees;
	}
	public void setFees(String fees) {
		this.fees = fees;
	}
	public String getFeeseEnd() {
		return feeseEnd;
	}
	public void setFeeseEnd(String feeseEnd) {
		this.feeseEnd = feeseEnd;
	}
	public String getIsNotice() {
		return isNotice;
	}
	public void setIsNotice(String isNotice) {
		this.isNotice = isNotice;
	}
	public String getSimPayer() {
		return simPayer;
	}
	public void setSimPayer(String simPayer) {
		this.simPayer = simPayer;
	}
	public String getPayerTime() {
		return payerTime;
	}
	public void setPayerTime(String payerTime) {
		this.payerTime = payerTime;
	}
	public String getCTradingLine() {
		return CTradingLine;
	}
	public void setCTradingLine(String cTradingLine) {
		CTradingLine = cTradingLine;
	}
	public String getCCatchMenbers() {
		return CCatchMenbers;
	}
	public void setCCatchMenbers(String cCatchMenbers) {
		CCatchMenbers = cCatchMenbers;
	}
	public String getCarImg() {
		return carImg;
	}
	public void setCarImg(String carImg) {
		this.carImg = carImg;
	}
	public String getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}
	public String getEntryId() {
		return entryId;
	}
	public void setEntryId(String entryId) {
		this.entryId = entryId;
	}
	public String getEntryName() {
		return entryName;
	}
	public void setEntryName(String entryName) {
		this.entryName = entryName;
	}
	public String getDepId() {
		return depId;
	}
	public void setDepId(String depId) {
		this.depId = depId;
	}
	public String getSimNumber() {
		return simNumber;
	}
	public void setSimNumber(String simNumber) {
		this.simNumber = simNumber;
	}
	public String getEquitment() {
		return equitment;
	}
	public void setEquitment(String equitment) {
		this.equitment = equitment;
	}
	public String getNetworkNo() {
		return networkNo;
	}
	public void setNetworkNo(String networkNo) {
		this.networkNo = networkNo;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", carNumber=" + carNumber + ", equitment=" + equitment
				+ ", simNumber=" + simNumber + ", installtime=" + installtime + "]";
	}
	
}
