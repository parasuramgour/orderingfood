package com.demo.Securities.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;


import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ReviewID;
	private int Rating;
	private String Comment;

	public Review() {
		super();
	}

	public Review(int reviewID, int rating, String comment, User user) {
		super();
		this.ReviewID = reviewID;
		this.Rating = rating;
		this.Comment = comment;
		this.user = user;
	}

	public int getReviewID() {
		return ReviewID;
	}

	public void setReviewID(int reviewID) {
		ReviewID = reviewID;
	}

	public int getRating() {
		return Rating;
	}

	public void setRating(int rating) {
		Rating = rating;
	}

	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	@JsonBackReference
	private User user;

}
