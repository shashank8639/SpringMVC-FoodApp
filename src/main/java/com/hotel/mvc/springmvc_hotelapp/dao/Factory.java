package com.hotel.mvc.springmvc_hotelapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Factory {

	public static EntityManager getEntityManager() {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("hotel");
		return emf.createEntityManager();
	}
}
