package com.app.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class JwtResponse {
  private String token;
  private String type = "Bearer";
  private Long id;
  private String firstName;
  private String lastName;
  private String email;
  private String panNumber;
  private LocalDate dob;
  private List<String> roles;

  public JwtResponse(String accessToken, Long id,String fname,String lname,String email,String pan, LocalDate d, List<String> roles) {
    this.token = accessToken;
    this.id = id;
	this.firstName = fname;
	this.lastName = lname;
	this.email = email;
	this.panNumber = pan;
	this.dob = d;
    this.roles = roles;
  }

}
