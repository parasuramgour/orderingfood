package com.demo.Securities.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.Securities.Entity.ItemMenu;

@Repository
public interface ItemMenuRepository extends JpaRepository<ItemMenu,Integer> {

}
