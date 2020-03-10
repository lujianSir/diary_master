package com.bwsk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwsk.entity.CollectionMoney;
import com.bwsk.mapper.MoneyMapper;
import com.bwsk.service.MoneyService;

@Service
public class MoneyServiceImpl implements MoneyService {

	@Autowired
	private MoneyMapper moneyMapper;

	@Override
	public int insertCollectionMoney(List<CollectionMoney> list) {
		// TODO Auto-generated method stub
		moneyMapper.deleteCollectionMoney();
		int row = moneyMapper.insertCollectionMoney(list);
		return row;
	}

}
