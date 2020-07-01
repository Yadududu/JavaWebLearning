package com.lmj.dao;

import java.util.List;

import com.lmj.model.Goods;
import com.lmj.util.DButil;

public class GoodsDao {
	public List<Goods> getAllGoods() {
		return DButil.goodsList;
	}
}
