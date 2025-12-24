package com.uninance.backend.servicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uninance.backend.entities.AccountEntity;
import com.uninance.backend.entities.UserEntity;
import com.uninance.backend.repositories.UserRepository;
import com.uninance.backend.services.CategoryService;
import com.uninance.backend.services.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CategoryService categoryService;

    //Register
    @Override
    public UserEntity createUser(UserEntity user) {
        UserEntity savedUser = userRepository.save(user);   

        categoryService.createDefaultSpentCategories(savedUser.getId());
        categoryService.createDefaultIncomeCategories(savedUser.getId());

        return savedUser;
    }


    @Override
    public UserEntity findUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void updateProfile(Long userId, String name, String lastName) {

        UserEntity existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (name != null) {
            existingUser.setName(name);
        }

        if (lastName != null) {
            existingUser.setLastName(lastName);
        }

        userRepository.save(existingUser);
    }


    @Override
    public void changePassword(Long userId, String newPassword) {

        UserEntity existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existingUser.setPassword(newPassword);
    }

    @Override
    public void deleteUser(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(userId);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
    }

    @Override
    public void deactivateUser(Long userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setActive(false);
        userRepository.save(user);
    }

    @Override
    public void activateUser(Long userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setActive(true);
        userRepository.save(user);
    }

    @Override
    public Double checkTotalBalance(Long userId) {
        UserEntity user = findUserById(userId);

        double total = 0.0;
        for (AccountEntity account : user.getAccounts()) {
            if (account.getBalance() != null) {
                total += account.getBalance();
            }
        }
        return total;
    }


}
