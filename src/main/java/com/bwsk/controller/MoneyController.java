package com.bwsk.controller;

import java.math.BigDecimal;
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
	public Result<?> insertCollectionMoney() {
		List<CollectionMoney> list = new ArrayList<CollectionMoney>();
		for (int i = 0; i < 2; i++) {
			CollectionMoney collectionMoney = new CollectionMoney();
			BigDecimal amountody = new BigDecimal("60");
			collectionMoney.setMoney(amountody);
			collectionMoney.setMtime("2020年03月08日");
			list.add(collectionMoney);
		}

		int row = moneyService.insertCollectionMoney(list);
		if (row > 0) {
			return Result.success("操作成功");
		} else {
			return Result.error(500, "服务端错误");
		}

	}

}
