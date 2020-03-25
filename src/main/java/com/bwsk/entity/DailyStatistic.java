package com.bwsk.entity;

public class DailyStatistic extends Project {

	private int dailyTody;// 日报天数

	private int dailyTotal;// 日报总数

	private int totalPeople;// 累计人工

	public int getDailyTody() {
		return dailyTody;
	}

	public void setDailyTody(int dailyTody) {
		this.dailyTody = dailyTody;
	}

	public int getDailyTotal() {
		return dailyTotal;
	}

	public void setDailyTotal(int dailyTotal) {
		this.dailyTotal = dailyTotal;
	}

	public int getTotalPeople() {
		return totalPeople;
	}

	public void setTotalPeople(int totalPeople) {
		this.totalPeople = totalPeople;
	}

}
