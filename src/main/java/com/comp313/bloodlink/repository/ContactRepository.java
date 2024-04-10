package com.comp313.bloodlink.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comp313.bloodlink.model.ContactModel;

public interface ContactRepository extends JpaRepository<ContactModel, Long>{

}
