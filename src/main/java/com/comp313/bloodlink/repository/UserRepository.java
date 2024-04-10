package com.comp313.bloodlink.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.comp313.bloodlink.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	User findByEmail(String email);
}
