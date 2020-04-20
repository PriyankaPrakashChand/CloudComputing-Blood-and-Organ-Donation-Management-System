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
import com.bloodorganmanagementsystem.app.entities.Tests.TestName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddTestTest {
    @Autowired
    IndividualServiceImplementation indSer;
    @Autowired
    IndividualRepository repos;
    Individual ind;
    @Test
    public void successTest() {

        try {
          
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
            indSer.Register(ind);
            
            Tests test = new Tests();
            test.setTestName(TestName.BLOOD);
            test.setHasPassed(true);
            
            assert(indSer.addTest(ind.getId(), test, ind.getAppliedLicenseKey())==true);
//            assert (indSer.Register(ind) == true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}