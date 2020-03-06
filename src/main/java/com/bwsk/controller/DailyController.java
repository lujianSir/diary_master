package com.bwsk.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bwsk.entity.Daily;
import com.bwsk.entity.EveryDay;
import com.bwsk.entity.ProjectInfo;
import com.bwsk.service.DailyService;
import com.bwsk.util.Result;

/**
 * 用户相关的接口
 * 
 * @author lujian
 *
 */
@RestController
@RequestMapping("/daily")
public class DailyController {

	@Autowired
	private DailyService dailyService;

	/**
	 * 添加或者修改日报信息
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/insertOrUpdateDaily")
	public Result<?> insertOrUpdateDaily(Daily daily) {
		daily.setUid(4);
		daily.setUsername("zhaoliu");
		daily.setUposition("测试222");
		daily.setUtelphone("222");
		daily.setWeather(1);
		daily.setAttendancetody(4);
		daily.setAttendanceoneself(1);
		daily.setEffectivework(2);
		daily.setSatisfactiondegree(3);
		daily.setEquipments("挖掘机-2;吊车-8");
		daily.setWorkcomment("挖土方666");
		daily.setAbnorname("挖掘机有问题666");
		daily.setDunning("催款钱666");
		BigDecimal amountody = new BigDecimal("60");
		daily.setAmountody(amountody);
		BigDecimal invoicetody = new BigDecimal("60");
		daily.setInvoicetody(invoicetody);
		daily.setDtime("2020-3-6");
		daily.setPid(10);
		int row = dailyService.insertOrUpdateDaily(daily);
		if (row > 0) {
			return Result.success("操作成功");
		} else {
			return Result.error(500, "服务端错误");
		}
	}

	/**
	 * 查询每一天的日报
	 * 
	 * @param project
	 * @return
	 */
	@RequestMapping("/queryEveryDay")
	public Result<?> queryEveryDay(Daily daily) {
		List<EveryDay> list = dailyService.queryEveryDay(daily);
		if (list != null && list.size() > 0) {
			return Result.success(list);
		} else {
			return Result.error(500, "服务端错误");
		}
	}

	/**
	 * 查询当前日期每个项目下面有多少日报
	 * 
	 * @param daily
	 * @return
	 */
	@RequestMapping("/queryProject")
	public Result<?> queryProject(Daily daily) {
		List<ProjectInfo> list = dailyService.queryProject(daily);
		if (list != null && list.size() > 0) {
			return Result.success(list);
		} else {
			return Result.error(500, "服务端错误");
		}
	}

	/**
	 * 模糊查询以及单个查询
	 * 
	 * @param daily
	 * @return
	 */
	@RequestMapping("/queryDaily")
	public Result<?> queryDaily(Daily daily) {
		List<Daily> list = dailyService.queryDaily(daily);
		if (list != null && list.size() > 0) {
			return Result.success(list);
		} else {
			return Result.error(500, "服务端错误");
		}
	}
}
