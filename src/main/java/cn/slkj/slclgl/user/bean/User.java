package cn.slkj.slclgl.user.bean;

import java.io.Serializable;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	/**
	 * 登录账号
	 */
	private String username;
	/**
	 * 登录密码
	 */
	private String password;
	/**
	 * 使用状态
	 */
	private String status = "enabled";
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 真实姓名
	 */
	private String realname;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 联系电话
	 */
	private String phone;
	/**
	 * 所属公司id
	 */
	private String company;
	/**
	 * 所属公司名称
	 */
	private String companyName;
	/**
	 * 所属部门编码
	 */
	private String departcode;
	/**
	 * 所属部门名称
	 */
	private String departName;
	/**
	 * 创建时间
	 */
	private String create_time;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 最后登录时间
	 */
	private String lastTime;
	/**
	 * 有效时间
	 */
	private String validTime;
	/**
	 * 角色id
	 */
	private String roleId;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getValidTime() {
		return validTime;
	}

	public void setValidTime(String validTime) {
		this.validTime = validTime;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public User() {
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDepartcode() {
		return departcode;
	}

	public void setDepartcode(String departcode) {
		this.departcode = departcode;
	}

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getLastTime() {
		return lastTime;
	}

	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", status="
				+ status + ", email=" + email + ", realname=" + realname + ", sex=" + sex
				+ ", phone=" + phone + ", company=" + company + ", companyName=" + companyName
				+ ", departcode=" + departcode + ", departName=" + departName + ", create_time="
				+ create_time + ", remark=" + remark + ", lastTime=" + lastTime + ", validTime="
				+ validTime + ", roleId=" + roleId + ", type=" + type + "]";
	}

}
