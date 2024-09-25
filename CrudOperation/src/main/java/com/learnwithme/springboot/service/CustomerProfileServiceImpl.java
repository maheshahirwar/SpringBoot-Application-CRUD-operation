package com.learnwithme.springboot.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnwithme.springboot.model.CustomerProfile;
import com.learnwithme.springboot.repository.CustProfileRepository;

/**
 * This class is used for implementation for CustomerProfile Service for CRUD operation.
 * @author Mahesh Ahirwar
 */
@Service
public class CustomerProfileServiceImpl implements CustomerProfileService{

	private static final Logger log = LoggerFactory.getLogger(CustomerProfileServiceImpl.class);
	
	@Autowired
	private CustProfileRepository custProfileRepository;
	
	@Override
	public String addCustomerProfile(CustomerProfile customerProfile) {
		customerProfile = custProfileRepository.save(customerProfile);
		log.info("Customer profile : {}",customerProfile);
		return "Customer Profile created successfully with customer id : "+customerProfile.getCustId();
	}

	@Override
	public String updateCustomerProfile(Long customerId, CustomerProfile customerProfile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerProfile> getAllCustomerProfiles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerProfile getCustomerProfile(Long customerId) {
		Optional<CustomerProfile> customerProfile = custProfileRepository.findById(customerId);
		return customerProfile.orElse(new CustomerProfile());
	}

	@Override
	public String deleteCustomerProfile(Long customerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
