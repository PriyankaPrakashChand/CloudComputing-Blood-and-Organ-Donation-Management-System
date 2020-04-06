package com.bloodorganmanagementsystem.app.repository;

import java.util.Optional;

import com.bloodorganmanagementsystem.app.entities.Blood;
import com.bloodorganmanagementsystem.app.entities.Member;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface BloodRepository extends CrudRepository<Blood, Integer> {

    public Optional<Blood> findByMember(Member member);
   
                        
}


