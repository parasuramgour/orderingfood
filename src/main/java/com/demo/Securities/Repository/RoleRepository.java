package com.demo.Securities.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.Securities.Entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String>{

}
