package com.taotao.item.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.item.pojo.Item;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.service.ItemService;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	
	@RequestMapping("/item/{itemId}")
	public String getItem(@PathVariable Long itemId,Model model) {
		//1.引入服务
		//2.诸如服务
		//3.调用服务的方法
			//商品的基本信息  tbitem  
		TbItem tbItem = itemService.getItemById(itemId);
			//商品的描述信息
		TbItemDesc itemDesc = itemService.getItemDescById(itemId);
		//4.tbitem转成item
		Item item=new Item(tbItem); 
		
		//5.传递数据到页面中
		model.addAttribute("item", item);
		model.addAttribute("itemDesc", itemDesc);
		
		return "item";
	}
	@RequestMapping("/item/desc/{itemId}")
	@ResponseBody
	public TbItemDesc getItemDesc(@PathVariable Long itemId,Model model) {
		//1.引入服务
		//2.诸如服务
		//3.调用服务的方法
		//商品的基本信息  tbitem  
		//TbItem tbItem = itemService.getItemById(itemId);
		//商品的描述信息
		TbItemDesc itemDesc = itemService.getItemDescById(itemId);
		//4.tbitem转成item
		//Item item=new Item(tbItem); 
		
		//5.传递数据到页面中
		//model.addAttribute("item", item);
		//model.addAttribute("itemDesc", itemDesc);
		
		return itemDesc;
	}
}
