package com.hotels.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.stock.model.hotels;
import com.hotels.service.hotelsService;

@Controller
public class hotelsController {

	@Autowired
	hotelsService hotelsService;

	@GetMapping(value="/allhotels")
	public ResponseEntity<?> hotelsList()
	{
		return new ResponseEntity<List<hotels>>(hotelsService.allhotels(),HttpStatus.OK);
	}

	@GetMapping(value="/topFivehotels")
	public ResponseEntity<?> topFivehotels()
	{
		return new ResponseEntity<List<hotels>>(hotelsService.topFivehotels(),HttpStatus.OK);
	}

	@GetMapping(value="/searchhotelsById/{id}")
	public ResponseEntity<?> searchhotelsById(@PathVariable("id") int id)
	{
		hotels hotel = hotelsService.searchhotelsById(id);
		if(h==null){
			return new ResponseEntity<String>("not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<hotels>(hotel,HttpStatus.OK);
	}

	@GetMapping(value="/searchhotelsByName/{name}")
	public ResponseEntity<?> searchhotelsById(@PathVariable("name") String name)
	{
		hotels h = hotelsService.searchhotelsByName(name);
		if(h==null){
			return new ResponseEntity<String>("not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<hotels>(h,HttpStatus.OK);
	}

	@GetMapping(value="/searchhotelsByPrice/{startPrice}/{endPrice}")
	public ResponseEntity<?> searchhotelsByPrice(@PathVariable("startPrice") Double startPrice, @PathVariable("endPrice") Double endPrice )
	{
		List<hotels> h = hotelsService.searchhotelsByPrice(startPrice,endPrice);
		if(h.size()==0){
			return new ResponseEntity<String>("not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<hotels>>(h,HttpStatus.OK);
	}

	@GetMapping(value="/searchhotelsByVolume/{startVolume}/{endVolume}")
	public ResponseEntity<?> searchhotelsByVolume(@PathVariable("startVolume") Double startVolume, @PathVariable("endVolume") Double endVolume )
	{
		List<hotels> h = hotelsService.searchhotelsByVolume(startVolume,endVolume);
		if(h.size()==0){
			return new ResponseEntity<String>("not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<hotels>>(h,HttpStatus.OK);
	}

	@GetMapping(value="/searchhotelsByDate/{startDate}/{endDate}")
	public ResponseEntity<?> searchhotelsById(@PathVariable("startDate") Date startDate, @PathVariable("endDate") Date endDate )
	{
		List<hotels> h = hotelsService.searchhotelsByDate(startDate,endDate);
		if(h.size()==0){
			return new ResponseEntity<String>("not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<hotels>>(h,HttpStatus.OK);
	}
}