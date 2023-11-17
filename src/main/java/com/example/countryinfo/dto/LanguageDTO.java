package com.example.countryinfo.dto;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Getter
@Setter
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class LanguageDTO {
  Map<String, String> languages;

}
