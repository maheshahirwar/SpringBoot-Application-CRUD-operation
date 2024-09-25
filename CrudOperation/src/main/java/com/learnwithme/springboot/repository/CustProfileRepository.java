package com.learnwithme.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learnwithme.springboot.model.CustomerProfile;

/**
 * This repository interface is used for crud operation on customer profile.
 * @author Mahesh Ahirwar
 */
@Repository
public interface CustProfileRepository extends JpaRepository<CustomerProfile, Long>{

}
