package com.hotel.mvc.springmvc_hotelapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hotel.mvc.springmvc_hotelapp.dao.OwnerDaoImpl;
import com.hotel.mvc.springmvc_hotelapp.dto.Owner;

@Controller // The class which is handling all the user requests is controller
  			// to represent this class as controller we are using @controller
public class OwnerController {

	
	@Autowired
	OwnerDaoImpl ownerDao;
	
	@RequestMapping("createOwner")
	public ModelAndView createOwner() {
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("ownermodel",new Owner());
		mv.setViewName("createowner.jsp");
		return mv;
	}
	
	@RequestMapping("saveOwner")
	public ModelAndView saveOwner(@ModelAttribute Owner owner) {
		
		String message=ownerDao.saveOwner(owner);
		ModelAndView mv=new ModelAndView();
		mv.addObject("result",message);
		mv.setViewName("ownermessage.jsp");
		return mv;
	}
	
	@RequestMapping("ownerLogin")
	public void ownerLogin(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
		
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		Owner owner=ownerDao.findByEmailAndPassword(email, password);
		
		PrintWriter out=resp.getWriter();
		
		HttpSession session=req.getSession();
		resp.setContentType("text/html");
		if(owner!=null) {
			
			session.setAttribute("ownerid",owner.getId());
			RequestDispatcher dispatcher=req.getRequestDispatcher("ownerhome.jsp");
			dispatcher.forward(req, resp);
		}else {
			
			out.println("<center><h1>INVALID CREDENTIALS</h1></center>");
			RequestDispatcher dispatcher=req.getRequestDispatcher("ownerlogin.jsp");
			dispatcher.include(req, resp);
			
		}
			
		
	}
	
}
