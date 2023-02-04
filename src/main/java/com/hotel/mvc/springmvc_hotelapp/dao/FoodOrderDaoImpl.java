package com.hotel.mvc.springmvc_hotelapp.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.hotel.mvc.springmvc_hotelapp.dto.Customer;
import com.hotel.mvc.springmvc_hotelapp.dto.FoodItem;
import com.hotel.mvc.springmvc_hotelapp.dto.FoodOrder;
import com.hotel.mvc.springmvc_hotelapp.dto.Worker;

@Repository
public class FoodOrderDaoImpl {

	static EntityManager entityManager = Factory.getEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public String saveOrder(FoodOrder order) {

		entityTransaction.begin();
		entityManager.persist(order);
		entityTransaction.commit();

		return order.getCustomerName() + "'s order is saved";
	}

	public void saveItem(FoodItem item) {

		entityTransaction.begin();
		entityManager.persist(item);
		entityTransaction.commit();
	}

	public FoodOrder getOrder(int id) {

		return entityManager.find(FoodOrder.class, id);
	}

	public ArrayList<FoodOrder> getAllOrders() {

		Query q = entityManager.createQuery("select o from FoodOrder o");

		return (ArrayList<FoodOrder>) q.getResultList();
	}

	public static void main(String[] args) {

		CustomerDaoImpl c = new CustomerDaoImpl();
		Customer cus = c.getCustomer(1);

		WorkerDaoImpl d = new WorkerDaoImpl();
		Worker w = d.getWorker(1);

		FoodOrder order = new FoodOrder();
		order.setCustomer(cus);
		order.setWorker(w);
		order.setWorkerName(w.getWorkerName());

		FoodItem i1 = new FoodItem();
		i1.setItemName("Pizza");

		FoodItem i2 = new FoodItem();
		i2.setItemName("Burger");

		ArrayList<FoodItem> all = new ArrayList<FoodItem>();
		all.add(i1);
		all.add(i2);

		order.setFoodItems(all);

		FoodOrderDaoImpl orderDao = new FoodOrderDaoImpl();
		orderDao.saveOrder(order);
		

	}
}
