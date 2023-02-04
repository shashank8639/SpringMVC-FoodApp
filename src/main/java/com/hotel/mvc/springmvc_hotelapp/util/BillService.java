package com.hotel.mvc.springmvc_hotelapp.util;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.hotel.mvc.springmvc_hotelapp.dto.FoodItem;

@Component
public class BillService {

	public double calculate(int quantity,double price) {
		
		return quantity*price;
	}
	
	public double totalBill(ArrayList<FoodItem> items) {
		
		double totalAmt=0;
		for(FoodItem item : items) {
			
			double cost=item.getQuantity()*item.getPrice();
			totalAmt=totalAmt+cost;
		}
		return totalAmt;
	}
}
