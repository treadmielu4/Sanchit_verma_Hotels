package com.hotels.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hotels")
public class hotels {
	@Id
	private int hotelsId;
	private String hotelsName;
	private double price;
	private double volume;
	private Date date;



	public hotels() {
		super();
	}
	public hotels(int hotelsId, String hotelsName, double price, double volume, Date date) {
		super();
		this.hotelsId = hotelsId;
		this.hotelsName = hotelsName;
		this.price = price;
		this.volume = volume;
		this.date = date;
	}
	public int gethotelsId() {
		return hotelsId;
	}
	public void sethotelsId(int hotelsId) {
		this.hotelsId = hotelsId;
	}
	public String gethotelsName() {
		return hotelsName;
	}
	public void sethotelsName(String hotelsName) {
		this.hotelsName = hotelsName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}