package com.lmj.Mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lmj.bean.ItemInfo;
import com.lmj.mapper.ItemMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext_mapper.xml")
public class ItemMapperTest {

	@Autowired
	private ItemMapper itemMapper;
	
	@Test
	public void test() {

		List<ItemInfo> allList = itemMapper.getAllList();
		
		for(ItemInfo itemInfo:allList) {
			System.out.println("itemInfo = " + itemInfo);
		}
	}

}
