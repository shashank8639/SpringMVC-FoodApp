package com.hotel.mvc.springmvc_hotelapp.controller;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hotel.mvc.springmvc_hotelapp.dao.FoodProductDaoImpl;
import com.hotel.mvc.springmvc_hotelapp.dto.Customer;
import com.hotel.mvc.springmvc_hotelapp.dto.FoodItem;
import com.hotel.mvc.springmvc_hotelapp.dto.FoodOrder;
import com.hotel.mvc.springmvc_hotelapp.dto.FoodProduct;
import com.hotel.mvc.springmvc_hotelapp.util.BillService;

@Controller
public class FoodItemController {

	@Autowired
	BillService service;
	
	static int count=0;
	@Autowired
	FoodProductDaoImpl productDao;
	
	@RequestMapping("addItem")
	public ModelAndView addItem(@RequestParam int id) {
		
		FoodProduct product=productDao.getProduct(id);
		
		FoodItem item=new FoodItem();
		
		item.setItemName(product.getFoodName());
		item.setPrice(product.getCost());
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("item",item);
		mv.setViewName("quantity.jsp");
		return mv;
	}
	
	@RequestMapping("toOrder")
	public ModelAndView toOrder(@ModelAttribute FoodItem item,HttpServletRequest req) {
		
		HttpSession session=req.getSession();
		
		Object obj=session.getAttribute("allitems");
		
		double totalCost=service.calculate(item.getQuantity(),item.getPrice());
		
		item.setTotalCost(totalCost);
		
		if(obj==null) {
			
			ArrayList<FoodItem> items=new ArrayList<FoodItem>();
			items.add(item);
			session.setAttribute("allitems", items);
		}else {
			
			ArrayList<FoodItem> items=(ArrayList<FoodItem>) session.getAttribute("allitems");
			items.add(item);
			session.setAttribute("allitems", items);
		}
		System.out.println(obj);
		
		ArrayList<FoodProduct> products=productDao.getAllProducts();
		ModelAndView mv=new ModelAndView();
		mv.setViewName("createOrder");
		return mv;
	}
	
	@RequestMapping("cart")
	public ModelAndView cart(HttpServletRequest req) {
		HttpSession session=req.getSession();
		ArrayList<FoodItem> items=(ArrayList<FoodItem>) session.getAttribute("allitems");
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("myitems",items);
		mv.setViewName("cart.jsp");
		return mv;
	}
	
	@RequestMapping("deleteItem")
	public ModelAndView deleteItem(@RequestParam int value,HttpServletRequest req) {
		
		HttpSession session=req.getSession();
		
		ArrayList<FoodItem> items=(ArrayList<FoodItem>) session.getAttribute("allitems");
		items.remove(value);
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("myitems",items);
		mv.setViewName("cart.jsp");
		return mv;
	}
	
	
	@RequestMapping("next")
	public ModelAndView next() {
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("customermodel",new Customer());
		mv.setViewName("customer.jsp");
		return mv;
	}
	
}
