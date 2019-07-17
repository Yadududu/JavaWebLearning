package com.lmj.service;

import java.util.List;

import com.lmj.model.Goods;
import com.lmj.dao.GoodsDao;

public class GoodService {
	public List<Goods> selectAllGoods() {
		return new GoodsDao().getAllGoods();
	}
}
