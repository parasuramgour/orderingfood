package com.demo.Securities.Repository;



import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.Securities.Entity.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer>{
	
	
	
	@Query("SELECT o FROM OrderItem o WHERE o.orderDate BETWEEN : date1 AND : date2")
	List<OrderItem> findByOrderDate(@Param("date1") LocalDate date1,@Param("date2") LocalDate date2);


	@Query("SELECT o FROM OrderItem o WHERE o.orderDate BETWEEN : date1 AND : date2")
	List<OrderItem> findByBetweenDates(@Param("date1") LocalDate date1,@Param("date2") LocalDate date2);

	 

	
}
