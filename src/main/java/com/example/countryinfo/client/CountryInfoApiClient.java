package com.example.countryinfo.client;

import java.util.List;

import com.example.countryinfo.dto.CountryApiDTO;

public interface CountryInfoApiClient {

  List<CountryApiDTO> getAllCountries();

  String getCountriesInRegion(String region);

  String getCountriesWhereLanguageIsSpoken(String language);
}
