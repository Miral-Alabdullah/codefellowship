package com.example.codefellowship.Repository;

import com.example.codefellowship.Model.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser,Integer> {
    public ApplicationUser findByUsername (String username);
}