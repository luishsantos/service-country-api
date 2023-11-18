package com.example.countryinfo.controller;

import com.example.countryinfo.dto.CountryDTO;
import com.example.countryinfo.service.CountryInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/countries")
public class CountryInfoController {

  private final CountryInfoService countryInfoService;

  @GetMapping(value = "/{name}")
  public ResponseEntity<CountryDTO> getCountryByName(@PathVariable String name) {
    return ResponseEntity.ok(countryInfoService.getCountryByName(name));
  }

}
