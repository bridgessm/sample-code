package com.sample.CodeSample.web.rest;

import com.sample.CodeSample.util.DoctorModelAssembler;
import com.sample.CodeSample.domain.Doctor;
import com.sample.CodeSample.repository.DoctorRepository;
import com.sample.CodeSample.web.rest.errors.DoctorNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;
import org.springframework.hateoas.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

/**
 * REST controller for managing Doctor.
 */
@RestController
public class DoctorController {

    private final DoctorRepository doctorRepository;
	
    private final DoctorModelAssembler doctorAssembler;

    public DoctorController(DoctorRepository doctorRepository,
							DoctorModelAssembler doctorAssembler) {
        this.doctorRepository = doctorRepository;
        this.doctorAssembler = doctorAssembler;
    }

    @GetMapping("/doctors")
    public CollectionModel<EntityModel<Doctor>> getAllDoctors() {
		List<EntityModel<Doctor>> doctors = doctorRepository.findAll().stream()
			.map(doctorAssembler::toModel)
			.collect(Collectors.toList());

		return CollectionModel.of(doctors, linkTo(methodOn(DoctorController.class).getAllDoctors()).withSelfRel());
    }

    @PostMapping("/doctors")
    public Doctor createDoctor(@RequestBody Doctor newDoctor) {
		return doctorRepository.save(newDoctor);
    }

    @GetMapping("/doctors/{id}")
    public EntityModel<Doctor> findDoctor(@PathVariable Long id) {
		Doctor doctor = doctorRepository.findById(id)
			.orElseThrow(() -> new DoctorNotFoundException(id));
		return doctorAssembler.toModel(doctor);
    }

    @PutMapping("/doctors/{id}")
    public EntityModel<Doctor> updateDoctor(@RequestBody Doctor newDoctor, @PathVariable Long id) {
		return doctorRepository.findById(id)
			.map(doctor -> {
				doctor.firstName(newDoctor.getFirstName())
					  .lastName(newDoctor.getLastName())
					  .address(newDoctor.getAddress())
					  .state(newDoctor.getState());
				Doctor updatedDoctor = doctorRepository.save(doctor);
				return doctorAssembler.toModel(updatedDoctor);
			})
			.orElseGet(() -> {
				newDoctor.setId(id);
				Doctor updatedDoctor = doctorRepository.save(newDoctor);
				return doctorAssembler.toModel(updatedDoctor);
			});
    }

    @DeleteMapping("/doctors/{id}")
    public String deleteDoctor(@PathVariable Long id) {
		doctorRepository.deleteById(id);
		return "Doctor " + id + " succesfully removed.";
    }
}
