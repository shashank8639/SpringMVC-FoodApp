package com.hotel.mvc.springmvc_hotelapp.controller;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hotel.mvc.springmvc_hotelapp.dao.CustomerDaoImpl;
import com.hotel.mvc.springmvc_hotelapp.dto.Customer;
import com.hotel.mvc.springmvc_hotelapp.dto.FoodItem;
import com.hotel.mvc.springmvc_hotelapp.dto.FoodOrder;
import com.hotel.mvc.springmvc_hotelapp.dto.Owner;
import com.hotel.mvc.springmvc_hotelapp.dto.Worker;

@Controller
public class CustomerController {

	@Autowired
	CustomerDaoImpl customerDao;
	
	@RequestMapping("saveCustomer")
	public ModelAndView saveCustomer(@ModelAttribute Customer customer,HttpServletRequest req) {
		HttpSession session=req.getSession();
		
		Worker worker=(Worker) session.getAttribute("worker");
		
		FoodOrder order=new FoodOrder();
		order.setWorker(worker);
		order.setCustomer(customer);
		
		order.setWorkerName(worker.getWorkerName());
		order.setCustomerName(customer.getCustomer());
		
		LocalDate date=LocalDate.now();
		LocalTime time=LocalTime.now();
		
		order.setOrderDate(date);
		order.setTime(Time.valueOf(time));
		
		ArrayList<FoodItem> items=(ArrayList<FoodItem>) session.getAttribute("allitems");
		
		order.setFoodItems(items);
		order.setNumberOfItems(items.size());
		
		session.setAttribute("myorder",order);
		session.setAttribute("customer",customer);
		
		
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("ordermodel", order);
		mv.setViewName("orderdetails.jsp");
		return mv;
	}
	
}
