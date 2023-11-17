package com.example.countryinfo.mapper;

import java.util.List;

import com.example.countryinfo.dto.CountryDTO;
import com.example.countryinfo.entity.CountryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CountryMapper {
  @Mapping(target="officialLanguage",source ="language")
  @Mapping(target = "id", ignore = true)
  CountryEntity toCountryEntity(CountryDTO countryDTO);


  @Mapping(target="language",source ="officialLanguage")
  CountryDTO toCountryDTO(CountryEntity countryEntity);

  List<CountryDTO> toCountryDTOList(List<CountryEntity> countryEntityList);
  List<CountryEntity> toCountryEntityList(List<CountryDTO> countryEntityList);
}
