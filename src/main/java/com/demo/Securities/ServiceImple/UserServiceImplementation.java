package com.demo.Securities.ServiceImple;

import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.stereotype.Service;

import com.demo.Securities.Entity.ItemMenu;
import com.demo.Securities.Entity.OrderItem;
import com.demo.Securities.Entity.Payment;
import com.demo.Securities.Entity.Restaurent;
import com.demo.Securities.Entity.Review;
import com.demo.Securities.Entity.User;
import com.demo.Securities.Repository.ItemMenuRepository;
import com.demo.Securities.Repository.OrderItemRepository;
import com.demo.Securities.Repository.PaymentRepository;
import com.demo.Securities.Repository.RestaurentRepository;
import com.demo.Securities.Repository.ReviewRepository;
import com.demo.Securities.Repository.UserRepository;
import com.demo.Securities.Service.UserService;

@Service
public class UserServiceImplementation implements UserService {

	

	@Autowired
	private RestaurentRepository restaurentRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Autowired
	private ItemMenuRepository itemMenuRepository;

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public OrderItem updateOrderItem(OrderItem orderItem, int orderId) throws Exception {
		OrderItem orderItem2 = orderItemRepository.findById(orderId)
				.orElseThrow(() -> new Exception("Order not found"));
		orderItem2.setQuantity(orderItem.getQuantity());
		return orderItem2;
	}

	@Override
	public OrderItem viewOrderItem(int orderId) throws Exception {
		OrderItem orderItem2 = orderItemRepository.findById(orderId)
				.orElseThrow(() -> new Exception("Order not found"));
		return orderItem2;
	}

	@Override
	public String cancelOrderItem(int orderId) throws Exception {
		OrderItem orderItem2 = orderItemRepository.findById(orderId)
				.orElseThrow(() -> new Exception("Order not found"));
		orderItemRepository.delete(orderItem2);
		return "Cancelled Succeessfully";
	}

	@Override
	public ItemMenu updateItemMenu(ItemMenu itemMenu, int itemId) throws Exception {
		ItemMenu itemMenu2 = itemMenuRepository.findById(itemId).orElseThrow(() -> new Exception("Item not found"));
		itemMenu2.setItemName(itemMenu.getItemName());
		itemMenu2.setItemPrice(itemMenu.getItemPrice());
		return itemMenu2;
	}

	@Override
	public ItemMenu viewItemMenu(int itemId) throws Exception {
		ItemMenu itemMenu2 = itemMenuRepository.findById(itemId).orElseThrow(() -> new Exception("Item not found"));
		return itemMenu2;
	}

	@Override
	public String removeItemMenu(int itemId) throws Exception {
		ItemMenu itemMenu2 = itemMenuRepository.findById(itemId).orElseThrow(() -> new Exception("Item not found"));
		itemMenuRepository.delete(itemMenu2);
		return "Removed SucceessFully";
	}

	@Override
	public Payment viewPayment(int paymentId) throws Exception {
		Payment payment2 = paymentRepository.findById(paymentId).orElseThrow(() -> new Exception("Payment not found"));
		return payment2;
	}

	@Override
	public String cancelPayment(int paymentId) throws Exception {
		Payment payment2 = paymentRepository.findById(paymentId).orElseThrow(() -> new Exception("Payment not found"));
		paymentRepository.delete(payment2);
		return "Cancelled Succeessfull";
	}

	@Override
	public Payment addPayment(Payment payment, int orderId) throws Exception {
		OrderItem OrderItem2 = orderItemRepository.findById(orderId)
				.orElseThrow(() -> new Exception("Payment not found"));
		payment.setOrderItem(OrderItem2);
		Payment payment2 = paymentRepository.save(payment);
		return payment2;
	}

	@Override
	public OrderItem addOrderItem(OrderItem orderItem, int userId) throws Exception {
	User user2 =	userRepository.findById(userId).orElseThrow(() -> new Exception(" Order not found"));
	orderItem.setUser(user2);
		OrderItem orderItem2 = orderItemRepository.save(orderItem);
		return orderItem2;
	}

	@Override
	public ItemMenu addItemMenu(ItemMenu itemMenu, int restaurentId) throws Exception {
		Restaurent restaurent2 = restaurentRepository.findById(restaurentId)
				.orElseThrow(() -> new Exception("Restaurent not found"));
		itemMenu.setRestaurent(restaurent2);
		ItemMenu itemMenu2 = itemMenuRepository.save(itemMenu);
		return itemMenu2;
	}

	@Override
	public Review updateReview(Review review, int userId) throws Exception {
		Review review2 = reviewRepository.findById(userId).orElseThrow(() -> new Exception("Review not found"));
		review2.setRating(review.getRating());
		review2.setComment(review.getComment());
		return review2;
	}

	@Override
	public Review viewReview(int reviewId) throws Exception {
		Review review2 = reviewRepository.findById(reviewId).orElseThrow(() -> new Exception("Review not found"));
		return review2;
	}

	@Override
	public String deleteReview(int reviewId) throws Exception {
		Review review2 = reviewRepository.findById(reviewId).orElseThrow(() -> new Exception("Review not found"));
		reviewRepository.delete(review2);
		return "Deleted Succeessfully";
	}

	@Override
	public Review addReview(Review review, int userId) throws Exception {
	User user2 =	userRepository.findById(userId).orElseThrow(() -> new Exception("User not found"));
	review.setUser(user2);
		Review  review2 =	reviewRepository.save(review);
		return review2;
	}

}
