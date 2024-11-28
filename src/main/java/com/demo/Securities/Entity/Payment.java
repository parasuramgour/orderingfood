package com.demo.Securities.Entity;

import java.time.LocalDate;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int paymentId;
	private String paymentmode;
	private LocalDate paymentdate;
	private String paymentstatus;

	public Payment() {
		super();
	}

	public Payment(int paymentId, String paymentmode, LocalDate paymentdate, String paymentstatus,
			OrderItem orderItem) {
		super();
		this.paymentId = paymentId;
		this.paymentmode = paymentmode;
		this.paymentdate = paymentdate;
		this.paymentstatus = paymentstatus;
		this.orderItem = orderItem;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentmode() {
		return paymentmode;
	}

	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}

	public LocalDate getPaymentdate() {
		return paymentdate;
	}

	public void setPaymentdate(LocalDate paymentdate) {
		this.paymentdate = paymentdate;
	}

	public String getPaymentstatus() {
		return paymentstatus;
	}

	public void setPaymentstatus(String paymentstatus) {
		this.paymentstatus = paymentstatus;
	}

	public OrderItem getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}

	@OneToOne(cascade = CascadeType.ALL)
	private OrderItem orderItem;

}
