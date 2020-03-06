package com.bwsk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwsk.entity.Daily;
import com.bwsk.entity.EveryDay;
import com.bwsk.entity.ProjectInfo;
import com.bwsk.mapper.DailyMapper;
import com.bwsk.service.DailyService;
import com.bwsk.util.Utils;

@Service
public class DailyServiceImpl implements DailyService {

	@Autowired
	private DailyMapper dailyMapper;

	@Override
	public int insertOrUpdateDaily(Daily daily) {
		// TODO Auto-generated method stub
		int row = 0;
		if (daily.getDid() > 0) {// 存在 修改
			row = dailyMapper.updateDaily(daily);
		} else {// 不存在 添加
			String currentTime = Utils.getCurrent();
			daily.setCreattime(currentTime);
			row = dailyMapper.insertDaily(daily);
		}
		return row;
	}

	@Override
	public List<Daily> queryDaily(Daily daily) {
		// TODO Auto-generated method stub
		return dailyMapper.queryDaily(daily);
	}

	@Override
	public List<EveryDay> queryEveryDay(Daily daily) {
		// TODO Auto-generated method stub
		return dailyMapper.queryEveryDay(daily);
	}

	@Override
	public List<ProjectInfo> queryProject(Daily daily) {
		// TODO Auto-generated method stub
		List<ProjectInfo> projects = dailyMapper.queryProject(daily);
		for (ProjectInfo project : projects) {
			List<Daily> dailys = project.getDailyList();
			if (dailys.get(0).getDid() == 0) {
				dailys.clear();
			} else {
				for (Daily dai : dailys) {
					int uid = dai.getUid();
					if (uid == daily.getUid()) {
						project.setCurrentPeople(1);
					}
				}
			}

		}
		return projects;
	}

}
