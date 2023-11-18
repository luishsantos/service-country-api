package com.example.countryinfo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    List<CountryEntity> storedCountries = countryRepository.findAll();

    upsertCountries(countryDTOList, storedCountries);

    countryRepository.saveAll(storedCountries);
  }

  private void upsertCountries(List<CountryDTO> countryDTOList, List<CountryEntity> storedCountries) {
    for(CountryDTO countryDTO : countryDTOList) {
      Optional<CountryEntity> existingCountryOpt = storedCountries.stream()
          .filter(existingCountry -> existingCountry.getName().equals(countryDTO.getName()))
          .findFirst();

      if(existingCountryOpt.isPresent()) {
        // Update existing country
        CountryEntity existingCountry = existingCountryOpt.get();
        updateExistingCountry(existingCountry, countryDTO);
      }
      else {
        // Add new country
        CountryEntity newCountryEntity = mapper.toCountryEntity(countryDTO);
        storedCountries.add(newCountryEntity);
      }
    }
  }

  public CountryDTO getCountryByName(String name) {
    return mapper.toCountryDTO(countryRepository.findByName(name));
  }

  private void updateExistingCountry(CountryEntity existingCountry, CountryDTO countryDTO) {
    existingCountry.setCapital(countryDTO.getCapital());
    existingCountry.setOfficialLanguage(countryDTO.getLanguage());
    existingCountry.setLatitude(countryDTO.getLatitude());
    existingCountry.setLongitude(countryDTO.getLongitude());
    existingCountry.setCurrency(countryDTO.getCurrency());
  }

}
