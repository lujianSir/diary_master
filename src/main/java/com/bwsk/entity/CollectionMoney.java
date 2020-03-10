package com.bwsk.entity;

import java.math.BigDecimal;

public class CollectionMoney {

	private int mid;// id

	private BigDecimal money;// 收款的金额

	private String mtime;// 收款的日期

	private String mtimeChinese;// 收款日期 (年、月、日)

	private String mcomment;// 收款的内容

	private int mstatus;// 是否开启

	private String creattime;// 创建的时间

	private int pid;// 项目ID

	public String getMtimeChinese() {
		return mtimeChinese;
	}

	public void setMtimeChinese(String mtimeChinese) {
		this.mtimeChinese = mtimeChinese;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public String getMtime() {
		return mtime;
	}

	public void setMtime(String mtime) {
		this.mtime = mtime;
	}

	public String getMcomment() {
		return mcomment;
	}

	public void setMcomment(String mcomment) {
		this.mcomment = mcomment;
	}

	public int getMstatus() {
		return mstatus;
	}

	public void setMstatus(int mstatus) {
		this.mstatus = mstatus;
	}

	public String getCreattime() {
		return creattime;
	}

	public void setCreattime(String creattime) {
		this.creattime = creattime;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

}
