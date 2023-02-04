package com.hotel.mvc.springmvc_hotelapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.hotel.mvc.springmvc_hotelapp.dto.FoodProduct;
import com.hotel.mvc.springmvc_hotelapp.dto.Owner;

@Repository  // to represent these class as database related class
public class OwnerDaoImpl {

	EntityManager entityManager=Factory.getEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public String saveOwner(Owner owner) {
		
		entityTransaction.begin();
		entityManager.persist(owner);
		entityTransaction.commit();
		
		return owner.getEmail()+" is saved";
	}

	
	public Owner getOwner(int id) {
		
		return entityManager.find(Owner.class,id);
	}
	
	public Owner findByEmailAndPassword(String email,String password) {
		
		Query q=entityManager.createQuery("select o from Owner o where email=?1 and password=?2");
		q.setParameter(1,email);
		q.setParameter(2,password);
		
		try {
			return (Owner) q.getSingleResult();
		}catch(NoResultException n) {
			
			return null;
		}
	}
	
	
	
	
}
