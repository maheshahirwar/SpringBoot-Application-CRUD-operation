package com.learnwithme.springboot.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.learnwithme.springboot.model.CustomerProfile;
import com.learnwithme.springboot.service.CustomerProfileService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/customerProfile")
public class CustomerProfileConstroller {

	@Autowired
	private CustomerProfileService customerProfileService;
	
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String> addCustomerProfile(@RequestParam("file") MultipartFile file, @RequestParam("firstName")String firstName, @RequestParam("lastName")String lastName,@RequestParam("email")String emailId) throws IOException{
		CustomerProfile customerProfile = new CustomerProfile();
		customerProfile.setFirstName(firstName);
		customerProfile.setLastName(lastName);
		customerProfile.setEmailId(emailId);
		customerProfile.setProfileImage(file.getBytes());
		String response = customerProfileService.addCustomerProfile(customerProfile);
		return new ResponseEntity<String>(response, HttpStatus.CREATED);
	}
	
	@Operation(summary = "Download the image or view" ,description =  "This method is used for download or view profile image of customer based on customer id ")
	@GetMapping(value = "/download/{customerId}", produces = MediaType.IMAGE_JPEG_VALUE)  
	public ResponseEntity<?> getFile(@PathVariable Long customerId) throws IOException{
		CustomerProfile customerProfile = customerProfileService.getCustomerProfile(customerId);
		
		if(customerProfile.getProfileImage()==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		byte[]image_data = customerProfile.getProfileImage();
		
		Path path = Path.of("C:\\Users\\asus\\eclipse-workspace\\default\\SpringBoot-Application-CRUD-operation\\CrudOperation\\upload\\image.jpg");
		
		Files.write(path, image_data, StandardOpenOption.CREATE);
	
		File file = new File("C:\\Users\\asus\\eclipse-workspace\\default\\SpringBoot-Application-CRUD-operation\\CrudOperation\\upload\\image.jpg");
		Resource resource = new FileSystemResource(file);
		
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(resource);
	}
}
