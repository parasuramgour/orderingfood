package com.demo.Securities.Service;

import com.demo.Securities.Entity.ItemMenu;

import com.demo.Securities.Entity.OrderItem;
import com.demo.Securities.Entity.Payment;
import com.demo.Securities.Entity.Review;

public interface UserService {
	
	public OrderItem addOrderItem(OrderItem orderItem, int userId) throws Exception;
	public OrderItem updateOrderItem(OrderItem orderItem, int orderId) throws Exception;
    public OrderItem viewOrderItem(int orderId) throws Exception;
    public String cancelOrderItem(int orderId) throws Exception;
    
	public  ItemMenu addItemMenu(ItemMenu itemMenu, int restaurentId) throws Exception;
    public  ItemMenu updateItemMenu(ItemMenu itemMenu, int itemId) throws Exception;
	public ItemMenu viewItemMenu(int itemId) throws Exception;
	public String removeItemMenu(int itemId) throws Exception;
	
	public Payment addPayment(Payment payment, int orderId) throws Exception;
	public Payment viewPayment(int orderId) throws Exception;
	public String cancelPayment(int paymentId) throws Exception;
	
	public   Review  addReview(Review review, int userId) throws Exception;
	public   Review  updateReview(Review review, int userId) throws Exception;
	public   Review viewReview(int reviewId) throws Exception;
	public   String deleteReview(int reviewId) throws Exception;

}
