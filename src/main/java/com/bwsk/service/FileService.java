package com.bwsk.service;

import org.springframework.web.multipart.MultipartFile;

import com.bwsk.util.Result;

public interface FileService {

	// 文件信息上传
	public Result<?> fileUpload(MultipartFile file, int kind);
}
