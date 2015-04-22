package cn.slkj.slclgl.insurance.bean;

/**
 * 
 * @ClassName: Mature
 * @Description: 到期实体对象
 * @author wangling
 * @date 2014年12月12日上午11:50:28
 */
public class Mature {

	private String id;
	/**
	 * 车牌号
	 */
	private String carnumber;
	
	/**
	 * 投保日期
	 */
	private String dueriqi;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCarnumber() {
		return carnumber;
	}

	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}

	public String getDueriqi() {
		return dueriqi;
	}

	public void setDueriqi(String dueriqi) {
		this.dueriqi = dueriqi;
	}

	@Override
	public String toString() {
		return "Mature [id=" + id + ", carnumber=" + carnumber + ", dueriqi=" + dueriqi + "]";
	}
	
	
	
	
}
