package com.bwsk.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bwsk.entity.Project;
import com.bwsk.entity.ProjectUser;

@Repository
public interface ProjectMapper {

	//添加项目
	public int insertProject(Project project);
	
	//项目与用户绑定
	public int insertProjectUser(ProjectUser projectuser);
	
	//修改项目
	public int updateProject(Project project);
	
	//查询所有的项目
	public List<Project> queryProject(Project project);
}
