package com.store.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.store.model.Role;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "user")
public class User 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "user_id") //  
	
	int user_id;	
	
	@Column(name = "dateof_birth")//
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date dateof_birth;
	
	@Column(name = "job") //
	String job;
	
	@Column(name = "name")  //
	String name;
	
	@Column(name = "age") //
	int age;
	
	@Column(name = "email")//
	String email;
	
	@Column(name = "is_enabled")//
	boolean is_enabled;
	
	@Column(name = "password")//
	String password;
	
	@Column(name = "username")  //
	String username;
	
	
	/*
	@Column(name = "address_id")
	int address_id;
	*/
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")	
    private Address address;
	
	
	

	 @ManyToMany(cascade=CascadeType.ALL)
	 @JoinTable(name="user_role", joinColumns=@JoinColumn(name="user_id"), inverseJoinColumns=@JoinColumn(name="role_id"))
	 private Set<Role> roles;
	
	
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Date getDateof_birth() {
		return dateof_birth;
	}
	public void setDateof_birth(Date dateof_birth) {
		this.dateof_birth = dateof_birth;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isIs_enabled() {
		return is_enabled;
	}
	public void setIs_enabled(boolean is_enabled) {
		this.is_enabled = is_enabled;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	/*
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	
	*/
	
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	

	 public Set<Role> getRoles() {
	  return roles;
	 }

	 public void setRoles(Set<Role> roles) {
	  this.roles = roles;
	 }

	
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", dateof_birth=" + dateof_birth + ", job=" + job + ", name=" + name
				+ ", age=" + age + ", email=" + email + ", is_enabled=" + is_enabled + ", password=" + password
				+ ", username=" + username +  ", address=" + address.id   +"]";
	}
	

	
	
	

}
