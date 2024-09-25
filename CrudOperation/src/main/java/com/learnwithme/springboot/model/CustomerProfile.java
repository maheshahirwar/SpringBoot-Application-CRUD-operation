package com.learnwithme.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "CUSTOMER_PROFILE")
public class CustomerProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CUST_ID")
	private Long custId;
	
	@Column(name = "FRST_NM")
	private String firstName;
	
	@Column(name = "LST_NM")
	private String lastName;
	
	@Column(name = "EML_ID")
	private String emailId;
	
	@Column(name = "CNTCT_NO")
	private Long contactNo;
	
	@Lob
	@Column(name = "PFL_IMG")
	private byte[] profileImage;
	
	@Column(name = "CUST_PASS")
	private String customerPassword;
	
	@Column(name = "ADDR")
	private String address;
}
