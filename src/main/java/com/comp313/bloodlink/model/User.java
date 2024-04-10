package com.comp313.bloodlink.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

import org.apache.commons.lang3.RandomStringUtils;

@Entity
@Table(name = "bloodlink_user")
public class User {
    @Id
    private String userId;
    private String name;
    private String gender;
    private Integer age;
    private String address;
    private String email;
    private String password;
    private String userType;
    private String bloodType;
    private Boolean  isAvailable;
    
    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "phone")
    private String phone;
       
    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zip")
    private String zip;

    @Column(name = "country")
    private String country;

   
    @Column(name = "weight")
    private Double weight;

    @Column(name = "height")
    private Double height;

    @Column(name = "medical_conditions")
    private String medicalConditions;

    @Column(name = "last_donation")
    private LocalDate lastDonation;

  
 // Default constructor
    public User() {
        this.userId = generateRequestId();
    }
    


	public User(String userId, String name, String gender, Integer age, String address, String email, String password,
		String userType, String bloodType, Boolean isAvailable, LocalDate dob, String phone, String city, String state,
		String zip, String country, Double weight, Double height, String medicalConditions, LocalDate lastDonation,
		Integer previousDonations) {
	super();
	this.userId = userId;
	this.name = name;
	this.gender = gender;
	this.age = age;
	this.address = address;
	this.email = email;
	this.password = password;
	this.userType = userType;
	this.bloodType = bloodType;
	this.isAvailable = isAvailable;
	this.dob = dob;
	this.phone = phone;
	this.city = city;
	this.state = state;
	this.zip = zip;
	this.country = country;
	this.weight = weight;
	this.height = height;
	this.medicalConditions = medicalConditions;
	this.lastDonation = lastDonation;
}



	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public Boolean  isAvailable() {
		return isAvailable;
	}

	public void setAvailable(Boolean  isAvailable) {
		this.isAvailable = isAvailable;
	}

	

 
    // Generates a unique 6-digit userId
    private String generateRequestId() {
        return RandomStringUtils.randomNumeric(6);
    }

    // Getters and setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public String getMedicalConditions() {
		return medicalConditions;
	}

	public void setMedicalConditions(String medicalConditions) {
		this.medicalConditions = medicalConditions;
	}

	public LocalDate getLastDonation() {
		return lastDonation;
	}

	public void setLastDonation(LocalDate lastDonation) {
		this.lastDonation = lastDonation;
	}

	

	// toString method for debugging purposes
    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", password='[PROTECTED]'" +
                ", userType='" + userType + '\'' +
                '}';
    }
}
