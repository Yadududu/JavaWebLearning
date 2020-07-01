package com.sikiedu.dao;

import java.util.List;

import com.sikiedu.model.Goods;
import com.sikiedu.util.DBUtil;

public class GoodsDao {
	public List<Goods> getAllGoods(){
		return DBUtil.goodsList;
	}
}
