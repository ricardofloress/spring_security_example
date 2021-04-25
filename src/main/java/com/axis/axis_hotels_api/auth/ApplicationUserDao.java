package com.axis.axis_hotels_api.auth;

import com.axis.axis_hotels_api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationUserDao extends JpaRepository<User, Long> {
    Optional<User> findUserByUsername(String username);
}

