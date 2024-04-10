package com.comp313.bloodlink.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comp313.bloodlink.model.BloodRequests;

@Repository
public interface BloodRequestRepository extends JpaRepository<BloodRequests, Long> {

}
