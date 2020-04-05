 package com.bloodorganmanagementsystem.app.repositories;

import com.bloodorganmanagementsystem.app.entities.Individual;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividualRepository extends CrudRepository<Individual, String> {

	Optional<Individual>findById(String Id);
}