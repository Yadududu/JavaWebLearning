package com.lmj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmj.mapper.ItemMapper;
import com.lmj.bean.ItemInfo;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemMapper itemMapper;
	
	@Override
	public List<ItemInfo> getAllList() {
		return itemMapper.getAllList();
	}

}
