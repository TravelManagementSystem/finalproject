package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="city")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "hotel")
public class City {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long cityId;
		@Column(length = 30,nullable = false)
		private String cityName;
		@Column(unique = true)
		private int cityPin;
		@Column(length = 30,nullable = false)
		private String cityState;
		@Column(length = 15,nullable = false)
		private String cityCountry;

		@OneToMany(mappedBy = "city",cascade = CascadeType.ALL,orphanRemoval = true)
		List<HotelList> hotel = new ArrayList<HotelList>();
		
		public void addHotel(HotelList c)
		{
			hotel.add(c);
			c.setCity(this);
		}
		
		public void removeHotel(HotelList c)
		{
			hotel.remove(c);
			c.setCity(null);
		}
}
