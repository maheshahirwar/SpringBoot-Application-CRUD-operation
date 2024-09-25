package com.learnwithme.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learnwithme.springboot.model.CustomerProfile;

@Service
public interface CustomerProfileService {

	public String addCustomerProfile(CustomerProfile customerProfile);
	
	public String updateCustomerProfile(Long customerId, CustomerProfile customerProfile);
	
	public List<CustomerProfile> getAllCustomerProfiles();
	
	public CustomerProfile getCustomerProfile(Long customerId);
	
	public String deleteCustomerProfile(Long customerId);
}
