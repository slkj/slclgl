package cn.slkj.slclgl.second.bean;

/**
 * 
 * @ClassName: SecondInsurance
 * @Description: 二保实体对象
 * @author wangling
 * @date 2014年12月12日上午11:50:28
 */
public class SecondInsurance {

	private String id;
	 
	/**
	 * 车牌号
	 */
	private String vid;
	/**
	 * 车牌号
	 */
	private String viotureNumber;
	
	/**
	 * 上次维修日期
	 */
	private String lastriqi;
	/**
	 * 维护日期
	 */
	private String riqi;
	/**
	 * 下次维护日期
	 */
	private String nextriqi;
	/**
	 * 使用年限
	 */
	private String life;
	/**
	 * 本次年审日期
	 */
	private String examine;
	/**
	 * 保养地点
	 */
	private String keepaddress;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	public String getVid() {
		return vid;
	}
	public void setVid(String vid) {
		this.vid = vid;
	}
	
	public String getLastriqi() {
		return lastriqi;
	}
	public void setLastriqi(String lastriqi) {
		this.lastriqi = lastriqi;
	}
	public String getRiqi() {
		return riqi;
	}
	public void setRiqi(String riqi) {
		this.riqi = riqi;
	}
	
	public String getNextriqi() {
		return nextriqi;
	}
	public void setNextriqi(String nextriqi) {
		this.nextriqi = nextriqi;
	}
	
	public String getLife() {
		return life;
	}
	public void setLife(String life) {
		this.life = life;
	}
	public String getExamine() {
		return examine;
	}
	public void setExamine(String examine) {
		this.examine = examine;
	}
	public String getKeepaddress() {
		return keepaddress;
	}
	public void setKeepaddress(String keepaddress) {
		this.keepaddress = keepaddress;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	
}
