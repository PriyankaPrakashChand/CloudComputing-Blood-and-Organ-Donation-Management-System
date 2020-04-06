package com.bloodorganmanagementsystem.app.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import com.bloodorganmanagementsystem.app.dto.Donation;
import com.bloodorganmanagementsystem.app.dto.IndividualDetails;
import com.bloodorganmanagementsystem.app.dto.Profile;
import com.bloodorganmanagementsystem.app.entities.Blood;
import com.bloodorganmanagementsystem.app.entities.BloodType;
import com.bloodorganmanagementsystem.app.entities.CompletedDonationLog;
import com.bloodorganmanagementsystem.app.entities.DonationEntity;
import com.bloodorganmanagementsystem.app.entities.HealthOrganization;
import com.bloodorganmanagementsystem.app.entities.Individual;
import com.bloodorganmanagementsystem.app.entities.Member;
import com.bloodorganmanagementsystem.app.entities.Test;
import com.bloodorganmanagementsystem.app.repository.BloodRepository;
import com.bloodorganmanagementsystem.app.repository.BloodTypeRepository;
import com.bloodorganmanagementsystem.app.repository.DonationEntityRepository;
import com.bloodorganmanagementsystem.app.repository.HealthOrganizationRepository;
import com.bloodorganmanagementsystem.app.repository.IndividualRepository;
import com.bloodorganmanagementsystem.app.repository.MemberRepository;
import com.bloodorganmanagementsystem.app.repository.TestRepository;
import com.sun.tools.doclint.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndividualServiceImplementation implements IndividualService {

    IndividualRepository individualRepository;
    DonationEntityRepository donationEntityRepository;
    TestRepository testRepository;
    BloodRepository bloodRepository;
    MemberRepository memberRepository;
    HealthOrganizationRepository healthOrganizationRepository;
    BloodTypeRepository bloodTypeRepository;

    /**
     * Public Constructor
     * 
     * @param individualRepository
     * @param donationEntityRepository
     * @param destRepository
     */
    @Autowired
    public IndividualServiceImplementation(IndividualRepository individualRepository,
            DonationEntityRepository donationEntityRepository, TestRepository testRepository,
            BloodRepository bloodRepository, MemberRepository memberRepository,
            HealthOrganizationRepository healthOrganizationRepository, BloodTypeRepository bloodTypeRepository) {
        this.individualRepository = individualRepository;
        this.donationEntityRepository = donationEntityRepository;
        this.testRepository = testRepository;
        this.bloodRepository = bloodRepository;
        this.memberRepository = memberRepository;
        this.healthOrganizationRepository = healthOrganizationRepository;
        this.bloodTypeRepository = bloodTypeRepository;

    }

    public Optional<Individual> findById(final String findId) {
        return individualRepository.findById(findId);
    }

    @Override
    public boolean addTest(String individualId,Integer testId, Integer testValue, String licenseKey) throws AppException{
  
    // // check if the individual exists
    // final Optional<Individual> dbIndividual =
    // individualRepository.findById(individualId);
    // if (dbIndividual.isEmpty()) {
    // throw new AppException("Individual does not exist");
    // }
    // // check if licence key matches
    // Individual individual = dbIndividual.get();
    // if (!licenseKey.equals(individual.getAppliedLicenseKey())){
    // throw new AppException("Invalid licence Key");
    // }

    // List<Test> testTable=individual.getMember().getTests();

    return false;
    }

    @Override
    public boolean Register(final IndividualDetails details) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean ModifyProfile(final String individualId, final Profile profile, String licenseKey)
            throws AppException {
        // 1 check if the individual exists
        final Optional<Individual> dbIndividual = individualRepository.findById(individualId);
        if (dbIndividual.isEmpty()) {
            throw new AppException("Individual does not exist");
        }
        Individual individual = dbIndividual.get();

        // 2check if licency key belongs to individual
        if (!licenseKey.equals(individual.getAppliedLicenseKey())) {
            throw new AppException("Invalid licence Key");
        }

        // 3validate height
        Integer minimumHeight = 0;
        if (profile.getHeight() < minimumHeight) {
            throw new AppException("Invalid Height");
        }

        // 4-validate weight
        Integer minimumWeight = 0;
        if (profile.getWeight() < minimumWeight) {
            throw new AppException("Invalid Weight");
        }
        // 5- check if blood units is valid
        Integer minimumBloodUnits = 0;
        if (profile.getBloodUnits() < minimumBloodUnits) {
            throw new AppException("Invalid BloodUnits");
        }

        // dont check for get gender and bloodType because will have buttons to select
        // in front end from

        // 6-validate date if birth
        // Integer maxAge=65;
        // Integer minAge=18;
        // Date currentDate= new Date();
        // if(currentDate-profile.getDateOfBirth()< minAge) //should be between 18-65
        // years

        // 7-------now set
        individual.setGender(profile.getGender());
        individual.setHeightCm(profile.getHeight());
        individual.setWeightKg(profile.getWeight());
        individual.setBirthday(profile.getDateOfBirth());
        individual.getMember().getBloods().clear(); // this is because an individual can only have one blood type

        // 8-calculate units that the individual can donate
        Blood blood = new Blood(); // autogenerated id
        BloodType bloodType = bloodTypeRepository.findById(profile.getBloodType()).get();
        blood.setBloodType(bloodType);// find from repository
        blood.setBloodUnits(new BigDecimal(profile.getBloodUnits()));
        // 9-add them to each other
        blood.setMember(individual.getMember());
        individual.getMember().addBlood(blood);

        // 10- save blood and individual back to repository

        individual = individualRepository.save(individual);
        blood = bloodRepository.save(blood);

        return true;
    }

    @Override
    public boolean Donate(final long donationEntityTypeId, final String
    individualId, final String licenceKey)
    throws AppException {
    // // check if the individual exists
    // final Optional<Individual> dbIndividual =
    // individualRepository.findById(individualId);
    // if (dbIndividual.isEmpty()) {
    // throw new AppException("Individual does not exist");
    // }
    // Individual individual = dbIndividual.get();
    // // check if license key is valid
    // List<HealthOrganization> dbHealthOrganizations =
    // healthOrganizationRepository.findByLisenceKey(licenceKey);
    // if (dbHealthOrganizations.isEmpty()) {
    // throw new AppException("Invalid Licence Key");
    // }
    // Integer maximumValue = 1;
    // Enum availableState;
    // // check if donation enity exists and matches the individualid and is in
    // // inactive state
    // List<DonationEntity> donationEnitities =
    // individual.getMember().getDonationEntities();
    // DonationEntity donationEntity;
    // // check if entity exists
    // for (DonationEntity entity : donationEnitities) {
    // if (entity.getEntityType().getEntityTypeId() == donationEntityTypeId) {
    // donationEntity = entity;
    // break;
    // }
    // }
    // if (donationEntity == null) {
    // throw new AppException(
    // individual.getFirstName() + " " + individual.getLastName() + "is not
    // interested in donation");
    // }
    // // check if the entity is available for donation
    // if (donationEntity.getStateId().intValue() != availableState.ordinal()) {

    // throw new AppException(
    // donationEntity.getEntityType().getEntityTypeName() + " is not available for
    // donation");

    // }

    // // check if the donor is eligible to donate it

    // // update donation log and entity status and save entity to repository.

    // }
return false;
    }

    static boolean isEligible(Individual individual, DonationEntity donationEntity) {
        return true;

    }

    /**
     * @param individualId
     * @return List<Donation>
     * @throws AppException
     */

    @Override
    public List<Donation> viewDonations(final String individualId) throws AppException {

        // check if the individual exists
        final Optional<Individual> dbIndividual = individualRepository.findById(individualId);
        if (dbIndividual.isEmpty()) {
            throw new AppException("Individual does not exist");
        }
        Individual individual = dbIndividual.get();

        List<Donation> donations = new ArrayList<Donation>();
        Donation donation = new Donation();
        List<CompletedDonationLog> logs = individual.getMember().getCompletedDonationLogs();

        for (CompletedDonationLog log : logs) {
            // set donation entity name
            donation.setEntityName(log.getDonationEntity().getEntityType().getEntityTypeName());

            // set recepient name
            donation.setRecipientName(log.getMember().getIndividual().getFirstName() + " "
                    + log.getMember().getIndividual().getLastName());

            // set date of donation
            donation.setDateOfDonation(log.getDonationDate());

            // append to list that needs to be returned
            donations.add(donation);

        }

        return donations;

        // TODO Auto-generated method stub

    }

    /**
     * @param individualId
     * @return Profile
     * @throws AppException
     */
    @Override
    public Profile viewProfile(final String individualId) throws AppException {
        final Optional<Individual> dbIndividual = individualRepository.findById(individualId);
        if (dbIndividual.isEmpty()) {
            throw new AppException("Individual does not exist");
        }
        Individual individual = dbIndividual.get();
        Profile profile = new Profile();
        profile.setDateOfBirth(individual.getBirthday());
        profile.setGender(individual.getGender());
        profile.setHeight(individual.getHeightCm());
        profile.setWeight(individual.getWeightKg());
        Blood blood = bloodRepository.findByMember(individual.getMember()).get();
        profile.setBloodType((int)blood.getBloodType().getBloodTypeId());
        return profile;
    }

}