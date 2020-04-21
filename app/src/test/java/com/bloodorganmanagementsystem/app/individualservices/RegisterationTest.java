package com.bloodorganmanagementsystem.app.individualservices;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.bloodorganmanagementsystem.app.dto.IndividualProfileToGet;
import com.bloodorganmanagementsystem.app.entities.Blood;
import com.bloodorganmanagementsystem.app.entities.DonationEntityDetails;
import com.bloodorganmanagementsystem.app.entities.Individual;
import com.bloodorganmanagementsystem.app.entities.MemberDetail;
import com.bloodorganmanagementsystem.app.entities.Blood.BloodType;
import com.bloodorganmanagementsystem.app.entities.DonationEntityDetails.EntityName;
import com.bloodorganmanagementsystem.app.entities.DonationEntityDetails.ReceiverType;
import com.bloodorganmanagementsystem.app.entities.DonationEntityDetails.dState;
import com.bloodorganmanagementsystem.app.entities.Individual.DonationPreference;
import com.bloodorganmanagementsystem.app.entities.Individual.Gender;
import com.bloodorganmanagementsystem.app.repository.IndividualRepository;
import com.bloodorganmanagementsystem.app.service.AppException;
import com.bloodorganmanagementsystem.app.service.IndividualServiceImplementation;
import com.bloodorganmanagementsystem.app.entities.Tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegisterationTest {
    @Autowired
    IndividualServiceImplementation indSer;
    @Autowired
    IndividualRepository repos;
    Individual ind;
    IndividualProfileToGet profile;

    @Before
    public void init() {
        
        ind = new Individual();
        MemberDetail memberDetail = new MemberDetail();
        memberDetail.setAddress("address");
        memberDetail.setCity("city");
        memberDetail.setCountry("country");
        memberDetail.setPassword("password");
        ind.setMemeberDetails(memberDetail);
        memberDetail.setPhoneNumber("phoneNumber");
        Blood blood = new Blood();
        blood.setBloodType(BloodType.AB_NEGATIVE);
        ind.setFirstName("IndivisualFirstName");
        ind.setLastName("IndivisualLastName");
        ind.setAppliedLicenseKey("Org1LicenceKey");
        ind.setBirthday(new Date());
        ind.setBloodDetails(blood);
        ind.setHeightCm(134);
        ind.setWeightKg(72);
        ind.setEmail("HarryPotter@email.com");
        ind.setId("I001");
       
    	
    }
    
    @Test
    public void successTest() {
     
        try {   
            Optional<Individual> dbIndividual = repos.findById("I001");
        if (dbIndividual.isPresent()) {
            repos.delete(dbIndividual.get());
        }
            
            assert (indSer.Register(ind) == true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    //@Test
    public void loginSuccessTest() throws AppException {

try{
    Boolean result=indSer.Login(ind.getEmail(), ind.getMemeberDetails().getPassword());
        assert (result == true);
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    }
    
    @Test
    public void AddProfileTest() throws AppException{
    	//try {
    		profile = new IndividualProfileToGet();

    		List<DonationPreference> listOfDonationPref = new ArrayList<DonationPreference>();
    		Blood newBlood = new Blood();
    		
    		listOfDonationPref.add(DonationPreference.BLOOD);
    		listOfDonationPref.add(DonationPreference.KIDNEY);
    		newBlood.setBloodType(BloodType.A_POSITIVE);
    		newBlood.setBloodUnitsAvailable(25);
    		newBlood.setBloodUnitsDonated(30);
    		
    		profile.setBlood(newBlood);
    		profile.setDonationPreferences(listOfDonationPref);
    		profile.setGender(Gender.MALE);
    		profile.setHeight(170);
    		profile.setWeight(65);
    		
    		Boolean result=indSer.AddProfile(ind.getId(), profile,ind.getAppliedLicenseKey());
            assert (result == true);
   // 	}
//    	catch(Exception e) {
//    	System.out.println(e.getMessage());
//    	}
    }

}