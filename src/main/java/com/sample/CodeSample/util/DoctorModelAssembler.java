package com.sample.CodeSample.util;

import com.sample.CodeSample.domain.Doctor;
import com.sample.CodeSample.web.rest.DoctorController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class DoctorModelAssembler implements RepresentationModelAssembler<Doctor, EntityModel<Doctor>> {

	@Override
	public EntityModel<Doctor> toModel(Doctor doctor) {
		return EntityModel.of(doctor,
			linkTo(methodOn(DoctorController.class).findDoctor(doctor.getId())).withSelfRel(),
			linkTo(methodOn(DoctorController.class).getAllDoctors()).withRel("doctors"));
	}
}