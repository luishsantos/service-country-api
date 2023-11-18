package com.example.countryinfo.repository;

import com.example.countryinfo.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<CountryEntity, Long> {
  CountryEntity findByName(String name);

}
