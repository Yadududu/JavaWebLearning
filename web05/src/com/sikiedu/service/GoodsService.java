package com.sikiedu.service;

import java.util.List;

import com.sikiedu.dao.GoodsDao;
import com.sikiedu.model.Goods;

public class GoodsService {
	public List<Goods> selectAllGoods(){
		return new GoodsDao().getAllGoods();
	}
}
