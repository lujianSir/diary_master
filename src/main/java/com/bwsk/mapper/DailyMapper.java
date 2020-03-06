package com.bwsk.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bwsk.entity.Daily;
import com.bwsk.entity.EveryDay;
import com.bwsk.entity.ProjectInfo;

@Repository
public interface DailyMapper {

	// 添加日报
	public int insertDaily(Daily daily);

	// 修改日报
	public int updateDaily(Daily daily);

	// 查询当前项目（模糊查询、通过ID查询）
	public List<Daily> queryDaily(Daily daily);

	// 通过当前项目下面所有天数下面所有的日报
	public List<EveryDay> queryEveryDay(Daily daily);

	// 查询当前日期每个项目下面有多少日报
	public List<ProjectInfo> queryProject(Daily daily);
}
