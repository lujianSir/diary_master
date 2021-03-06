package com.bwsk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwsk.entity.Project;
import com.bwsk.entity.ProjectUser;
import com.bwsk.mapper.ProjectMapper;
import com.bwsk.service.ProjectService;
import com.bwsk.util.Utils;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectMapper projectMapper;

	@Override
	public int insertOrUpdateProject(Project project) {
		// TODO Auto-generated method stub
		String approachDay = project.getApproachDay();// 进场时间错
		if (approachDay != null && !approachDay.equals("")) {
			project.setApproachDay(Utils.timeStampDate(approachDay, null));
		}
		String completeDay = project.getCompleteDay();// 竣工时间错
		if (completeDay != null && !completeDay.equals("")) {
			project.setCompleteDay(Utils.timeStampDate(completeDay, null));
		}
		int row = 0;
		if (project.getPid() > 0) {// 存在 修改
			row = projectMapper.updateProject(project);
		} else {// 不存在 添加
			String currentTime = Utils.getCurrent();
			project.setCreattime(currentTime);
			project.setMaterialuid(project.getUid());
			projectMapper.insertProject(project);

			ProjectUser projectUser = new ProjectUser();// 用户与项目绑定
			projectUser.setUid(project.getUid());
			projectUser.setPid(project.getPid());
			row = projectMapper.insertProjectUser(projectUser);
		}
		return row;
	}

	@Override
	public List<Project> queryProject(Project project) {
		// TODO Auto-generated method stub
		return projectMapper.queryProject(project);
	}

	@Override
	public int deleteProject(Project project) {
		// TODO Auto-generated method stub
		projectMapper.deleteDailyByPid(project);
		projectMapper.deleteprojectuser(project);
		return projectMapper.deleteProject(project);
	}

	@Override
	public Project queryProjecByPid(int pid) {
		// TODO Auto-generated method stub
		return projectMapper.queryProjecByPid(pid);
	}

}
