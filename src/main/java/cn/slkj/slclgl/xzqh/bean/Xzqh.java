package cn.slkj.slclgl.xzqh.bean;

import java.io.Serializable;

/**
 * 
 * @author maxh
 *
 */
public class Xzqh implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7751451528531043957L;
	private String code;
	private String note;
	private String pid;
	private String jc;
	private String qc;
	private String cc;
	private String xh;
	private String mz;
	private String lx;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getJc() {
		return jc;
	}

	public void setJc(String jc) {
		this.jc = jc;
	}

	public String getQc() {
		return qc;
	}

	public void setQc(String qc) {
		this.qc = qc;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getXh() {
		return xh;
	}

	public void setXh(String xh) {
		this.xh = xh;
	}

	public String getMz() {
		return mz;
	}

	public void setMz(String mz) {
		this.mz = mz;
	}

	public String getLx() {
		return lx;
	}

	public void setLx(String lx) {
		this.lx = lx;
	}

	@Override
	public String toString() {
		return "CareaXZQH [code=" + code + ", note=" + note + ", pid=" + pid + ", jc=" + jc
				+ ", qc=" + qc + ", cc=" + cc + ", xh=" + xh + ", mz=" + mz + ", lx=" + lx + "]";
	}

}
