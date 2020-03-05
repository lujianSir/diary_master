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
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	private ProjectMapper projectMapper;
	
	@Override
	public int insertOrUpdateProject(Project project) {
		// TODO Auto-generated method stub
		int row=0;
		if(project.getPid()>0) {//存在  修改
			row=projectMapper.updateProject(project);
		}else {//不存在 添加
			String currentTime=Utils.getCurrent();
			project.setCreattime(currentTime);						
			projectMapper.insertProject(project);
			
			ProjectUser projectUser=new ProjectUser();//用户与项目绑定
			projectUser.setUid(project.getUid());
			projectUser.setPid(project.getPid());
			row=projectMapper.insertProjectUser(projectUser);	
		}
		return row;
	}

	@Override
	public List<Project> queryProject(Project project) {
		// TODO Auto-generated method stub
		return projectMapper.queryProject(project);
	}

}
