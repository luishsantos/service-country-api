package com.example.countryinfo.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import com.example.countryinfo.dto.CountryApiDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class DefaultCountryInfoApiClient implements CountryInfoApiClient{
  private static final String BASE_URL = "https://countryinfoapi.com"; // API base URL

  private final RestTemplate restTemplate;

  @Override
  public List<CountryApiDTO> getAllCountries() {
    String url = BASE_URL + "/api/countries";

    ResponseEntity<CountryApiDTO[]> response =
        restTemplate.getForEntity(
            url,
            CountryApiDTO[].class);

    return new ArrayList<>(Arrays.asList(Objects.requireNonNull(response.getBody())));
  }

}
