package com.bloodorganmanagementsystem.app.repository;

import java.util.List;
import java.util.Optional;

import com.bloodorganmanagementsystem.app.entities.HealthOrganization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthOrganizationRepository extends CrudRepository<HealthOrganization, String> {

    public List<HealthOrganization> findByLisenceKey(String lisenceKey); 
   
}