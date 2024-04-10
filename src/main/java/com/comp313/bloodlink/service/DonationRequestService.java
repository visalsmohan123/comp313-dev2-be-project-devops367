package com.comp313.bloodlink.service;

import com.comp313.bloodlink.model.DonationRequests;
import com.comp313.bloodlink.repository.DonationRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DonationRequestService {

    private final DonationRequestRepository donationRequestsRepository;

    @Autowired
    public DonationRequestService(DonationRequestRepository donationRequestsRepository) {
        this.donationRequestsRepository = donationRequestsRepository;
    }

    public List<DonationRequests> getAll() {
        return donationRequestsRepository.findAll();
    }

    public Optional<DonationRequests> getById(Long donationId) {
        return donationRequestsRepository.findById(donationId);
    }

    public DonationRequests save(DonationRequests donationRequest) {
        // You can implement custom logic before saving if needed
        return donationRequestsRepository.save(donationRequest);
    }

    public DonationRequests update(Long donationId, DonationRequests donationRequest) {
        // Check if the donation request exists before updating
        Optional<DonationRequests> optionalExistingRequest = donationRequestsRepository.findById(donationId);
        if (optionalExistingRequest.isPresent()) {
            DonationRequests existingRequest = optionalExistingRequest.get();
            // Update the existing donation request with the new data
            existingRequest.setDonorUserId(donationRequest.getDonorUserId());
            existingRequest.setRecipientUserId(donationRequest.getRecipientUserId());
            existingRequest.setDonationDate(donationRequest.getDonationDate());
            existingRequest.setNotes(donationRequest.getNotes());
            return donationRequestsRepository.save(existingRequest);
        } else {
            // Handle case where donation request with given donationId doesn't exist
            return null;
        }
    }

    public void delete(Long donationId) {
        donationRequestsRepository.deleteById(donationId);
    }

    // Additional methods for donation request-specific operations can be added here
}
