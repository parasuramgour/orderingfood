package com.demo.Securities.Service;

import java.time.LocalDate;

import java.util.List;

import com.demo.Securities.Entity.DeliveryBoy;
import com.demo.Securities.Entity.OrderItem;
import com.demo.Securities.Entity.Restaurent;
import com.demo.Securities.Entity.User;

public interface AdminService {
	
	public String addRoles();

	public User addUser(User user);
	public User updateUser(User user, int userId) throws Exception;
	public User getUser(int userId) throws Exception;

	
	public User addAdmin(User admin);
    public User updateAdmin(int userId, User admin) throws Exception;
    public User getAdmin(int userId) throws Exception;
	
    public Restaurent   addRestaurent(Restaurent restaurent, int userId) throws Exception;
	public Restaurent   updateRestaurent(Restaurent restaurent, int restaurentId) throws Exception;
	public Restaurent   viewRestaurent(int restaurentId) throws Exception;
	public String       removeRestaurent(int restaurentId) throws Exception;
	
	public  DeliveryBoy  addDeliveryBoy(DeliveryBoy deliveryBoy, int userId) throws Exception;
	public DeliveryBoy   updateDeliveryBoy(DeliveryBoy DeliveryBoy, int driverId) throws Exception;
	public DeliveryBoy   getDeliveryBoy(int driverId) throws Exception;
	public String       deleteDeliveryBoy(int driverId) throws Exception;
	
	public List<OrderItem> listofOrder(LocalDate date1, LocalDate date2);
	
	public double monthlyRevenue(LocalDate date1, LocalDate date2);

	

	
	

}
