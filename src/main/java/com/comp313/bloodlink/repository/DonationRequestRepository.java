package com.comp313.bloodlink.repository;

import com.comp313.bloodlink.model.DonationRequests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationRequestRepository extends JpaRepository<DonationRequests, Long> {
}
