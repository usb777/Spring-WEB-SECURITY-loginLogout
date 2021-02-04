package com.store.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Address 
{
	@Id
	@GeneratedValue
	@Column(name = "id")
	int id ; 
	
	@Column
	String address ;
	
	@Column
	String phonenumber; 
	
	@Column
	String city ; 
	
	@Column
	String state ; 
	
	@Column
	String country ; 
	
	@Column
	int zipcode ;
	
	
/*	
	@Column
	int user_id ;
	*/
	
	@OneToOne(mappedBy = "address")
    private User user;
	
	public Address() 
	{
		super();
	}
	

	public Address(int id, String address, String phonenumber, String city, String state, String country, int zipcode /*,	int user_id*/) 
	{
		super();
		this.id = id;
		this.address = address;
		this.phonenumber = phonenumber;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
		//this.user_id = user_id;
	}

	

	public Address( String address, String phonenumber, String city, String state, String country, int zipcode/*,	int user_id*/) 
	{
		super();
		
		this.address = address;
		this.phonenumber = phonenumber;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
	//	this.user_id = user_id;
	}

	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhonenumber() {
		return phonenumber;
	}


	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public int getZipcode() {
		return zipcode;
	}


	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	/*

	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

*/
	@Override
	public String toString() {
		return "Address [id=" + id + ", address=" + address + ", phonenumber=" + phonenumber + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", zipcode=" + zipcode +/* ", user_id=" + user_id + */"]";
	}


	
	

}
