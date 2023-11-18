package com.example.countryinfo;

import com.example.countryinfo.service.CountryInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@RequiredArgsConstructor
public class CountryInfoApplication {
	private final CountryInfoService countryInfoService;

	public static void main(String[] args) {
		SpringApplication.run(CountryInfoApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void startUp() {
		countryInfoService.saveAllCountries();
	}

}
