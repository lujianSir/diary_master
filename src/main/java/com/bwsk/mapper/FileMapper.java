package com.bwsk.mapper;

import org.springframework.stereotype.Repository;

import com.bwsk.entity.FileInfo;

@Repository
public interface FileMapper {

	// 添加文件信息
	public void insertFileInfo(FileInfo fileInfo);
}
