package com.bwsk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bwsk.entity.User;
import com.bwsk.service.UserService;
import com.bwsk.util.Result;
/**
 * 用户相关的接口
 * @author lujian
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	 
	/**
	 * 添加或者修改用户信息
	 * @param user
	 * @return
	 */
	@RequestMapping("/insertOrUpdateUser")
	public Result<?> insertOrUpdateUser(User user) {	
		int row=userService.insertOrUpdateUser(user);
		if(row>0) {
			return	Result.success("操作成功");
		}else {
			return Result.error(500, "服务端错误");
		}	
	}
	
	/**
	 * 通过微信ID或者用户ID查询关联的信息
	 * @param user
	 * @return
	 */
	@RequestMapping("/queryUserByWxIdOrUid")
	public Result<?> queryUserByWxIdOrUid(User user) {
		User u=userService.queryUserByWxIdOrUid(user);
		if(u!=null) {
			return	Result.success(u);
		}else {
			return Result.error(500, "服务端错误");
		}
	}
}
