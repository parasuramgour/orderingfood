package com.demo.Securities.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.Securities.Entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
