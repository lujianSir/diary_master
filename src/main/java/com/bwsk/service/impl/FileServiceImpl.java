package com.bwsk.service.impl;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bwsk.entity.FileInfo;
import com.bwsk.mapper.FileMapper;
import com.bwsk.service.FileService;
import com.bwsk.util.Result;
import com.bwsk.util.Utils;

@Service
public class FileServiceImpl implements FileService {

	@Autowired
	private FileMapper fileMapper;

	@Override
	public Result<?> fileUpload(MultipartFile file, int kind) {
		// TODO Auto-generated method stub
		if (!file.isEmpty()) {
			try {
				// 文件存放服务端的位置
				File dir = null;
				long now = System.currentTimeMillis();
				String filesuffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
				String filename = now + filesuffix;
				String newrootPath = System.getProperty("user.dir") + "/upload";
				System.out.println(newrootPath);
				// 0代表图片 1代表视频
				switch (kind) {
				case 0:
					dir = new File(newrootPath + File.separator + "picture" + File.separator);
					break;
				case 1:
					dir = new File(newrootPath + File.separator + "video" + File.separator);
					break;
				default:
					break;
				}
				if (!dir.exists()) {
					dir.mkdirs();
				}

				String filePath = dir.getAbsolutePath() + File.separator + filename;

				// 写文件到服务器
				File serverFile = new File(filePath);
				file.transferTo(serverFile);

				// 录入文件信息
				FileInfo fileinfo = new FileInfo();
				fileinfo.setFname("11");
				fileinfo.setFrealurl(filePath);
				String fvirtualurl = "";
				if (kind == 1) {// 视频
					fvirtualurl = "/image/video/" + filename;
				} else {
					fvirtualurl = "/image/picture/" + filename;
				}
				fileinfo.setFvirtualurl(fvirtualurl);
				fileinfo.setFuploadtime(Utils.getCurrent());
				fileMapper.insertFileInfo(fileinfo);
				return Result.success(fvirtualurl);
			} catch (Exception e) {
				return Result.error(500, "服务端错误");
			}
		} else {
			return Result.error(50010, "请上传文件");
		}
	}

}
