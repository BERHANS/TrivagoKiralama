package com.berhan.repository;

import com.berhan.repository.entity.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserProfileRepository extends MongoRepository<UserProfile,String> {

    Optional<UserProfile> findOptionalByAuthId(Long authId);
}
