package com.hotels.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.dao.hotelsDAO;
import com.hotels.model.hotels;

@Service
public class hotelsService {

	@Autowired
	hotelsDAO hotelsDao;

	public List<hotels> allhotels(){
		return (List<hotels>) hotelsDao.findAll();
	}

	public List<hotels> topFivehotels(){
		return (List<hotels>) hotelsDao.findTopFivehotels();
	}

	public hotels searchhotelsById(int id){
		Optional<hotels> h = hotelsDao.findById(id);
		if(h.isPresent()){
			return h.get();
		}
		return null;
	}

	public hotels searchhotelsByName(String name){
		Optional<hotels> h = hotelsDao.findByhotelsName(name);
		if(h.isPresent()){
			return h.get();
		}
		return null;
	}

	public List<hotels> searchhotelsByPrice(Double startPrice, Double endPrice){
		return (List<hotels>) hotelsDao.findByPriceBetween(startPrice,endPrice);
	}

	public List<hotels> searchhotelsByVolume(Double startVolume, Double endVolume){
		return (List<hotels>) hotelsDao.findByVolumeBetween(startVolume,endVolume);
	}

	public List<hotels> searchhotelsByDate(Date startDate, Date endDate){
		return (List<hotels>) hotelsDao.findByDateBetween(startDate,endDate);
	}

}