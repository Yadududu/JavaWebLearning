package com.lmj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lmj.bean.ItemInfo;
import com.lmj.bean.User;
import com.lmj.service.ItemService;

@Controller
public class UserController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/login")
	public String login(User u,Model model) {
		
		System.out.println("user = " + u);
		
		model.addAttribute("user",u);
		
		return "list";
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("123");
		List<ItemInfo> itemList = itemService.getAllList();
		
		for(ItemInfo itemInfo:itemList) {
			System.out.println("itemInfo = " + itemInfo);
			
		}
		
		model.addAttribute("itemList",itemList);
		
		return "item_list";
	}
}
