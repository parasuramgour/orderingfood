package com.demo.Securities.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Restaurent {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int restaurentId;
	private String restaurentName;
	private String addres;
	private long phoneno;
	private float rating;

	public Restaurent() {
		super();
	}

	public Restaurent(int restaurentId, String restaurentName, String addres, long phoneno, float rating,
			List<ItemMenu> itemMenu, User user) {
		super();
		this.restaurentId = restaurentId;
		this.restaurentName = restaurentName;
		this.addres = addres;
		this.phoneno = phoneno;
		this.rating = rating;
		this.user = user;
		this.itemMenu = itemMenu;
	}

	public int getRestaurentId() {
		return restaurentId;
	}

	public void setRestaurentId(int restaurentId) {
		this.restaurentId = restaurentId;
	}

	public String getRestaurentName() {
		return restaurentName;
	}

	public void setRestaurentName(String restaurentName) {
		this.restaurentName = restaurentName;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public long getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public List<ItemMenu> getItemMenu() {
		return itemMenu;
	}

	public void setItemMenu(List<ItemMenu> itemMenu) {
		this.itemMenu = itemMenu;
	}
	
	@ManyToOne
	@JsonBackReference
    private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "restaurent")
	@JsonManagedReference
	private List<ItemMenu> itemMenu;

}
