package com.store.services;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.store.model.User;



public interface IUserService 
{
	
	  public List<User> getUsers();
	  public User getUserByID(int id);
	  public User saveNewUser(User u);
	  public User updateUser(User u);
	  public void deleteUser(int id);
	  
	  public User findUserByEmail(String email);
	  
	  
	  @Query("SELECT u FROM User u WHERE u.status = 1")
	 public Collection<User> findAllActiveUsers();
}
