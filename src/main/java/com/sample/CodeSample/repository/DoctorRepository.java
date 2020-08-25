package com.sample.CodeSample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.CodeSample.domain.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}