package com.bwsk.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bwsk.entity.CollectionMoney;
import com.bwsk.service.MoneyService;
import com.bwsk.util.Result;

/**
 * 用户相关的接口
 * 
 * @author lujian
 *
 */
@RestController
@RequestMapping("/money")
public class MoneyController {

	@Autowired
	private MoneyService moneyService;

	/**
	 * 添加或者修改收款信息
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/insertCollectionMoney")
	public Result<?> insertCollectionMoney(String moneys) {
		List<CollectionMoney> list = new ArrayList<CollectionMoney>();
//		CollectionMoney collectionMoney = new CollectionMoney();
//		BigDecimal amountody = new BigDecimal("60");
//		collectionMoney.setMoney(amountody);
//		String str = "1586448000";
//		collectionMoney.setMtime(Utils.timeStampDate(str, null));
//		collectionMoney.setMstatus(1);
//		collectionMoney.setMcomment("测试数据");
//		collectionMoney.setPid(11);
//		list.add(collectionMoney);

		int row = moneyService.insertCollectionMoney(list);
		if (row > 0) {
			return Result.success("操作成功");
		} else {
			return Result.error(500, "服务端错误");
		}

	}

	/**
	 * 查询所有的收款提醒
	 * 
	 * @param collectionMoney
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryCollectionMoneys")
	public Result<?> queryCollectionMoneys(CollectionMoney collectionMoney) throws Exception {
		List<CollectionMoney> list = moneyService.queryCollectionMoneys(collectionMoney);
		return Result.success(list);
	}

}
