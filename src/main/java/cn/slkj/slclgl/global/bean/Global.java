package cn.slkj.slclgl.global.bean;

/**
 * 卫星服务实体对象
 * 
 * @author maxh
 *
 */
public class Global {

	private String id;
	/**
	 * 车辆外键id
	 */
	private String vId;
	/**
	 * 车牌号
	 */
	private String carNumber;

	/**
	 * 登记日期
	 */
	private String carCertDate;
	/**
	 * 运营商
	 */
	private String facilitator;
	/**
	 * 服务电话
	 */
	private String phone;
	/**
	 * 安装单位
	 */
	private String install;
	/**
	 * 安装人员
	 */
	private String installer;
	/**
	 * 安装日期
	 */
	private String installriqi;
	/**
	 * 前置/使用
	 */
	private String qzsy;
	/**
	 * 终端型号
	 */
	private String zdtype;
	/**
	 * 车载终端ID
	 */
	private String zdid;
	/**
	 * SIM卡号
	 */
	private String sim;
	/**
	 * 正电源
	 */
	private String zdy;
	/**
	 * 负电源
	 */
	private String fdy;
	/**
	 * acc线
	 */
	private String acc;
	/**
	 * 刹车线
	 */
	private String scx;
	/**
	 * 左转向
	 */
	private String zzx;
	/**
	 * 右转向
	 */
	private String yzx;
	/**
	 * 远光灯
	 */
	private String ygd;
	/**
	 * 近光灯
	 */
	private String jgd;
	/**
	 * 维保日期
	 */
	private String endriqi;
	/**
	 * 安装证明编号
	 */
	private String azzm;

	/**
	 * 证明编号
	 */
	private String qzsyzm;

	/**
	 * 备注
	 */
	private String remark;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getvId() {
		return vId;
	}

	public void setvId(String vId) {
		this.vId = vId;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getCarCertDate() {
		return carCertDate;
	}

	public void setCarCertDate(String carCertDate) {
		this.carCertDate = carCertDate;
	}

	public String getFacilitator() {
		return facilitator;
	}

	public void setFacilitator(String facilitator) {
		this.facilitator = facilitator;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getInstall() {
		return install;
	}

	public void setInstall(String install) {
		this.install = install;
	}

	public String getInstaller() {
		return installer;
	}

	public void setInstaller(String installer) {
		this.installer = installer;
	}

	public String getInstallriqi() {
		return installriqi;
	}

	public void setInstallriqi(String installriqi) {
		this.installriqi = installriqi;
	}

	public String getQzsy() {
		return qzsy;
	}

	public void setQzsy(String qzsy) {
		this.qzsy = qzsy;
	}

	public String getZdtype() {
		return zdtype;
	}

	public void setZdtype(String zdtype) {
		this.zdtype = zdtype;
	}

	public String getZdid() {
		return zdid;
	}

	public void setZdid(String zdid) {
		this.zdid = zdid;
	}

	public String getSim() {
		return sim;
	}

	public void setSim(String sim) {
		this.sim = sim;
	}

	public String getZdy() {
		return zdy;
	}

	public void setZdy(String zdy) {
		this.zdy = zdy;
	}

	public String getFdy() {
		return fdy;
	}

	public void setFdy(String fdy) {
		this.fdy = fdy;
	}

	public String getAcc() {
		return acc;
	}

	public void setAcc(String acc) {
		this.acc = acc;
	}

	public String getScx() {
		return scx;
	}

	public void setScx(String scx) {
		this.scx = scx;
	}

	public String getZzx() {
		return zzx;
	}

	public void setZzx(String zzx) {
		this.zzx = zzx;
	}

	public String getYzx() {
		return yzx;
	}

	public void setYzx(String yzx) {
		this.yzx = yzx;
	}

	public String getYgd() {
		return ygd;
	}

	public void setYgd(String ygd) {
		this.ygd = ygd;
	}

	public String getJgd() {
		return jgd;
	}

	public void setJgd(String jgd) {
		this.jgd = jgd;
	}

	public String getEndriqi() {
		return endriqi;
	}

	public void setEndriqi(String endriqi) {
		this.endriqi = endriqi;
	}

	public String getAzzm() {
		return azzm;
	}

	public void setAzzm(String azzm) {
		this.azzm = azzm;
	}

	public String getQzsyzm() {
		return qzsyzm;
	}

	public void setQzsyzm(String qzsyzm) {
		this.qzsyzm = qzsyzm;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Global [id=" + id + ", vId=" + vId + ", carNumber=" + carNumber + ", carCertDate="
				+ carCertDate + ", facilitator=" + facilitator + ", phone=" + phone + ", install="
				+ install + ", installer=" + installer + ", installriqi=" + installriqi + ", qzsy="
				+ qzsy + ", zdtype=" + zdtype + ", zdid=" + zdid + ", sim=" + sim + ", zdy=" + zdy
				+ ", fdy=" + fdy + ", acc=" + acc + ", scx=" + scx + ", zzx=" + zzx + ", yzx="
				+ yzx + ", ygd=" + ygd + ", jgd=" + jgd + ", endriqi=" + endriqi + ", azzm=" + azzm
				+ ", qzsyzm=" + qzsyzm + ", remark=" + remark + "]";
	}


}
