package com.bwsk.service;

import java.util.List;

import com.bwsk.entity.Daily;
import com.bwsk.entity.EveryDay;
import com.bwsk.entity.ProjectInfo;

public interface DailyService {

	// 添加获取修改日报
	public int insertOrUpdateDaily(Daily daily);

	// 查询日报
	public List<Daily> queryDaily(Daily daily);

	// 通过日期排序查询
	public List<EveryDay> queryEveryDay(Daily daily);

	// 查询当前日期每个项目下面有多少日报
	public List<ProjectInfo> queryProject(Daily daily);

	// 每天凌晨3点插入
	public int insertEveryDay(String everyDay);
}
