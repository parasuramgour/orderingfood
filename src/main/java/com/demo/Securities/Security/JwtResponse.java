package com.demo.Securities.Security;

import com.demo.Securities.Entity.User;

public class JwtResponse {
	
	private String token;
	private User customer;
	
	
	
	
	public JwtResponse() {
		super();
	}
	public JwtResponse(String token, User customer) {
		super();
		this.token = token;
		this.customer = customer;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public User getCustomer() {
		return customer;
	}
	public void setCustomer(User customer) {
		this.customer = customer;
	}



}
