package com.bwsk.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bwsk.entity.CollectionMoney;

@Repository
public interface MoneyMapper {

	// 添加收款
	public int insertCollectionMoney(List<CollectionMoney> list);

	// 删除所有的数据
	public void deleteCollectionMoney();
}
