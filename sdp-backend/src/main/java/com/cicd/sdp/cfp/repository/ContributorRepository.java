package com.cicd.sdp.cfp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.cicd.sdp.cfp.model.Contributor;

@Repository
public interface ContributorRepository extends JpaRepository<Contributor, Integer> {

    // Login for contributors
    public Contributor findByUsernameAndPassword(String username, String password);

    // Find contributors by gender
    @Query("select c from Contributor c where c.gender = ?1")
    public List<Contributor> findContributorsByGender(String gender);

    // Delete contributors by location
    @Modifying
    @Transactional
    @Query("delete from Contributor c where c.location = ?1")
    public int deleteContributorsByLocation(String location);

    // Count total contributors
    @Query("select count(c) from Contributor c")
    public long contributorCount();
}
