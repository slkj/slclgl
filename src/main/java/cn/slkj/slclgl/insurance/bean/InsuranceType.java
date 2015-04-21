package cn.slkj.slclgl.insurance.bean;

/**
 * 
 * @ClassName: InsuranceType
 * @Description: 保险类型实体对象
 * @author wangling
 * @date 2014年12月12日上午11:50:28
 */
public class InsuranceType {

	private Integer id;
	/**
	 * 保险类型
	 */
	private String typeName;   
	
	/**
	 * 备注
	 */
	private String remark;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
	
}
