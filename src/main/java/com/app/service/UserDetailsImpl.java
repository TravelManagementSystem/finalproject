package com.app.service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.app.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails 
{
	private static final long serialVersionUID = 1L;
	
	  private Long id;

	  private String firstName;
	  
	  private String lastName;

	  private String email;
	  @JsonIgnore
	  private String password;
	  
	  private String panNumber;
	  
	  private LocalDate dob;
	  
	  private Collection<? extends GrantedAuthority> authorities;
	  
	  public UserDetailsImpl(Long id,String fname,String lname,String email,String pass,String pan,LocalDate d,Collection<? extends GrantedAuthority> authority) {
			super();
			this.id = id;
			this.firstName = fname;
			this.lastName = lname;
			this.email = email;
			this.password = pass;
			this.panNumber = pan;
			this.dob = d;
			this.authorities = authority;
		}

	  public static UserDetailsImpl build(User user) {
		    List<GrantedAuthority> authorities = user.getRoles().stream()
		        .map(role -> new SimpleGrantedAuthority(role.getName().name()))
		        .collect(Collectors.toList());
		    
		    return new UserDetailsImpl(
		    		user.getUserId(),
		    		user.getFirstName(),
		    		user.getLastName(),
		    		user.getEmail(),
		    		user.getPassword(),
		    		user.getPanNumber(),
		    		user.getDOB(),
		    		authorities);
	  }
	  @Override
	  public Collection<? extends GrantedAuthority> getAuthorities() {
		  return authorities;
	  }
	  
	  public Long getId() 
	  {
		return id;
	  }
	  
	  public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() 
	  {
		return email;
	  }
	  
	  public LocalDate getDob()
	  {
		  return dob;
	  }
	  
	  public String getPan() 
	  {
		return panNumber;
	  }
	  
	  @Override
	  public String getPassword() {
	    return password;
	  }

	  @Override
	  public String getUsername() {
	    return email;
	  }

	  @Override
	  public boolean isAccountNonExpired() {
	    return true;
	  }

	  @Override
	  public boolean isAccountNonLocked() {
	    return true;
	  }

	  @Override
	  public boolean isCredentialsNonExpired() {
	    return true;
	  }

	  @Override
	  public boolean isEnabled() {
	    return true;
	  }

	}
