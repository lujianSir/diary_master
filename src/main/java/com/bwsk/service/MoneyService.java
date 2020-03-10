package com.bwsk.service;

import java.util.List;

import com.bwsk.entity.CollectionMoney;

public interface MoneyService {

	// 添加收款
	public int insertCollectionMoney(List<CollectionMoney> list);
}
