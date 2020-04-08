// package com.bloodorganmanagementsystem.app.individualservices;

// import java.util.Date;

// import com.bloodorganmanagementsystem.app.dto.Profile;
// import com.bloodorganmanagementsystem.app.service.IndividualService;
// import com.bloodorganmanagementsystem.app.service.IndividualServiceImplementation;

// import org.hibernate.type.TrueFalseType;
// import org.junit.Before;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.test.context.junit4.SpringRunner;

// @RunWith(SpringRunner.class)
// @SpringBootTest
// public class AddProfileTest {
//     @Autowired
//     IndividualServiceImplementation indSer;
//     Profile profile = null;

//     @Test
//     public void successTest() {
//         try {
//             profile.setBloodType(1);
//             profile.setBloodUnits(13);
//             profile.setDateOfBirth(new Date());
//             profile.setGender('F');
//             profile.setHeight(172);
//             profile.setWeight(60);

//             assert (indSer.AddProfile("I0001", profile, "AHA2020") == true);
//         } catch (Exception e) {
//             System.out.println(e.getMessage());
//         }

//     }
// }