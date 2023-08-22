package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "hotel_details")
@Getter
@Setter
@NoArgsConstructor
public class HotelList 
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long hotelId;
	@Column(length = 50)
	private String hotelName;
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	@JoinColumn(name = "city_id")
	private City city;
	@Column(length = 200)
	private String hotelAddress;
	@NonNull
	private double hotelPrice;
//	@Lob
//	private byte[] hotelImage;
	private double hotelEarning;
	private boolean hotelActive;
	@ManyToMany(mappedBy = "hotels")
	private List<User> users = new ArrayList<>();

}