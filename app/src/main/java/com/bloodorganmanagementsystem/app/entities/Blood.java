package com.bloodorganmanagementsystem.app.entities;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

enum BloodType {
	A_POSITIVE, A_NEGATIVE, B_NEGATIVE, B_POSITIVE, O_POSITIVE, O_NEGATIVE, AB_POSITIVE, AB_NEGATIVE
}

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Blood {

	private BloodType bloodType; // what is the bloodtype
	private BigDecimal bloodUnitsDonated; // how much has already been donated
	private BigDecimal bloodUnitsAvailable; // howmuch they can still donate
	


}