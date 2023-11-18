package com.example.countryinfo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.countryinfo.client.CountryInfoApiClient;
import com.example.countryinfo.dto.CountryApiDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CountryInfoApiService {

  private final CountryInfoApiClient countryInfoApiClient;

  public List<CountryApiDTO> getAllCountries() {
    return new ArrayList<>(countryInfoApiClient.getAllCountries());
  }

}
