package com.bwsk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bwsk.entity.Daily;
import com.bwsk.entity.DailyStatistic;
import com.bwsk.entity.Statistic;
import com.bwsk.service.StatisticService;
import com.bwsk.util.Result;

/**
 * 统计相关的接口
 * 
 * @author lujian
 *
 */
@RestController
@RequestMapping("/statistic")
public class StatisticController {
	@Autowired
	private StatisticService statisticService;

	/**
	 * 天气统计
	 * 
	 * @param daily
	 * @return
	 */
	@RequestMapping("/queryWeacher")
	public Result<?> queryWeacher(Daily daily) {
		List<Statistic> list = statisticService.queryWeacher(daily);
		return Result.success(list);

	}

	/**
	 * 日报统计
	 * 
	 * @param daily
	 * @return
	 */
	@RequestMapping("/queryAttendancetody")
	public Result<?> queryAttendancetody(Daily daily) {
		List<Statistic> list = statisticService.queryAttendancetody(daily);
		return Result.success(list);

	}

	/**
	 * 项目统计
	 * 
	 * @param daily
	 * @return
	 */
	@RequestMapping("/queryDailyStatistic")
	public Result<?> queryDailyStatistic(Daily daily) {
		List<DailyStatistic> list = statisticService.queryDailyStatistic(daily);
		return Result.success(list);

	}
}
