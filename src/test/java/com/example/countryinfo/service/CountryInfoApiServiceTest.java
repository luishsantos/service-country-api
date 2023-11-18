package com.example.countryinfo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.List;

import com.example.countryinfo.client.CountryInfoApiClient;
import com.example.countryinfo.dto.CountryApiDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CountryInfoApiServiceTest {

  @Mock
  private CountryInfoApiClient countryInfoApiClient;
  @InjectMocks
  private CountryInfoApiService countryInfoApiService;

  private static List<CountryApiDTO> countryApiDTOList;

  @BeforeAll
  public static void setup(){
    CountryApiDTO countryApiDTO = CountryApiDTO.builder()
        .name("countryName")
        .capital(Collections.singletonList("countryCapital"))
        .languages(Collections.singletonMap("por","officalLanguage"))
        .currencies(Collections.singletonMap("EUR", Collections.singletonMap("name", "Euro")))
        .population(1)
        .latlng(List.of(2.0, 2.0))
        .build();

    countryApiDTOList = Collections.singletonList(countryApiDTO);
  }
  @Test
  void getAllCountries() {
    Mockito.when(countryInfoApiClient.getAllCountries()).thenReturn(countryApiDTOList);

    List<CountryApiDTO> actualList = countryInfoApiService.getAllCountries();
    assertEquals(countryApiDTOList,actualList);
  }

}