package com.demo.Securities.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Securities.Entity.DeliveryBoy;
import com.demo.Securities.Entity.OrderItem;
import com.demo.Securities.Entity.Restaurent;
import com.demo.Securities.Entity.User;
import com.demo.Securities.Service.AdminService;

import jakarta.annotation.PostConstruct;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostConstruct
	public void addRoles() {
		adminService.addRoles();
	}

	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		User user2 = adminService.addUser(user);
		return new ResponseEntity<>(user2, HttpStatus.CREATED);
	}

	@PutMapping("/updateUser")
	@PreAuthorize("hasRole('Customer')")
	public ResponseEntity<User> updateUser(@RequestBody User user, @RequestParam int userId) throws Exception {
		User user2 = adminService.updateUser(user, userId);
		return new ResponseEntity<User>(user2, HttpStatus.ACCEPTED);
	}

	@GetMapping("/getUser")
	@PreAuthorize("hasRole('Customer')")
	public ResponseEntity<User> getUser(@RequestParam int userId) throws Exception {
		User user2 = adminService.getUser(userId);
		return new ResponseEntity<User>(user2, HttpStatus.FOUND);
	}

	@PostMapping("/addAdmin")
	public ResponseEntity<User> addAdmin(@RequestBody User admin) {
		User admin2 = adminService.addAdmin(admin);
		return new ResponseEntity<>(admin2, HttpStatus.CREATED);
	}

	@PutMapping("/updateAdmin")
	@PreAuthorize("hasRole('Admin')")
	public ResponseEntity<User> updateAdmin(@RequestParam int adminId, @RequestBody User admin) throws Exception {
		User admin2 = adminService.updateAdmin(adminId, admin);
		return new ResponseEntity<User>(admin2, HttpStatus.ACCEPTED);
	}

	@GetMapping("/getAdmin")
	@PreAuthorize("hasRole('Admin')")
	public ResponseEntity<User> getAdmin(@RequestParam int adminId) throws Exception {
		User admin2 = adminService.getAdmin(adminId);
		return new ResponseEntity<User>(admin2, HttpStatus.OK);
	}

	@PostMapping("/addRestaurent")
	public ResponseEntity<Restaurent> addRestaurent(@RequestBody Restaurent restaurent, @RequestParam int userId) throws Exception {
		Restaurent restaurent2 = adminService.addRestaurent(restaurent, userId);
		return new ResponseEntity<Restaurent>(restaurent2, HttpStatus.CREATED);
	}

	@PutMapping("/updateRestaurent")
	public ResponseEntity<Restaurent> updateRestaurent(@RequestBody Restaurent restaurent,
			@RequestParam int restaurentId) throws Exception {
		Restaurent restaurent2 = adminService.updateRestaurent(restaurent, restaurentId);
		return new ResponseEntity<Restaurent>(restaurent2, HttpStatus.ACCEPTED);
	}

	@GetMapping("/viewRestaurent")
	public ResponseEntity<Restaurent> viewRestaurent(@RequestParam int restaurentId) throws Exception {
		Restaurent restaurent2 = adminService.viewRestaurent(restaurentId);
		return new ResponseEntity<Restaurent>(restaurent2, HttpStatus.FOUND);
	}

	@DeleteMapping("/removeRestaurent")
	public ResponseEntity<String> removeRestaurent(@RequestParam int restaurentId) throws Exception {
		String restaurent2 = adminService.removeRestaurent(restaurentId);
		return new ResponseEntity<String>(restaurent2, HttpStatus.OK);
	}

	@GetMapping("/listofOrder")
	public ResponseEntity<List<OrderItem>> listofOrder(@RequestParam LocalDate date1, @RequestParam LocalDate date2) {
		List<OrderItem> orderItem = adminService.listofOrder(date1, date2);
		return new ResponseEntity<List<OrderItem>>(orderItem, HttpStatus.FOUND);
	}

	@GetMapping("/monthlyRevenue")
	public ResponseEntity<Double> monthlyRevenue(@RequestParam LocalDate date1, @RequestParam LocalDate date2) {
		double d1 = adminService.monthlyRevenue(date1, date2);
		return new ResponseEntity<Double>(d1, HttpStatus.FOUND);

	}

	@PostMapping("/addDeliveryBoy")
	public ResponseEntity<DeliveryBoy> addDeliveryBoy(@RequestBody DeliveryBoy deliveryBoy, @RequestParam int userId) throws Exception {
		DeliveryBoy deliveryBoy2 = adminService.addDeliveryBoy(deliveryBoy, userId);
		return new ResponseEntity<DeliveryBoy>(deliveryBoy2, HttpStatus.CREATED);
	}

	@PutMapping("/updateDeliveryBoy")
	public ResponseEntity<DeliveryBoy> updateDeliveryBoy(@RequestBody DeliveryBoy deliveryBoy,
			@RequestParam int driverId) throws Exception {
		DeliveryBoy deliveryBoy2 = adminService.updateDeliveryBoy(deliveryBoy, driverId);
		return new ResponseEntity<DeliveryBoy>(deliveryBoy2, HttpStatus.ACCEPTED);
	}

	@GetMapping("/getDeliveryBoy")
	public ResponseEntity<DeliveryBoy> getDeliveryBoy(@RequestParam int driverId) throws Exception {
		DeliveryBoy deliveryBoy2 = adminService.getDeliveryBoy(driverId);
		return new ResponseEntity<DeliveryBoy>(deliveryBoy2, HttpStatus.FOUND);
	}

	@DeleteMapping("/deleteDeliveryBoy")
	public ResponseEntity<String> deleteDeliveryBoy(@RequestParam int driverId) throws Exception {
		String deliveryBoy2 = adminService.deleteDeliveryBoy(driverId);
		return new ResponseEntity<String>(deliveryBoy2, HttpStatus.OK);
	}

}
