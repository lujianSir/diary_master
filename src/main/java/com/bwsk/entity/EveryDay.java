package com.bwsk.entity;

import java.util.List;

/**
 * 每一天的日期
 * 
 * @author Administrator
 *
 */
public class EveryDay {

	private String dtime;

	private List<Daily> dailyList;

	public String getDtime() {
		return dtime;
	}

	public void setDtime(String dtime) {
		this.dtime = dtime;
	}

	public List<Daily> getDailyList() {
		return dailyList;
	}

	public void setDailyList(List<Daily> dailyList) {
		this.dailyList = dailyList;
	}

}
