package com.example.countryinfo.entity;

import static lombok.AccessLevel.PRIVATE;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = PRIVATE)
@Setter
@Getter
@Entity
@Table(name = "country")
public class CountryEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COUNTRY_SEQUENCE_GEN")
  @SequenceGenerator(name = "COUNTRY_SEQUENCE_GEN", sequenceName = "seq_country_id",
      allocationSize = 1, initialValue = 1)

  Long id;
  String name;
  String officialLanguage;
  int population;
  String currency;
  String capital;
  double latitude;
  double longitude;

}

