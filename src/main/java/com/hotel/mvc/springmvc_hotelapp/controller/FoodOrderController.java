package com.hotel.mvc.springmvc_hotelapp.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hotel.mvc.springmvc_hotelapp.dao.CustomerDaoImpl;
import com.hotel.mvc.springmvc_hotelapp.dao.FoodOrderDaoImpl;
import com.hotel.mvc.springmvc_hotelapp.dao.FoodProductDaoImpl;
import com.hotel.mvc.springmvc_hotelapp.dto.Customer;
import com.hotel.mvc.springmvc_hotelapp.dto.FoodItem;
import com.hotel.mvc.springmvc_hotelapp.dto.FoodOrder;
import com.hotel.mvc.springmvc_hotelapp.dto.FoodProduct;
import com.hotel.mvc.springmvc_hotelapp.dto.Owner;

@Controller
public class FoodOrderController {

	@Autowired
	FoodProductDaoImpl productDao;
	
	@Autowired
	FoodOrderDaoImpl orderDao;
	
	@Autowired
	CustomerDaoImpl customerDao;
	
	@RequestMapping("createOrder")
	public ModelAndView createOrder() {
		
		ArrayList<FoodProduct> products=productDao.getAllProducts();
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("allproducts",products);
		mv.setViewName("displayfooditems.jsp");
		return mv;
	}
	
	@RequestMapping("confirm")
	public ModelAndView confirmOrder(HttpServletRequest req) {
		
		HttpSession session=req.getSession();
		
		Customer customer=(Customer) session.getAttribute("customer");
		customerDao.saveCustomer(customer);
		
		FoodOrder order=(FoodOrder) session.getAttribute("myorder");
		
		orderDao.saveOrder(order);
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("ordermodel",order);
		mv.setViewName("final.jsp");
		return mv;
	}
	
	@RequestMapping("refresh")
	public ModelAndView refresh(HttpServletRequest req) {
		
		HttpSession session=req.getSession();
		
		session.removeAttribute("customer");
		session.removeAttribute("myorder");
		session.removeAttribute("allitems");
		
		ModelAndView mv=new ModelAndView();
		
		mv.setViewName("createOrder");
		return mv;
	}
}
