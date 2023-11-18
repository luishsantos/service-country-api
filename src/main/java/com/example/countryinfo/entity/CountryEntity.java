package com.example.countryinfo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "country")
public class CountryEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  Long id;
  String name;
  String capital;
  String officialLanguage;
  String currency;
  int population;
  double latitude;
  double longitude;

}

