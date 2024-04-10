package com.comp313.bloodlink.controller;

import com.comp313.bloodlink.model.DonationRequests;
import com.comp313.bloodlink.service.DonationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RequestMapping("donation-requests")
@RestController
public class DonationRequestsController {

    private final DonationRequestService donationRequestsService;

    @Autowired
    public DonationRequestsController(DonationRequestService donationRequestsService) {
        this.donationRequestsService = donationRequestsService;
    }

    @GetMapping
    public List<DonationRequests> getAll() {
        System.out.println("All Donation Requests Information");
        return donationRequestsService.getAll();
    }

    @GetMapping("{donationId}")
    public Optional<DonationRequests> getById(@PathVariable("donationId") final Long donationId) {
        System.out.println("Donation Request information based on the given ID");
        return donationRequestsService.getById(donationId);
    }

    @PutMapping("{donationId}")
    public DonationRequests updateById(@PathVariable("donationId") final Long donationId, @RequestBody final DonationRequests donationRequest) {
        System.out.println("Updating Donation Request Info");
        return donationRequestsService.update(donationId, donationRequest);
    }

    @PostMapping
    public DonationRequests save(@RequestBody final DonationRequests donationRequest) {
        System.out.println("Added Donation Request Info " + donationRequest);

        if (donationRequest.getDonationId() != null) {
            System.out.println("Using provided donationId: " + donationRequest.getDonationId());
        } else {
            System.out.println("No donationId provided, an ID will be auto-generated.");
        }

        return donationRequestsService.save(donationRequest);
    }

    @DeleteMapping("{donationId}")
    public void delete(@PathVariable final Long donationId) {
        System.out.println("A Donation Request Info deleted");
        donationRequestsService.delete(donationId);
    }

    // Additional methods for donation request-specific operations can be added here
}
