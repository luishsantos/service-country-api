package com.example.countryinfo.dto;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder(toBuilder = true)
public class CountryApiDTO {

  String name;
  @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
  Object currencies;
  List<String> capital;
  Map<String, String> languages;
  List<Double> latlng;
  int population;
}


