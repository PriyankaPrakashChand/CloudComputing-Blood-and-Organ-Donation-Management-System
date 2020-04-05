 package com.bloodorganmanagementsystem.app.repositories;

import com.bloodorganmanagementsystem.app.entities.Test;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends CrudRepository<Test, Integer> {

}