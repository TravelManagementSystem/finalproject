package com.app.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "password" )
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	@Column(length = 20,nullable = false)
	private String firstName;
	@Column(length = 20,nullable = false)
	private String lastName;
	@Column(length = 30,nullable = false,unique = true)
	private String email;
	@Column(length = 300,nullable = false)
	private String password;
	@Column(length = 30,nullable = false,unique = true)
	private String panNumber;
	private LocalDate DOB;
	@ManyToMany(cascade = CascadeType.PERSIST) // mandatory!
	@JoinTable(name="user_hotels",
	joinColumns = @JoinColumn(name="user_id"),
	inverseJoinColumns = @JoinColumn(name="hotel_id")
	)
	private Set<HotelList> hotels =new HashSet<>();
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private Package pkg;
	
	@ManyToMany(fetch = FetchType.LAZY)
	  @JoinTable(  name = "user_roles", 
	        joinColumns = @JoinColumn(name = "user_id"), 
	        inverseJoinColumns = @JoinColumn(name = "role_id"))
	  private Set<Role> roles = new HashSet<>();
	
	public User(String fname,String lname,String email,String pass,String pan,LocalDate d)
	{
		this.firstName = fname;
		this.lastName = lname;
		this.email = email;
		this.password = pass;
		this.panNumber = pan;
		this.DOB = d;
	}
}
