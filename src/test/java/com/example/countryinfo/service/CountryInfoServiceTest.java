package com.example.countryinfo.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;

import com.example.countryinfo.client.CountryInfoApiClient;
import com.example.countryinfo.dto.CountryApiDTO;
import com.example.countryinfo.dto.CountryDTO;
import com.example.countryinfo.entity.CountryEntity;
import com.example.countryinfo.repository.CountryRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CountryInfoServiceTest {
  @Mock
  private CountryRepository countryRepository;
  @InjectMocks
  private CountryInfoService countryInfoService;

  private static CountryDTO countryDTO;
  private static CountryEntity countryEntity;

  @BeforeAll
  public static void setup(){
    countryEntity = CountryEntity.builder()
        .name("countryName")
        .capital("countryCapital")
        .officialLanguage("officalLanguage")
        .currency("currency")
        .population(1)
        .longitude(2.0)
        .latitude(2.0)
        .build();

  }


  @Test
  void getCountryByName() {
    Mockito.when(countryRepository.findByName("countryName")).thenReturn(countryEntity);

    CountryDTO actualCountryDTO = countryInfoService.getCountryByName("countryName");

    assertEquals(countryEntity.getName(),actualCountryDTO.getName());
    assertEquals(countryEntity.getCapital(),actualCountryDTO.getCapital());
    assertEquals(countryEntity.getOfficialLanguage(),actualCountryDTO.getLanguage());
    assertEquals(countryEntity.getCurrency(),actualCountryDTO.getCurrency());
    assertEquals(countryEntity.getPopulation(),actualCountryDTO.getPopulation());
    assertEquals(countryEntity.getLongitude(),actualCountryDTO.getLongitude());
    assertEquals(countryEntity.getLatitude(),actualCountryDTO.getLatitude());

  }

}