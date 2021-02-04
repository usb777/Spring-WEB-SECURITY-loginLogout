package com.store.dao_repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.model.Role;

@Repository("roleRepository")
public interface RoleJPARespository extends JpaRepository<Role, Integer> 
{

 Role findByRole(String role);
}