package com.example.countryinfo.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryInfoController {

  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();


  public String getCountryInfo(@RequestParam(value = "name") String name) {
    return "hello";
  }
}
