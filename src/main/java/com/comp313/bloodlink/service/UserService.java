package com.comp313.bloodlink.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comp313.bloodlink.model.User;
import com.comp313.bloodlink.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> getById(final String userId) { // Changed to String to match User entity
        return userRepository.findById(userId);
    }

    public User update(final String userId, final User user) { // Changed to String to match User entity
        Optional<User> optionalDbUser = userRepository.findById(userId);
        if (optionalDbUser.isPresent()) {
            User dbUser = optionalDbUser.get();
            dbUser.setName(user.getName());
            dbUser.setBloodType(user.getBloodType());
            dbUser.setAvailable(user.isAvailable());
            dbUser.setDob(user.getDob());
            dbUser.setPhone(user.getPhone());
            dbUser.setCity(user.getCity());
            dbUser.setState(user.getState());
            dbUser.setZip(user.getZip());
            dbUser.setBloodType(user.getBloodType());
            dbUser.setCountry(user.getCountry());
            dbUser.setWeight(user.getWeight());
            dbUser.setHeight(user.getHeight());
            dbUser.setMedicalConditions(user.getMedicalConditions());
            dbUser.setLastDonation(user.getLastDonation());
            
            return userRepository.save(dbUser);
        } else {
            // Handle case where user with given userId doesn't exist
            return null;
        }
    }

    public User save(final User user) {
        // Simply saves the user as provided, without password encoding
        return userRepository.save(user);
    }
    
    public User authenticate(String email, String password) {
        // Implement authentication logic here
        // For example, check if the email and password match a user in the database
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            // Authentication successful
            return user;
        } else {
            // Authentication failed
            return null;
        }
    }

    public void delete(final String userId) {
        userRepository.deleteById(userId); // Now correctly using String as the ID type
    }

}
