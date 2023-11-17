package com.example.countryinfo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder(toBuilder = true)
public class CountryDTO {
  String name;
  String language;
  String capital;
  String currency;
  double latitude;
  double longitude;
  int population;
}
