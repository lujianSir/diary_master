package com.bwsk.service;

import java.util.List;

import com.bwsk.entity.Project;

public interface ProjectService {

	//添加或者修改项目
	public int insertOrUpdateProject(Project project);
	
	//查询所有的项目
	public List<Project> queryProject(Project project);
}
