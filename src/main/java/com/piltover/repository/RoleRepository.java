package com.piltover.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piltover.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
