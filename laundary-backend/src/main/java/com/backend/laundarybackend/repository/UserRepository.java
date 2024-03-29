package com.backend.laundarybackend.repository;

import com.backend.laundarybackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM User a WHERE a.userName = :userName")
    boolean existsByUserName(String userName);
    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM User a WHERE a.phoneNumber = :phoneNumber")
    boolean existsByPhoneNumber(String phoneNumber);
    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM User a WHERE a.emailAddress = :emailAddress")
    boolean existsByEmailAddress(String emailAddress);

    @Query("SELECT u FROM User u WHERE u.userName=:userName")
    Optional<User> findByUserName(String userName);
}
