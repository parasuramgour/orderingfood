package com.demo.Securities.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Securities.Entity.ItemMenu;
import com.demo.Securities.Entity.OrderItem;
import com.demo.Securities.Entity.Payment;
import com.demo.Securities.Entity.Review;
import com.demo.Securities.Service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userServie;

	@PostMapping("/addOrderItem")
	public ResponseEntity<OrderItem> addOrderItem(@RequestBody OrderItem orderItem, @RequestParam int userId)
			throws Exception {
		OrderItem orderItem2 = userServie.addOrderItem(orderItem, userId);
		return new ResponseEntity<OrderItem>(orderItem2, HttpStatus.CREATED);
	}

	@PutMapping("/updateOrderItem")
	public ResponseEntity<OrderItem> updateOrderItem(@RequestBody OrderItem orderItem, @RequestParam int orderId)
			throws Exception {
		OrderItem orderItem2 = userServie.updateOrderItem(orderItem, orderId);
		return new ResponseEntity<OrderItem>(orderItem2, HttpStatus.ACCEPTED);
	}

	@GetMapping("/viewOrderItem")
	public ResponseEntity<OrderItem> viewOrderItem(@RequestParam int orderId) throws Exception {
		OrderItem orderItem2 = userServie.viewOrderItem(orderId);
		return new ResponseEntity<OrderItem>(orderItem2, HttpStatus.FOUND);
	}

	@DeleteMapping("/cancelOrderItem")
	public ResponseEntity<String> cancelOrderItem(@RequestParam int orderId) throws Exception {
		String orderItem2 = userServie.cancelOrderItem(orderId);
		return new ResponseEntity<String>(orderItem2, HttpStatus.OK);
	}

	@PostMapping("/addItemMenu")
	public ResponseEntity<ItemMenu> addItemMenu(@RequestBody ItemMenu itemMenu, @RequestParam int restaurentId)
			throws Exception {
		ItemMenu itemMenu2 = userServie.addItemMenu(itemMenu, restaurentId);
		return new ResponseEntity<ItemMenu>(itemMenu2, HttpStatus.CREATED);
	}

	@PutMapping("/updateItemMenu")
	public ResponseEntity<ItemMenu> updateItemMenu(@RequestBody ItemMenu itemMenu, @RequestParam int itemId)
			throws Exception {
		ItemMenu itemMenu2 = userServie.updateItemMenu(itemMenu, itemId);
		return new ResponseEntity<ItemMenu>(itemMenu2, HttpStatus.ACCEPTED);
	}

	@GetMapping("/viewItemMenu")
	public ResponseEntity<ItemMenu> viewItemMenu(@RequestParam int itemId) throws Exception {
		ItemMenu itemMenu2 = userServie.viewItemMenu(itemId);
		return new ResponseEntity<ItemMenu>(itemMenu2, HttpStatus.FOUND);
	}

	@DeleteMapping("/removeItemMenu")
	public ResponseEntity<String> removeItemMenu(@RequestParam int itemId) throws Exception {
		String itemMenu2 = userServie.removeItemMenu(itemId);
		return new ResponseEntity<String>(itemMenu2, HttpStatus.OK);
	}

	@PostMapping("/addPayment")
	public ResponseEntity<Payment> addPayment(@RequestBody Payment payment, @RequestParam int orderId)
			throws Exception {
		Payment payment2 = userServie.addPayment(payment, orderId);
		return new ResponseEntity<Payment>(payment2, HttpStatus.CREATED);
	}

	@GetMapping("/viewPayment")
	public ResponseEntity<Payment> viewPayment(@RequestParam int paymentId) throws Exception {
		Payment payment2 = userServie.viewPayment(paymentId);
		return new ResponseEntity<Payment>(payment2, HttpStatus.FOUND);
	}

	@DeleteMapping("/cancelPayment")
	public ResponseEntity<String> cancelPayment(@RequestParam int paymentId) throws Exception {
		String payment2 = userServie.cancelPayment(paymentId);
		return new ResponseEntity<String>(payment2, HttpStatus.OK);
	}

	@PutMapping("/updateReview")
	public ResponseEntity<Review> updateReview(@RequestBody Review review, @RequestParam int userId) throws Exception {
		Review review2 = userServie.updateReview(review, userId);
		return new ResponseEntity<Review>(review2, HttpStatus.ACCEPTED);
	}

	@GetMapping("/viewReview")
	public ResponseEntity<Review> viewReview(@RequestParam int reviewId) throws Exception {
		Review review2 = userServie.viewReview(reviewId);
		return new ResponseEntity<Review>(review2, HttpStatus.FOUND);
	}

	@DeleteMapping("/deleteReview")
	public ResponseEntity<String> deleteReview(@RequestParam int reviewId) throws Exception {
		String review2 = userServie.deleteReview(reviewId);
		return new ResponseEntity<String>(review2, HttpStatus.OK);
	}

	
	@PostMapping("/addReview")
	public ResponseEntity<Review> addReview(@RequestBody Review review, @RequestParam int userId) throws Exception {
		Review  review2 =   userServie.addReview(review, userId);
		return new ResponseEntity<Review>(review2, HttpStatus.CREATED);
	}
	
	
	
}
