package com.hotels.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hotels.model.hotels;

@Repository
public interface hotelsDAO extends CrudRepository<hotels, Integer> {

	@Query(nativeQuery = true, value = "select * from hotels order by price desc limit 5;")
	public List<hotels> findTopFivehotels();

	public Optional<hotels> findByhotelsName(String name);

	public List<hotels> findByPriceBetween(Double startPrice, Double endPrice);

	public List<hotels> findByVolumeBetween(Double startVolume, Double endVolume);

	public List<hotels> findByDateBetween(Date startDate, Date endDate);


}