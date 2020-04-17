package com.bloodorganmanagementsystem.app.individualservices;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.bloodorganmanagementsystem.app.entities.Blood;
import com.bloodorganmanagementsystem.app.entities.DonationEntityDetails;
import com.bloodorganmanagementsystem.app.entities.Individual;
import com.bloodorganmanagementsystem.app.entities.MemberDetail;
import com.bloodorganmanagementsystem.app.entities.Blood.BloodType;
import com.bloodorganmanagementsystem.app.entities.DonationEntityDetails.EntityName;
import com.bloodorganmanagementsystem.app.entities.DonationEntityDetails.ReceiverType;
import com.bloodorganmanagementsystem.app.entities.DonationEntityDetails.dState;
import com.bloodorganmanagementsystem.app.entities.Individual.DonationPreference;
import com.bloodorganmanagementsystem.app.repository.IndividualRepository;
import com.bloodorganmanagementsystem.app.service.IndividualServiceImplementation;
import com.bloodorganmanagementsystem.app.entities.Tests;

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

    @Test
    public void successTest() {

        try {
            Individual ind;
            Optional<Individual> dbIndividual = repos.findById("I001");
            if (dbIndividual.isPresent()) {
                repos.delete(dbIndividual.get());
            }
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

            ind.setId("I001");

            assert (indSer.Register(ind) == true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}

// // blood.setBloodUnitsAvailable(new BigDecimal("13.9"));
// // blood.setBloodUnitsDonated(new BigDecimal("10.8"));

// ind.setFirstName("IndivisualFirstName");
// ind.setLastName("IndivisualLastName");
// ind.setAppliedLicenseKey("Org1LicenceKey");
// ind.setBirthday(new Date());
// ind.setBloodDetails(blood);
// List<DonationPreference> dP= new ArrayList<DonationPreference>();
// dP.add(DonationPreference.BLOOD);
// ind.setDonationPreference(dP);
// ind.setGender('F');
// ind.setHeightCm(134);
// ind.setWeightKg(72);
// List<Tests>testList= new ArrayList<Tests>();
// Tests test= new Tests();
// test.setDateOFLastUpdate(new Date());
// test.setHasPassed(true);
// testList.add(test);
// ind.setTestDetails(testList)