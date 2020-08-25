package com.sample.CodeSample.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sample.CodeSample.domain.Doctor;
import com.sample.CodeSample.domain.enumeration.State;

import com.sample.CodeSample.repository.DoctorRepository;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(DoctorRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new Doctor("Sample", "Doctor","123 Fake St",State.MA)));
      log.info("Preloading " + repository.save(new Doctor("Default", "Individual","987 Plain Lane",State.CT)));
    };
  }
}