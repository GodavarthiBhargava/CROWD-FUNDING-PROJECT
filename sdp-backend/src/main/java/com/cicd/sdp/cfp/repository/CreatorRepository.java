package com.cicd.sdp.cfp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cicd.sdp.cfp.model.Creator;

@Repository
public interface CreatorRepository extends JpaRepository<Creator, Integer> {

    // Login for creators
    public Creator findByUsernameAndPassword(String username, String password);

    // Count total creators
    @Query("select count(c) from Creator c")
    public long creatorCount();
}
