/**   
 * @Title: package-info.java 
 * @Package cn.slkj.clgl.driver.entity 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author zhangtc   
 * @date 2014年12月9日 下午2:12:36 
 */
/** 
 * @ClassName: package-info 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author zhangtc
 * @date 2014年12月9日 下午2:12:36 
 *  
 */
package cn.slkj.slclgl.person.bean;

import java.util.List;

public class Person{
	//基本信息
	 private String id;
	 private String name;
	 private String idcard_no;		//身份证
	 private String nation;//民族
	 private String sex;
	 private String birth;
	 private String home;//籍贯
	 private String telephone;
	 private String email;
	 private String political;//;政治面貌
	 private String education;//文化程度
	 private String work_status;//从业状态
	 private String photo;//个人头像

	 
	 private String fwcl;//现服务车辆
	 //驾驶证
	 private String driver_authority;//发证机关
	 private String driver_no;//驾驶证号
	 private String driver_car_type;//准驾车型
	 private String driver_record_no;//档案编号
	 private String driver_certify_time;//领证时期
	 private String driver_begin_time;//驾发证有效期始
	 private String driver_end_time;//驾发证有效期末
	 private String driver_years;
	 private String address;//联系地址
	 private String bussiness_no;//经验许可证号
	 
	 private List<Driver_record> records;
	 //从业资格证
	 private String quali_record_no;//档案编号
	 private String quali_authority;//发证机关
	 private String qualification_no;//从业资格证号
	 private String quali_certify_time;//从业资格证领证日期资
	 private String quali_begin_time;//从业资格证开始日期
	 private String quali_end_time;//从业资格证结束日期
	 private String qualification_type;//从业格类别1驾驶 2亚运 3乘务
	 private String quali_kind;//从业资格证类别
	 private  List<Server_unit> units;   //服务单位
	 //服务单位
	 private String unit_name;//服务单位
	 private String unit_tel;//单位电话
	 private String unit_address;//单位地址
	 private String unit_time;//记录日期
	 //操作信息
	 private String uid;//操作人
	 private String riqi;//操作时间
	 private String companyid;//所属公司
	 private String companyname;//所属公司
	 

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdcard_no() {
		return idcard_no;
	}

	public void setIdcard_no(String idcard_no) {
		this.idcard_no = idcard_no;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPolitical() {
		return political;
	}

	public void setPolitical(String political) {
		this.political = political;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getWork_status() {
		return work_status;
	}

	public void setWork_status(String work_status) {
		this.work_status = work_status;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getDriver_authority() {
		return driver_authority;
	}

	public void setDriver_authority(String driver_authority) {
		this.driver_authority = driver_authority;
	}

	public String getDriver_no() {
		return driver_no;
	}

	public void setDriver_no(String driver_no) {
		this.driver_no = driver_no;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBussiness_no() {
		return bussiness_no;
	}

	public void setBussiness_no(String bussiness_no) {
		this.bussiness_no = bussiness_no;
	}


	public String getDriver_car_type() {
		return driver_car_type;
	}

	public void setDriver_car_type(String driver_car_type) {
		this.driver_car_type = driver_car_type;
	}

	public String getDriver_record_no() {
		return driver_record_no;
	}

	public void setDriver_record_no(String driver_record_no) {
		this.driver_record_no = driver_record_no;
	}

	public String getDriver_certify_time() {
		return driver_certify_time;
	}

	public void setDriver_certify_time(String driver_certify_time) {
		this.driver_certify_time = driver_certify_time;
	}

	public String getDriver_begin_time() {
		return driver_begin_time;
	}

	public void setDriver_begin_time(String driver_begin_time) {
		this.driver_begin_time = driver_begin_time;
	}

	public String getDriver_end_time() {
		return driver_end_time;
	}

	public void setDriver_end_time(String driver_end_time) {
		this.driver_end_time = driver_end_time;
	}

	public String getDriver_years() {
		return driver_years;
	}

	public void setDriver_years(String driver_years) {
		this.driver_years = driver_years;
	}

	public List<Driver_record> getRecords() {
		return records;
	}

	public void setRecords(List<Driver_record> records) {
		this.records = records;
	}

	public String getQuali_record_no() {
		return quali_record_no;
	}

	public void setQuali_record_no(String quali_record_no) {
		this.quali_record_no = quali_record_no;
	}

	public String getQuali_authority() {
		return quali_authority;
	}

	public void setQuali_authority(String quali_authority) {
		this.quali_authority = quali_authority;
	}

	public String getQualification_no() {
		return qualification_no;
	}

	public void setQualification_no(String qualification_no) {
		this.qualification_no = qualification_no;
	}

	public String getQuali_certify_time() {
		return quali_certify_time;
	}

	public void setQuali_certify_time(String quali_certify_time) {
		this.quali_certify_time = quali_certify_time;
	}

	public String getQuali_begin_time() {
		return quali_begin_time;
	}

	public void setQuali_begin_time(String quali_begin_time) {
		this.quali_begin_time = quali_begin_time;
	}

	public String getQuali_end_time() {
		return quali_end_time;
	}

	public void setQuali_end_time(String quali_end_time) {
		this.quali_end_time = quali_end_time;
	}

	public String getQualification_type() {
		return qualification_type;
	}

	public void setQualification_type(String qualification_type) {
		this.qualification_type = qualification_type;
	}

	public List<Server_unit> getUnits() {
		return units;
	}

	public void setUnits(List<Server_unit> units) {
		this.units = units;
	}

	public String getFwcl() {
		return fwcl;
	}

	public void setFwcl(String fwcl) {
		this.fwcl = fwcl;
	}

	public String getQuali_kind() {
		return quali_kind;
	}

	public void setQuali_kind(String quali_kind) {
		this.quali_kind = quali_kind;
	}

	public String getUnit_name() {
		return unit_name;
	}

	public void setUnit_name(String unit_name) {
		this.unit_name = unit_name;
	}

	public String getUnit_tel() {
		return unit_tel;
	}

	public void setUnit_tel(String unit_tel) {
		this.unit_tel = unit_tel;
	}

	public String getUnit_address() {
		return unit_address;
	}

	public void setUnit_address(String unit_address) {
		this.unit_address = unit_address;
	}

	public String getUnit_time() {
		return unit_time;
	}

	public void setUnit_time(String unit_time) {
		this.unit_time = unit_time;
	}
	

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getRiqi() {
		return riqi;
	}

	public void setRiqi(String riqi) {
		this.riqi = riqi;
	}

	public String getCompanyid() {
		return companyid;
	}

	public void setCompanyid(String companyid) {
		this.companyid = companyid;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	

	
	
}