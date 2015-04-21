package cn.slkj.slclgl.insurance.bean;

/**
 * 
 * @ClassName: Insurance
 * @Description: 保险实体对象
 * @author wangling
 * @date 2014年12月12日上午11:50:28
 */
public class InsuranceCompany {

	private Integer id;
	/**
	 * 承保单位
	 */
	private String companyName;   
	/**
	 * 简称
	 */
	private String shortName;
	
	/**
	 * 联系人
	 */
	private String linkman;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 地址
	 */
	private String address;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getLinkman() {
		return linkman;
	}
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
