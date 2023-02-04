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
import com.hotel.mvc.springmvc_hotelapp.dao.OwnerDaoImpl;
import com.hotel.mvc.springmvc_hotelapp.dto.FoodProduct;
import com.hotel.mvc.springmvc_hotelapp.dto.Owner;

@Controller
public class FoodProductController {

	@Autowired
	FoodProductDaoImpl productDao;
	
	@Autowired
	OwnerDaoImpl ownerDao;
	
	@RequestMapping("createProduct")
	public ModelAndView createProduct() {
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("productmodel",new FoodProduct());
		mv.setViewName("createproduct.jsp");
		return mv;
	}
	
	@RequestMapping("saveProduct")
	public ModelAndView saveProduct(@ModelAttribute FoodProduct product,HttpServletRequest req) {
		
		HttpSession session=req.getSession();
		int id=(int) session.getAttribute("ownerid");
		
		Owner owner=ownerDao.getOwner(id);
		
		//setting owner object to FoodProduct
		product.setOwner(owner);
		
		String message=productDao.saveProduct(product);
		ModelAndView mv=new ModelAndView();
		mv.addObject("result",message);
		mv.setViewName("ownermessage.jsp");
		return mv;
	}
	
	@RequestMapping("displayFoodProducts")
	public ModelAndView allProducts() {
		
		ArrayList<FoodProduct> products=productDao.getAllProducts();
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("allproducts",products);
		mv.setViewName("displayfoodproducts.jsp");
		return mv;
	}
	
	@RequestMapping("deleteProduct")
	public ModelAndView deleteProduct(@RequestParam int id) {
		
		
		String message=productDao.deleteProduct(id);
		ModelAndView mv=new ModelAndView();
		mv.addObject("result",message);
		mv.setViewName("ownermessage.jsp");
		return mv;
	}
}
