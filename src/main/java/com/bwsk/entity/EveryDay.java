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

	private int currentPeople;// 用户是否提交

	private List<Daily> dailyList;

	public int getCurrentPeople() {
		return currentPeople;
	}

	public void setCurrentPeople(int currentPeople) {
		this.currentPeople = currentPeople;
	}

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
