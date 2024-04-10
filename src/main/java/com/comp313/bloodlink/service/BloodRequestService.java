package com.comp313.bloodlink.service;

import com.comp313.bloodlink.model.BloodRequests;
import com.comp313.bloodlink.repository.BloodRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BloodRequestService {

    private final BloodRequestRepository bloodRequestRepository;

    @Autowired
    public BloodRequestService(BloodRequestRepository bloodRequestRepository) {
        this.bloodRequestRepository = bloodRequestRepository;
    }

    public List<BloodRequests> getAll() {
        return bloodRequestRepository.findAll();
    }

    public Optional<BloodRequests> getById(Long requestId) {
        return bloodRequestRepository.findById(requestId);
    }

    public BloodRequests save(BloodRequests bloodRequest) {
        // You can implement custom logic before saving if needed
        return bloodRequestRepository.save(bloodRequest);
    }

    public BloodRequests update(Long requestId, BloodRequests bloodRequest) {
        // Check if the blood request exists before updating
        Optional<BloodRequests> optionalExistingRequest = bloodRequestRepository.findById(requestId);
        if (optionalExistingRequest.isPresent()) {
            BloodRequests existingRequest = optionalExistingRequest.get();
            // Update the existing blood request with the new data
            existingRequest.setBloodType(bloodRequest.getBloodType());
            existingRequest.setUrgencyLevel(bloodRequest.getUrgencyLevel());
            existingRequest.setLocation(bloodRequest.getLocation());
            existingRequest.setStatus(bloodRequest.getStatus());

            return bloodRequestRepository.save(existingRequest);
        } else {
            // Handle case where blood request with given requestId doesn't exist
            return null;
        }
    }

    public void delete(Long requestId) {
        bloodRequestRepository.deleteById(requestId);
    }

    // Additional methods for blood request-specific operations can be added here
}
