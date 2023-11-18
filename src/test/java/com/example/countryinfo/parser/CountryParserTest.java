package com.example.countryinfo.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.List;

import com.example.countryinfo.dto.CountryApiDTO;
import com.example.countryinfo.dto.CountryDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class CountryParserTest {

  private static CountryParser countryParser;

  private static CountryApiDTO countryApiDTO;

  private static CountryDTO countryDTO;

  private static List<CountryApiDTO> countryApiDTOList;

  @BeforeAll
  public static void setUp() {
    countryParser = Mappers.getMapper(CountryParser.class);

    countryApiDTO = CountryApiDTO.builder()
        .name("countryName")
        .capital(Collections.singletonList("countryCapital"))
        .languages(Collections.singletonMap("por", "officalLanguage"))
        .currencies(Collections.singletonMap("EUR", Collections.singletonMap("name", "Euro")))
        .population(1)
        .latlng(List.of(2.0, 2.0))
        .build();

    countryDTO = CountryDTO.builder()
        .name("countryName")
        .capital("countryCapital")
        .language("officalLanguage")
        .currency("Euro")
        .population(1)
        .longitude(2.0)
        .latitude(2.0)
        .build();

    countryApiDTOList = Collections.singletonList(countryApiDTO);
  }

  @Test
  void toCountryDTO() {
    CountryDTO actualCountryDTO = countryParser.toCountryDTO(countryApiDTO);

    assertEquals(countryDTO.getName(), actualCountryDTO.getName());
    assertEquals(countryDTO.getCapital(), actualCountryDTO.getCapital());
    assertEquals(countryDTO.getLanguage(), actualCountryDTO.getLanguage());
    assertEquals(countryDTO.getCurrency(), actualCountryDTO.getCurrency());
    assertEquals(countryDTO.getLatitude(), actualCountryDTO.getLatitude());
    assertEquals(countryDTO.getLongitude(), actualCountryDTO.getLongitude());
    assertEquals(countryDTO.getPopulation(), actualCountryDTO.getPopulation());
  }

  @Test
  void toCountryDTOList() {
    List<CountryDTO> actualCountryDTOList = countryParser.toCountryDTOList(countryApiDTOList);

    assertEquals(countryDTO.getName(), actualCountryDTOList.get(0).getName());
    assertEquals(countryDTO.getCapital(), actualCountryDTOList.get(0).getCapital());
    assertEquals(countryDTO.getLanguage(), actualCountryDTOList.get(0).getLanguage());
    assertEquals(countryDTO.getCurrency(), actualCountryDTOList.get(0).getCurrency());
    assertEquals(countryDTO.getLatitude(), actualCountryDTOList.get(0).getLatitude());
    assertEquals(countryDTO.getLongitude(), actualCountryDTOList.get(0).getLongitude());
    assertEquals(countryDTO.getPopulation(), actualCountryDTOList.get(0).getPopulation());

  }

}