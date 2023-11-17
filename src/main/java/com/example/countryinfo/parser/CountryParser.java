package com.example.countryinfo.parser;

import java.util.List;
import java.util.Map;

import com.example.countryinfo.dto.CountryApiDTO;
import com.example.countryinfo.dto.CountryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CountryParser {
  @Mapping(target = "name", source ="name")
  @Mapping(target = "capital", expression ="java(!countryApiDTO.getCapital().isEmpty() ? countryApiDTO.getCapital().get(0) : null)")
  @Mapping(target = "language", expression ="java(!countryApiDTO.getLanguages().isEmpty() ? countryApiDTO.getLanguages().values().iterator().next() : null)")
  @Mapping(target = "latitude", expression ="java(countryApiDTO.getLatlng().size() == 2 ? countryApiDTO.getLatlng().get(0) : null)")
  @Mapping(target = "longitude", expression ="java(countryApiDTO.getLatlng().size() == 2 ? countryApiDTO.getLatlng().get(1) : null)")
  @Mapping(target = "currency", expression ="java(parseCurrencies(countryApiDTO.getCurrencies()))")
  CountryDTO toCountryDTO(CountryApiDTO countryApiDTO);

  List<CountryDTO> toCountryDTOList(List<CountryApiDTO> countryApiDTOList);

  default String parseCurrencies(Object currencies) {
    String currency = null;

    if (currencies instanceof Iterable) {
      for (Object item : (Iterable<?>) currencies) {
        if (item instanceof Map) {
          Map.Entry<?, ?> entry = ((Map<?, ?>) item).entrySet().iterator().next();
          currency = entry.getValue().toString();

        }
      }
    }
    return currency;
  }


}