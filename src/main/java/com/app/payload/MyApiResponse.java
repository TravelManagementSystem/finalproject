package com.app.payload;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class MyApiResponse {
	private String mesg;
	private LocalDate time;
	
	public MyApiResponse(String mesg) {
		super();
		this.mesg = mesg;
		this.time = LocalDate.now();
	}
	
	
}
