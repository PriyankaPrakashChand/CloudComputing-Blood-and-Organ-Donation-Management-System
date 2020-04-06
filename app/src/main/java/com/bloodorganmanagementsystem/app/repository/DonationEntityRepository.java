 package com.bloodorganmanagementsystem.app.repository;

import com.bloodorganmanagementsystem.app.entities.DonationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationEntityRepository extends CrudRepository<DonationEntity, Integer> {

    
}