package com.bwsk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.bwsk.entity.User;
import com.bwsk.service.UserService;
import com.bwsk.util.Result;
import com.bwsk.util.WeChatUtil;

/**
 * 用户相关的接口
 * 
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
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/insertOrUpdateUser")
	public Result<?> insertOrUpdateUser(User user) {
		int row = userService.insertOrUpdateUser(user);
		if (row > 0) {
			return Result.success("操作成功");
		} else {
			return Result.error(500, "服务端错误");
		}
	}

	/**
	 * 通过微信ID或者用户ID查询关联的信息
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/queryUserByWxIdOrUid")
	public Result<?> queryUserByWxIdOrUid(User user) {
		User u = userService.queryUserByWxIdOrUid(user);
		if (u == null) {
			userService.insertOrUpdateUser(user);// 不存在则添加
			u = userService.queryUserByWxIdOrUid(user);
		}

		if (u != null) {
			return Result.success(u);
		} else {
			return Result.error(500, "服务端错误");
		}
	}

	/**
	 * 通过项目ID以及用户ID查询用户
	 * 
	 * @param uid
	 * @param pid
	 * @return
	 */
	@RequestMapping("/queryUserByUidAndPid")
	public Result<?> queryUserByUidAndPid(int uid, int pid) {
		List<User> list = userService.queryUserByUidAndPid(uid, pid);
		return Result.success(list);
	}

	/**
	 * 通过code获取openid
	 * 
	 * @param code
	 * @return
	 */
	@RequestMapping("/getWxOpineId")
	public Result<?> getWxOpineId(String code, User user) {
		// 微信小程序ID
		String appid = "";
		// 微信小程序秘钥
		String secret = "";

		// 根据小程序穿过来的code想这个url发送请求
		String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + secret + "&js_code="
				+ code + "&grant_type=authorization_code";
		// 发送请求，返回Json字符串
		String str = WeChatUtil.httpRequest(url, "GET", null);
		// 转成Json对象 获取openid
		JSONObject jsonObject = JSONObject.parseObject(str);

		// 我们需要的openid，在一个小程序中，openid是唯一的
		String openid = jsonObject.get("openid").toString();
		user.setWxid(openid);
		User u = userService.queryUserByWxIdOrUid(user);// 查询是否存在
		if (u == null) {
			userService.insertOrUpdateUser(user);// 不存在则添加
			u = userService.queryUserByWxIdOrUid(user);
		}
		return Result.success(u.getUid());
	}
}
