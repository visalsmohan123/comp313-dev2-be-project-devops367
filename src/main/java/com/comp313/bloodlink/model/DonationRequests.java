package com.comp313.bloodlink.model;

import java.time.LocalDateTime;
import org.apache.commons.lang3.RandomStringUtils;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="donation_requests")
public class DonationRequests {

    @Id
    private String donationId;

    private String donorUserId;
    private String recipientUserId;
    private LocalDateTime donationDate;
    private String notes;

    // Constructors
    public DonationRequests() {
        this.donationId = generateDonationId();
    }

    public DonationRequests(String donorUserId, String recipientUserId, LocalDateTime donationDate, String notes) {
        this();
        this.donorUserId = donorUserId;
        this.recipientUserId = recipientUserId;
        this.donationDate = donationDate;
        this.notes = notes;
    }

    private String generateDonationId() {
        // Generate a random 6-digit alphanumeric string
        return RandomStringUtils.randomNumeric(6);
    }

    // Getters and Setters

    public String getDonationId() {
        return donationId;
    }

    public void setDonationId(String donationId) {
        this.donationId = donationId;
    }

    public String getDonorUserId() {
        return donorUserId;
    }

    public void setDonorUserId(String donorUserId) {
        this.donorUserId = donorUserId;
    }

    public String getRecipientUserId() {
        return recipientUserId;
    }

    public void setRecipientUserId(String recipientUserId) {
        this.recipientUserId = recipientUserId;
    }

    public LocalDateTime getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(LocalDateTime donationDate) {
        this.donationDate = donationDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    // toString method for printing
    @Override
    public String toString() {
        return "DonationRequests{" +
                "donationId='" + donationId + '\'' +
                ", donorUserId='" + donorUserId + '\'' +
                ", recipientUserId='" + recipientUserId + '\'' +
                ", donationDate=" + donationDate +
                ", notes='" + notes + '\'' +
                '}';
    }
}
