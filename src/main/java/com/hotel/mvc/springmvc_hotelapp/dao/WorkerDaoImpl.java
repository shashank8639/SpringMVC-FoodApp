package com.hotel.mvc.springmvc_hotelapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.hotel.mvc.springmvc_hotelapp.dto.Worker;

@Repository
public class WorkerDaoImpl {

	EntityManager entityManager=Factory.getEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
    public String saveWorker(Worker worker) {
		
		entityTransaction.begin();
		entityManager.persist(worker);
		entityTransaction.commit();
		
		return worker.getEmail()+" is saved";
	}

	
	public Worker getWorker(int id) {
		
		return entityManager.find(Worker.class,id);
	}
	
	public Worker workerLogin(String email,String password) {
		
		Query query=entityManager.createQuery("select w from Worker w where email=?1 and password=?2");
		query.setParameter(1,email);
		query.setParameter(2,password);
		
		try {
			Object obj=query.getSingleResult();
			return (Worker) obj;
		}catch(NoResultException e) {
			
			return null;
		}
		
	}
}
