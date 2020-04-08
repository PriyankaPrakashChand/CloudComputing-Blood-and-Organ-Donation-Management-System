package com.bloodorganmanagementsystem.app.individualservices;


import com.bloodorganmanagementsystem.app.dto.Profile;
import com.bloodorganmanagementsystem.app.entities.Individual;
import com.bloodorganmanagementsystem.app.service.IndividualService;
import com.bloodorganmanagementsystem.app.service.IndividualServiceImplementation;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ViewMyProfileTest {
    @Autowired
    IndividualServiceImplementation indSer;
    Profile profile=null;
    @Test
     public void successTest(){
        try {
            profile = indSer.viewProfile("I0001");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assert(profile!=null);
    }

    @Test
    public void IndividualDoesNotExistTest(){
        try {
            profile = indSer.viewProfile("0001");
            
        } catch (Exception e) {
           assert(e.getMessage().equals("Individual does not exist"));
        }
        
    }
}