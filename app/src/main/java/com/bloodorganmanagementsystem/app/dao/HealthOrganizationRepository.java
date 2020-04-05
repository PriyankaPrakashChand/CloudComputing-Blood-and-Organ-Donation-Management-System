package com.bloodorganmanagementsystem.app.repositories;

import com.bloodorganmanagementsystem.app.entities.HealthOrganization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthOrganizationRepository extends CrudRepository<HealthOrganization, String> {

}