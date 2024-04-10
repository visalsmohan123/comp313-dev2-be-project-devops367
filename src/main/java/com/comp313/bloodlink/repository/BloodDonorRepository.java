package com.comp313.bloodlink.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comp313.bloodlink.model.BloodDonor;
@Repository
public interface BloodDonorRepository extends JpaRepository<BloodDonor, Long> {

	 	//BloodDonor findByIdAndUserId(Long id, String userId);

    List<BloodDonor> findByUserUserId(String userId);
}
