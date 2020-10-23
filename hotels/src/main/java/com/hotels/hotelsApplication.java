package com.hotels;

import java.text.SimpleDateFormat;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hotels.dao.hotelsDAO;
import com.hotels.model.hotels;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
public class hotelsApplication {

	public static void main(String[] args) {
		SpringApplication.run(hotelsApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(final hotelsDAO repository) {

		final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return args -> {
			repository.save(new hotels(1, "Marriott", 5000, 5, format.parse("2020-01-01")));
			repository.save(new hotels(2, "Radison", 4000,2, format.parse("2020-02-01")));
			repository.save(new hotels(3, "Hyatt", 3000, 2, format.parse("2020-04-01")));
			repository.save(new hotels(4, "ITC", 6000, 10, format.parse("2019-04-01")));
			repository.save(new hotels(5, "Taj", 7000, 8, format.parse("2018-04-01")));
			repository.save(new hotels(6, "Hilton", 1000, 1, format.parse("2017-01-01")));
		};
	}

}