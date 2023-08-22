package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "package")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Package
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "package_id")
	private Long packageId;
	@Column(length = 20,nullable = false)
	private String packageName;
	@Enumerated(EnumType.STRING) 
	@Column(length = 20)
	private PackageType packageType;
	private double price;
	@Column(length = 200,nullable = false)
	private String description;
	private LocalDate start_date;
	private LocalDate last_date;
	private boolean paymentStatus;
	private int personCount;
	private double totalPayment;
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name = "package_city" ,
		joinColumns = @JoinColumn(name="package_id"),
		inverseJoinColumns = @JoinColumn(name = "city_id"))
	private List<City> city = new ArrayList<City>();
	
	public void addCity(City c)
	{
		city.add(c);
	}

	public void removeCity(City c)
	{
		city.remove(c);
	}
	
}
