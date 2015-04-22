package cn.slkj.slclgl.devices.bean;

public class Devices_record {
	private String devices_id;
	private String fhtime;
	private String remark;
	public String getDevices_id() {
		return devices_id;
	}
	public void setDevices_id(String devices_id) {
		this.devices_id = devices_id;
	}
	
	public String getFhtime() {
		return fhtime;
	}
	public void setFhtime(String fhtime) {
		this.fhtime = fhtime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Devices_record [devices_id=" + devices_id + ", fhtime=" + fhtime + ", remark="
				+ remark + "]";
	}
	
}
