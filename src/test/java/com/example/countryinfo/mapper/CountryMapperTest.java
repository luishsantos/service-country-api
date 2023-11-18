package com.example.countryinfo.mapper;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.example.countryinfo.dto.CountryDTO;
import com.example.countryinfo.entity.CountryEntity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class CountryMapperTest {

  private static CountryMapper countryMapper;
  private static CountryEntity countryEntity;
  private static CountryDTO countryDTO;
  private static List<CountryDTO> countryDTOList;

  @BeforeAll
  public static void setUp() {
    countryMapper = Mappers.getMapper(CountryMapper.class);

    countryEntity = CountryEntity.builder()
        .name("countryName")
        .capital("countryCapital")
        .officialLanguage("officalLanguage")
        .currency("currency")
        .population(1)
        .longitude(2.0)
        .latitude(2.0)
        .build();

    countryDTO = CountryDTO.builder()
        .name("countryName")
        .capital("countryCapital")
        .language("officalLanguage")
        .currency("currency")
        .population(1)
        .longitude(2.0)
        .latitude(2.0)
        .build();

    countryDTOList = Collections.singletonList(countryDTO);
  }

  @Test
  void toCountryEntity() {
    CountryEntity actualCountryEntity = countryMapper.toCountryEntity(countryDTO);

    assertEquals(countryEntity.getName(),actualCountryEntity.getName());
    assertEquals(countryEntity.getCapital(),actualCountryEntity.getCapital());
    assertEquals(countryEntity.getOfficialLanguage(),actualCountryEntity.getOfficialLanguage());
    assertEquals(countryEntity.getCurrency(),actualCountryEntity.getCurrency());
    assertEquals(countryEntity.getLongitude(),actualCountryEntity.getLongitude());
    assertEquals(countryEntity.getLatitude(),actualCountryEntity.getLatitude());

  }

  @Test
  void toCountryDTO() {
    CountryDTO actualCountryDTO = countryMapper.toCountryDTO(countryEntity);

    assertEquals(countryDTO.getName(),actualCountryDTO.getName());
    assertEquals(countryDTO.getCapital(),actualCountryDTO.getCapital());
    assertEquals(countryDTO.getLanguage(),actualCountryDTO.getLanguage());
    assertEquals(countryDTO.getCurrency(),actualCountryDTO.getCurrency());
    assertEquals(countryDTO.getPopulation(),actualCountryDTO.getPopulation());
    assertEquals(countryDTO.getLongitude(),actualCountryDTO.getLongitude());
    assertEquals(countryDTO.getLatitude(),actualCountryDTO.getLatitude());
  }

  @Test
  void toCountryEntityList() {
    List<CountryEntity> actualCountryList = countryMapper.toCountryEntityList(countryDTOList);

    assertEquals(countryEntity.getName(),actualCountryList.get(0).getName());
    assertEquals(countryEntity.getCapital(),actualCountryList.get(0).getCapital());
    assertEquals(countryEntity.getOfficialLanguage(),actualCountryList.get(0).getOfficialLanguage());
    assertEquals(countryEntity.getCurrency(),actualCountryList.get(0).getCurrency());
    assertEquals(countryEntity.getLongitude(),actualCountryList.get(0).getLongitude());
    assertEquals(countryEntity.getLatitude(),actualCountryList.get(0).getLatitude());

  }

}