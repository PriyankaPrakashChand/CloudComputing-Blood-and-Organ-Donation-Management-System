package com.bloodorganmanagementsystem.app.repository;


import com.bloodorganmanagementsystem.app.entities.BloodType;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface  BloodTypeRepository extends CrudRepository<BloodType, Integer>  {

}
