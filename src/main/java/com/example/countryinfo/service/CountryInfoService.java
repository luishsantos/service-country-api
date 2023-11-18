package com.example.countryinfo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.countryinfo.dto.CountryApiDTO;
import com.example.countryinfo.dto.CountryDTO;
import com.example.countryinfo.entity.CountryEntity;
import com.example.countryinfo.mapper.CountryMapper;
import com.example.countryinfo.parser.CountryParser;
import com.example.countryinfo.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CountryInfoService {
  private final CountryInfoApiService countryInfoApiService;

  private final CountryRepository countryRepository;

  private final CountryMapper mapper = Mappers.getMapper(CountryMapper.class);

  public void saveAllCountries() {
    CountryParser parser = Mappers.getMapper(CountryParser.class);
    List<CountryApiDTO> countryApiDTOList = new ArrayList<>(countryInfoApiService.getAllCountries());

    List<CountryDTO> countryDTOList = parser.toCountryDTOList(countryApiDTOList);

    List<CountryEntity> countryEntityList = mapper.toCountryEntityList(countryDTOList);

    countryRepository.saveAll(countryEntityList);
  }

  public CountryDTO getCountryByName(String name) {
    return mapper.toCountryDTO(countryRepository.findByName(name));
  }

}
