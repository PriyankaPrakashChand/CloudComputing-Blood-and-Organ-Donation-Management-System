 package com.bloodorganmanagementsystem.app.repositories;

import com.bloodorganmanagementsystem.app.entities.EligibilityToDonate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EligibilityToDonateRepository extends CrudRepository<EligibilityToDonate, Integer> {

}