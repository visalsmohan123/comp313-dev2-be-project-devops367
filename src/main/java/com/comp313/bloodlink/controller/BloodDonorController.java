package com.comp313.bloodlink.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comp313.bloodlink.model.BloodDonor;
import com.comp313.bloodlink.service.BloodDonorService;

@RestController
@RequestMapping("/blooddonors")
public class BloodDonorController {

    @Autowired
    private BloodDonorService bloodDonorService;

    // GET method to retrieve all blood donors for a specific user
    @GetMapping
    public ResponseEntity<List<BloodDonor>> getAllBloodDonors() {
        List<BloodDonor> bloodDonors = bloodDonorService.getAllBloodDonors();
        return new ResponseEntity<>(bloodDonors, HttpStatus.OK);
    }
    
    // GET method to retrieve all blood donors for a specific user
    @GetMapping("/{userId}/blooddonors")
    public ResponseEntity<List<BloodDonor>> getBloodDonorsForUser(@PathVariable("userId") String userId) {
        List<BloodDonor> bloodDonors = bloodDonorService.getBloodDonorsForUser(userId);
        return new ResponseEntity<>(bloodDonors, HttpStatus.OK);
    }

    // GET method to retrieve a specific blood donor for a specific user
//    @GetMapping("/{userId}/{bloodDonorId}")
//    public ResponseEntity<BloodDonor> getBloodDonorForUser(@PathVariable("userId") String userId, @PathVariable("bloodDonorId") Long bloodDonorId) {
//        BloodDonor bloodDonor = bloodDonorService.getBloodDonorForUser(userId, bloodDonorId);
//        return new ResponseEntity<>(bloodDonor, HttpStatus.OK);
//    }

    // POST method to add a new blood donor for a specific user
    @PostMapping("/{userId}/blooddonors")
    public ResponseEntity<?> addBloodDonorForUser(@PathVariable("userId") String userId, @RequestBody BloodDonor bloodDonor) {
        try {
            BloodDonor newBloodDonor = bloodDonorService.addBloodDonorForUser(userId, bloodDonor);
            return ResponseEntity.status(HttpStatus.CREATED).body(newBloodDonor);
        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
            // Return a meaningful error message with appropriate HTTP status code
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add blood donor: " + e.getMessage());
        }
    }


    // PUT method to update an existing blood donor for a specific user
//    @PutMapping("/{userId}/{bloodDonorId}")
//    public ResponseEntity<BloodDonor> updateBloodDonorForUser(@PathVariable("userId") String userId, @PathVariable("bloodDonorId") Long bloodDonorId, @RequestBody BloodDonor bloodDonorDetails) {
//        BloodDonor updatedBloodDonor = bloodDonorService.updateBloodDonorForUser(userId, bloodDonorId, bloodDonorDetails);
//        return new ResponseEntity<>(updatedBloodDonor, HttpStatus.OK);
//    }

    // DELETE method to delete a blood donor for a specific user
//    @DeleteMapping("/{userId}/{bloodDonorId}")
//    public ResponseEntity<?> deleteBloodDonorForUser(@PathVariable("userId") String userId, @PathVariable("bloodDonorId") Long bloodDonorId) {
//        bloodDonorService.deleteBloodDonorForUser(userId, bloodDonorId);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
}
