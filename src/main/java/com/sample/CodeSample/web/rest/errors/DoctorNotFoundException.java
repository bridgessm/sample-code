package com.sample.CodeSample.web.rest.errors;

public class DoctorNotFoundException extends RuntimeException {

  public DoctorNotFoundException(Long id) {
    super("Could not find Doctor " + id);
  }
}