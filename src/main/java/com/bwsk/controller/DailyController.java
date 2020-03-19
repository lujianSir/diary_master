package com.bwsk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bwsk.entity.Daily;
import com.bwsk.entity.EveryDay;
import com.bwsk.entity.ProjectInfo;
import com.bwsk.service.DailyService;
import com.bwsk.util.Result;
import com.bwsk.util.Utils;

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
//		daily.setUid(3);
//		daily.setUsername("dsadsadagse");
//		daily.setUposition("测试222111");
//		daily.setUtelphone("2222111");
//		daily.setWeather(1);
//		daily.setAttendancetody(4);
//		daily.setAttendanceoneself(1);
//		daily.setEffectivework(2);
//		daily.setSatisfactiondegree(3);
//		daily.setEquipments("挖掘机-3;吊车-5;钻图集-1");
//		daily.setWorkcomment("挖土方666");
//		daily.setAbnorname("挖掘机有问题666");
//		daily.setDunning("催款钱666");
//		daily.setDpic("/image/picture/1583740915288.jpg");
//		daily.setDvoideo("/image/video/1583740928803.mp4");
//		BigDecimal amountody = new BigDecimal("60");
//		daily.setAmountody(amountody);
//		BigDecimal invoicetody = new BigDecimal("60");
//		daily.setInvoicetody(invoicetody);
//		daily.setDtime("2020年03月08日");
//		daily.setPid(11);
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
	public Result<?> queryEveryDay(Daily daily, String dtime) {
		String[] dtimes = null;
		if (dtime != null && !dtime.equals("")) {
			dtimes = dtime.split(";");
			for (int i = 0; i < dtimes.length; i++) {
				String str = dtimes[i];
				str = Utils.timeStampDateChinese(str, null);
				dtimes[i] = str;
			}
		}
		List<EveryDay> list = dailyService.queryEveryDay(daily, dtimes);
		return Result.success(list);
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
		return Result.success(list);
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
		return Result.success(list);
	}

	/**
	 * 查询每个月的照片以及视频
	 * 
	 * @param daily
	 * @param dtime
	 * @return
	 */
	@RequestMapping("/queryEveryDayByMonth")
	public Result<?> queryEveryDayByMonth(Daily daily, String creatMouth) {
		String[] creatMouths = null;
		if (creatMouth != null && !creatMouth.equals("")) {
			creatMouths = creatMouth.split(";");
			for (String cm : creatMouths) {
				cm = Utils.timeStampDateChineseshot(cm, null);
			}
		}
		List<EveryDay> list = dailyService.queryEveryDayByMonth(daily, creatMouths);
		return Result.success(list);
	}
}
