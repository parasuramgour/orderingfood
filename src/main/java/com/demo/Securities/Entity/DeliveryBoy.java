package com.demo.Securities.Entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class DeliveryBoy {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int driverID;
	private String name;
	private long contactNumber;
	private String availability;

	public DeliveryBoy() {
		super();
	}

	public DeliveryBoy(int driverID, String name, long contactNumber, String availability, User user) {
		super();
		this.driverID = driverID;
		this.name = name;
		this.contactNumber = contactNumber;
		this.availability = availability;
		this.user = user;
		

	}

	public int getDriverID() {
		return driverID;
	}

	public void setDriverID(int driverID) {
		this.driverID = driverID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;

	}
	
	@OneToOne
	private  User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

}
