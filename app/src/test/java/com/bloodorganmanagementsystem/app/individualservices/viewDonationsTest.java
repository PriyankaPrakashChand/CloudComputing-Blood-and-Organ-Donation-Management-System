// package com.bloodorganmanagementsystem.app.individualservices;

// import java.util.List;

// import com.bloodorganmanagementsystem.app.dto.Donation;
// import com.bloodorganmanagementsystem.app.service.IndividualServiceImplementation;

// import org.junit.Before;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.test.context.junit4.SpringRunner;

// @RunWith(SpringRunner.class)
// @SpringBootTest
// public class viewDonationsTest {

//     @Autowired
//     IndividualServiceImplementation indSer;
//     List<Donation> donations=null;
//     @Test
//      public void successTest(){
//         try {
//             donations = indSer.viewDonations("I0001");
//         } catch (Exception e) {
//             System.out.println(e.getMessage());
//         }
//         assert(donations!=null);
//     }


// }