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
package cn.slkj.slclgl.after.bean;

import java.util.List;

public class Phone{
	//基本信息
	 private String id;
	 private String company;//客户公司
	 private String linkman;//联系人
	 private String telephone;//联系方式
	 private String address;//地址
	 private String serviceType;//服务类型
	 private String serviceStatus;//服务状态
	 private String error;//故障
	 private String serviceRiqi;//派单时间
	 private String serviceMan;//服务人员
	 private String result;//处理结果
	 private String riqi;//接听时间
	 private String remark;//备注
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getLinkman() {
		return linkman;
	}
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getServiceStatus() {
		return serviceStatus;
	}
	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getServiceRiqi() {
		return serviceRiqi;
	}
	public void setServiceRiqi(String serviceRiqi) {
		this.serviceRiqi = serviceRiqi;
	}
	public String getServiceMan() {
		return serviceMan;
	}
	public void setServiceMan(String serviceMan) {
		this.serviceMan = serviceMan;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
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
	 


	
	
}