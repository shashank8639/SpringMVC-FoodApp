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
import com.hotel.mvc.springmvc_hotelapp.dao.WorkerDaoImpl;
import com.hotel.mvc.springmvc_hotelapp.dto.Owner;
import com.hotel.mvc.springmvc_hotelapp.dto.Worker;

@Controller
public class WorkerController {

	@Autowired
	WorkerDaoImpl workerDao;
	
	@Autowired
	OwnerDaoImpl ownerDao;
	
	@RequestMapping("createWorker")
	public ModelAndView createWorker() {
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("workermodel",new Worker());
		mv.setViewName("createworker.jsp");
		return mv;
	}
	
	@RequestMapping("saveWorker")
	public ModelAndView saveWorker(@ModelAttribute Worker worker,HttpServletRequest req) {
		
		HttpSession session=req.getSession();
		int id=(int) session.getAttribute("ownerid");
		
		Owner owner=ownerDao.getOwner(id);
		
		worker.setOwner(owner);
		
		String message=workerDao.saveWorker(worker);
		ModelAndView mv=new ModelAndView();
		mv.addObject("result",message);
		mv.setViewName("ownermessage.jsp");
		return mv;
	}
	
	@RequestMapping("workerLogin")
	public void workerLogin(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
		
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		HttpSession session=req.getSession();
		
		Worker worker=workerDao.workerLogin(email, password);
		
		PrintWriter out=resp.getWriter();
		
		resp.setContentType("text/html");
		if(worker!=null) {
			
			session.setAttribute("worker",worker);
			RequestDispatcher dispatcher=req.getRequestDispatcher("workerhome.jsp");
			dispatcher.forward(req, resp);
		}else {
			
			out.println("<center><h1>INVALID CREDENTIALS</h1></center>");
			RequestDispatcher dispatcher=req.getRequestDispatcher("workerlogin.jsp");
			dispatcher.include(req, resp);
		}
	
	}
	
	
	
	
	
	
	
	
	
}
