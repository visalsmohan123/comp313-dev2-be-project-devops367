package com.comp313.bloodlink.model;

import java.time.LocalDateTime;

import org.apache.commons.lang3.RandomStringUtils;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;	

@Entity
@Table(name = "blood_requests")
public class BloodRequests {

    @Id
    private String requestId;
    private String userId; // ID of the recipient
    private String bloodType;
    private UrgencyLevel urgencyLevel;
    private String location;
    private RequestStatus status;
    private LocalDateTime requestDate; // Added to track when the request was made

    // Constructors
    public BloodRequests() {
        this.requestId = generateRequestId();
    }

    public BloodRequests(String userId, String bloodType, UrgencyLevel urgencyLevel,
                         String location, RequestStatus status, LocalDateTime requestDate) {
        this();
        this.userId = userId;
        this.bloodType = bloodType;
        this.urgencyLevel = urgencyLevel;
        this.location = location;
        this.status = status;
        this.requestDate = requestDate;
    }

    private String generateRequestId() {
        // Generate a random 6-digit alphanumeric string
        return RandomStringUtils.randomNumeric(6);
    }

    // Getters and Setters

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public UrgencyLevel getUrgencyLevel() {
        return urgencyLevel;
    }

    public void setUrgencyLevel(UrgencyLevel urgencyLevel) {
        this.urgencyLevel = urgencyLevel;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public LocalDateTime getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDateTime requestDate) {
        this.requestDate = requestDate;
    }

    // Enum for Urgency Level
    public enum UrgencyLevel {
        LOW, MEDIUM, HIGH, CRITICAL
    }

    // Enum for Request Status
    public enum RequestStatus {
        OPEN, CLOSED, FULFILLED, CANCELLED
    }

    // toString method for printing
    @Override
    public String toString() {
        return "BloodRequest{" +
                "requestId='" + requestId + '\'' +
                ", userId='" + userId + '\'' +
                ", bloodType='" + bloodType + '\'' +
                ", urgencyLevel=" + urgencyLevel +
                ", location='" + location + '\'' +
                ", status=" + status +
                ", requestDate=" + requestDate +
                '}';
    }
}
