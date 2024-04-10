package com.comp313.bloodlink.controller;

import com.comp313.bloodlink.model.BloodRequests;
import com.comp313.bloodlink.service.BloodRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("blood-requests")
public class BloodRequestController {

    private final BloodRequestService bloodRequestService;

    @Autowired
    public BloodRequestController(BloodRequestService bloodRequestService) {
        this.bloodRequestService = bloodRequestService;
    }

    @GetMapping
    public List<BloodRequests> getAll() {
        System.out.println("All Blood Request Information");
        return bloodRequestService.getAll();
    }

    @GetMapping("{requestId}")
    public BloodRequests getById(@PathVariable("requestId") final Long requestId) {
        System.out.println("Blood Request information based on the given ID");
        return bloodRequestService.getById(requestId).orElse(null);
    }

    @PutMapping("{requestId}")
    public BloodRequests updateById(@PathVariable("requestId") final Long requestId, @RequestBody final BloodRequests bloodRequest) {
        System.out.println("Updating Blood Request Info");
        return bloodRequestService.update(requestId, bloodRequest);
    }

    @PostMapping
    public BloodRequests save(@RequestBody final BloodRequests bloodRequest) {
        System.out.println("Added Blood Request Info " + bloodRequest);

        if (bloodRequest.getRequestId() != null) {
            System.out.println("Using provided requestId: " + bloodRequest.getRequestId());
        } else {
            System.out.println("No requestId provided, an ID will be auto-generated.");
        }

        return bloodRequestService.save(bloodRequest);
    }

    @DeleteMapping("{requestId}")
    public void delete(@PathVariable final Long requestId) {
        System.out.println("A Blood Request Info deleted");
        bloodRequestService.delete(requestId);
    }

    // Additional methods for blood request-specific operations can be added here
}
