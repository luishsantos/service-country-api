package com.example.countryinfo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CoordinatesDTO {
  double latitude;
  double longitude;
}
