package com.bloodorganmanagementsystem.app.repository;

import java.util.List;


import com.bloodorganmanagementsystem.app.entities.HealthOrganization;
import com.microsoft.azure.spring.data.cosmosdb.repository.CosmosRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface HealthOrganizationRepository extends CosmosRepository<HealthOrganization, String> {

    public List<HealthOrganization> findByLisenceKey(String lisenceKey); 
   
}