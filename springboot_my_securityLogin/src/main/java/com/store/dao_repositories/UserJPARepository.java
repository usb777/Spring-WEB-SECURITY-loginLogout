package com.store.dao_repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.model.User;

@Repository
public interface UserJPARepository extends JpaRepository<User, Integer> 
{
	User findByEmail(String email);
}
