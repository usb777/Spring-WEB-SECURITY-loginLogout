package com.store.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.store.model.Role;
import com.store.dao_repositories.RoleJPARespository;
import com.store.dao_repositories.UserJPARepository;
import com.store.model.Address;
import com.store.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@Transactional
public class UserService implements IUserService 
{

    private UserJPARepository userRepository;
    
  
    @Autowired
    public UserService( UserJPARepository userRepository) 
    {
        this.userRepository = userRepository;
    }
    
    
    
    @Autowired
    private RoleJPARespository roleRespository;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    
    
    

    
    @Override // override method from interface Service
    public User findUserByEmail(String email) 
    {
     return userRepository.findByEmail(email);
    }
    
    
    
    
    @Override
    public List<User> getUsers() 
    {
        return userRepository.findAll();
    }
    
	
	@Override
	public User getUserByID(int id) 
	{
		return userRepository.getOne(id);
	}
    
	
	
	
	
	
	 @Override
	 public User saveNewUser(User user) 
	 {
	  user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	  user.setIs_enabled(true);
	  Role userRole = roleRespository.findByRole("USER");
	  user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
	  //userRepository.save(user);
	  
	  return userRepository.save(user);
	 }
	
	/*
	 @Override
	 public User saveNewUser(User u) 
	 {
	        return userRepository.save(u);
	 }
	 
	 */

    /**
     * Sort method:Dzimtry
     * 
     * @Override public List<Role> getAllRoles() { return
     *           ud.findAll(Sort.by(Sort.Direction.ASC, "id")); //Sorted By    *  
     *                    userId asc }
     * 
     */
	
    
    
    
	   @Override
	    @Transactional
	    public User updateUser(User u) 
	   {
	        User oldUser = userRepository.getOne(u.getUser_id());
	       
	        if (u.getUsername() != null) 
	        {
	        	
	        	/*
	        	 	
	int user_id;	
	
	
	Date dateof_birth;  //2
	String job;      //3        
	String name;  //4
	int age; //5
	String email;  //6
	boolean is_enabled;  //7
	String password;  //8
	String username;  //9
	int usertype_id;//10
	private Address address; //11  
	    */    	
	        	
	        	 oldUser.setDateof_birth(u.getDateof_birth());  //2
	        	 oldUser.setJob(u.getJob()); //3
	            oldUser.setName(u.getName());   //4
	            oldUser.setAge(u.getAge()); //5
	            oldUser.setEmail(u.getEmail());  // 6
	            oldUser.setIs_enabled(u.isIs_enabled());//7
	            oldUser.setPassword(u.getPassword());  //8
	            oldUser.setUsername(u.getUsername()); //9
	            oldUser.setAddress(u.getAddress());  //11
	           
	         
	        }
	      //  return oldC; 
	        
	        return userRepository.save(oldUser);
	        
	    }
	    

	    @Override
	    public void deleteUser(int id)
	    {      
	        User oldC = userRepository.getOne(id); // getOne
	        userRepository.deleteById(id);
	       
	    }
	    
	    
	   public List<User> findAllActiveUsers()
	    { 
	    	
	    	return userRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
	    }


}