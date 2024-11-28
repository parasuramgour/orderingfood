package com.demo.Securities.ServiceImple;

import java.time.LocalDate;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.Securities.Entity.DeliveryBoy;
import com.demo.Securities.Entity.OrderItem;
import com.demo.Securities.Entity.Restaurent;
//import com.demo.Securities.Entity.Review;
import com.demo.Securities.Entity.Role;
import com.demo.Securities.Entity.User;
import com.demo.Securities.Repository.DeliveryBoyRepository;
import com.demo.Securities.Repository.OrderItemRepository;
import com.demo.Securities.Repository.RestaurentRepository;
//import com.demo.Securities.Repository.ReviewRepository;
import com.demo.Securities.Repository.RoleRepository;
import com.demo.Securities.Repository.UserRepository;
import com.demo.Securities.Service.AdminService;

@Service
public class AdminServiceImplementation implements AdminService {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestaurentRepository restaurentRepository;

	//@Autowired
	//private ReviewRepository reviewRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private DeliveryBoyRepository  deliveryBoyRepository;

	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

	@Override
	public String addRoles() {
		Role adminRole = new Role();
		adminRole.setRole("Admin");
		roleRepository.save(adminRole);

		Role customerRole = new Role();
		customerRole.setRole("customer");
		roleRepository.save(customerRole);
		return "Succeess";
	}

	@Override
	public User addUser(User user) {
		
		Role role = roleRepository.findById("customer").get();
		Set<Role> customerRole = new HashSet<Role>();
		customerRole.add(role);
		user.setRoles(customerRole);
		user.setPassword(encoder.encode(user.getPassword()));
		return userRepository.save(user);

	}

	@Override
	public User updateUser(User user, int userId) throws Exception {
		User user2 = userRepository.findById(userId).orElseThrow(() -> new Exception("Customer Not Found...!!!"));
		user2.setEmail(user.getEmail());
		user2.setPassword(encoder.encode(user.getPassword()));
		return userRepository.save(user2);
	}

	@Override
	public User getUser(int userId) throws Exception {
		User customer2 = userRepository.findById(userId).orElseThrow(() -> new Exception("Customer Not Found...!!!"));
		return customer2;
	}

	@Override
	public User addAdmin(User admin) {
		Role role = roleRepository.findById("Admin").get();
		Set<Role> adminRole = new HashSet<Role>();
		adminRole.add(role);
		admin.setRoles(adminRole);
		admin.setPassword(encoder.encode(admin.getPassword()));
		return userRepository.save(admin);
	}

	@Override
	public User updateAdmin(int userId, User admin) throws Exception {
		User admin1 = userRepository.findById(userId).orElseThrow(() -> new Exception("Admin Not Found...!!!"));
		admin1.setEmail(admin.getEmail());
		admin1.setPassword(encoder.encode(admin.getPassword()));
		return userRepository.save(admin1);
	}

	@Override
	public User getAdmin(int userId) throws Exception {
		User admin = userRepository.findById(userId).orElseThrow(() -> new Exception("Admin Not Found...!!!"));
		return admin;
	}

	@Override
	public Restaurent addRestaurent(Restaurent restaurent, int userId) throws Exception {
	User user2  =	userRepository.findById(userId).orElseThrow(() -> new Exception("Restaurent not found"));
	restaurent.setUser(user2);
		Restaurent  restaurent2 = 	restaurentRepository.save(restaurent);
		
		return restaurent2 ;
	}

	@Override
	public Restaurent updateRestaurent(Restaurent restaurent, int restaurentId) throws Exception {
		Restaurent restaurent2 = restaurentRepository.findById(restaurentId)
				.orElseThrow(() -> new Exception("Restaurent not found"));
		restaurent2.setPhoneno(restaurent.getPhoneno());
		restaurent2.setRating(restaurent.getRating());
		return restaurent2;
	}

	@Override
	public Restaurent viewRestaurent(int restaurentId) throws Exception {
		Restaurent restaurent2 = restaurentRepository.findById(restaurentId)
				.orElseThrow(() -> new Exception("Restaurent not found"));
		return restaurent2;
	}

	@Override
	public String removeRestaurent(int restaurentId) throws Exception {
		Restaurent restaurent2 = restaurentRepository.findById(restaurentId)
				.orElseThrow(() -> new Exception("Restaurent not found"));
		restaurentRepository.delete(restaurent2);
		return "Removed succeessfully";
	}

	@Override
	public List<OrderItem> listofOrder(LocalDate date1, LocalDate date2) {
		List<OrderItem> orderItem2 = orderItemRepository.findByOrderDate(date1, date2);
		return orderItem2;
	}

	@Override
	public double monthlyRevenue(LocalDate date1, LocalDate date2) {
		List<OrderItem> orderItem2 = orderItemRepository.findByBetweenDates(date1, date2);
		double totalRevenue = 0.0;
		for (OrderItem orderItem : orderItem2) {
			totalRevenue += orderItem.getBill();
		}

		return totalRevenue;
	}

	@Override
	public DeliveryBoy addDeliveryBoy(DeliveryBoy deliveryBoy, int userId) throws Exception {
	User user2 =	userRepository.findById(userId).orElseThrow(() -> new Exception("Delivery not found"));
	deliveryBoy.setUser(user2);
		DeliveryBoy  deliveryBoy2 =	deliveryBoyRepository.save(deliveryBoy);
		return deliveryBoy2;
	}

	@Override
	public DeliveryBoy updateDeliveryBoy(DeliveryBoy deliveryBoy, int driverId) throws Exception {
		DeliveryBoy deliveryBoy2 =	deliveryBoyRepository.findById(driverId).orElseThrow(() -> new Exception("Driver not found"));
		deliveryBoy2.setContactNumber(deliveryBoy.getContactNumber());
		deliveryBoy2.setAvailability(deliveryBoy.getAvailability());
		return deliveryBoy2;
	}

	@Override
	public DeliveryBoy getDeliveryBoy(int driverId) throws Exception {
		DeliveryBoy deliveryBoy2 =	deliveryBoyRepository.findById(driverId).orElseThrow(() -> new Exception("Driver not found"));
		return deliveryBoy2;
	}

	@Override
	public String deleteDeliveryBoy(int driverId) throws Exception {
		DeliveryBoy deliveryBoy2 =	deliveryBoyRepository.findById(driverId).orElseThrow(() -> new Exception("Driver not found"));
		deliveryBoyRepository.delete(deliveryBoy2);
		return "Deleted Succeessfully";
	}

}