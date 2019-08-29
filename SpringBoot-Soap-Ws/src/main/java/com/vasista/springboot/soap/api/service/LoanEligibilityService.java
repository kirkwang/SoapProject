package com.vasista.springboot.soap.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vasista.springboot.soap.api.loaneligibility.Acknowledgement;
import com.vasista.springboot.soap.api.loaneligibility.CustomerRequest;

@Service
public class LoanEligibilityService {
	
	public Acknowledgement checkLoanEgilibilty(CustomerRequest request) {
		Acknowledgement acknowledgement = new Acknowledgement();
		List<String> mismatchCriteria = acknowledgement.getCriteriaMismatch();
		
		if(!(request.getAge()>30 &&request.getAge()<= 60)) {
			mismatchCriteria.add("Person age should in between 30 to 60");
		}
		if (!(request.getCibilScore() > 500)) {
			mismatchCriteria.add("Low CIBIL Score please try after 6 month");
		}

		if (mismatchCriteria.size() > 0) {
			acknowledgement.setApprovedAmount(0);
			acknowledgement.setIsEligible(false);
		} else {
			acknowledgement.setApprovedAmount(500000);
			acknowledgement.setIsEligible(true);
			mismatchCriteria.clear();
		}
		return acknowledgement;
	}

}
