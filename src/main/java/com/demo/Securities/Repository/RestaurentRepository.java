package com.demo.Securities.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.Securities.Entity.Restaurent;

@Repository
public interface RestaurentRepository  extends JpaRepository<Restaurent, Integer>{

}
