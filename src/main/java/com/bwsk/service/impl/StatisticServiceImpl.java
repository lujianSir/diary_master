package com.bwsk.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bwsk.entity.Daily;
import com.bwsk.entity.DailyStatistic;
import com.bwsk.entity.Statistic;
import com.bwsk.mapper.StatisticMapper;
import com.bwsk.service.StatisticService;

@Service
public class StatisticServiceImpl implements StatisticService {

	@Resource
	private StatisticMapper statisticMapper;

	@Override
	public List<Statistic> queryWeacher(Daily daily) {
		// TODO Auto-generated method stub
		return statisticMapper.queryWeacher(daily);
	}

	@Override
	public List<Statistic> queryAttendancetody(Daily daily) {
		// TODO Auto-generated method stub
		return statisticMapper.queryAttendancetody(daily);
	}

	@Override
	public List<DailyStatistic> queryDailyStatistic(Daily daily) {
		// TODO Auto-generated method stub
		return statisticMapper.queryDailyStatistic(daily);
	}

}
