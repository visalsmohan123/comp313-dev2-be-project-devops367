package com.comp313.bloodlink.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comp313.bloodlink.model.BloodDonor;
import com.comp313.bloodlink.model.User;
import com.comp313.bloodlink.repository.BloodDonorRepository;
import com.comp313.bloodlink.repository.UserRepository;


@Service
public class BloodDonorService {

    @Autowired
    private BloodDonorRepository bloodDonorRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Transactional(readOnly = true)
    public List<BloodDonor> getBloodDonorsForUser(String userId) {
        return bloodDonorRepository.findByUserUserId(userId);
    }

//    @Transactional(readOnly = true)
//    public BloodDonor getBloodDonorForUser(String userId, Long bloodDonorId) {
//    	BloodDonor donor =  bloodDonorRepository.findByIdAndUserId(bloodDonorId, userId);
//    	if(donor != null) {
//    		return donor;
//    	}
//    	return null;
//    }

    @Transactional
    public BloodDonor addBloodDonorForUser(String userId, BloodDonor bloodDonor) throws Exception {
    	 // Retrieve the user by userId
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // Set the user for the blood donor
            bloodDonor.setUser(user);
        } else {
            throw new Exception("User not found with ID: " + userId);
        }

        // Save the blood donor
        return bloodDonorRepository.save(bloodDonor);    }

	public List<BloodDonor> getAllBloodDonors() {
		// TODO Auto-generated method stub
		return bloodDonorRepository.findAll();
	}

//    @Transactional
//    public BloodDonor updateBloodDonorForUser(String userId, Long bloodDonorId, BloodDonor bloodDonorDetails) {
//        // Implement this method similarly to the one provided in the previous response
//    }

//    @Transactional
//    public void deleteBloodDonorForUser(String userId, Long bloodDonorId) {
//        BloodDonor bloodDonor = bloodDonorRepository.findByIdAndUserId(bloodDonorId, userId)
//            .orElseThrow(() -> new NotFoundException("Blood Donor not found with ID: " + bloodDonorId));
//        bloodDonorRepository.delete(bloodDonor);
//    }
}