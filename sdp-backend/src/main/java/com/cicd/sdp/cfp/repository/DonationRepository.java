package com.cicd.sdp.cfp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.cicd.sdp.cfp.model.Donation;
import com.cicd.sdp.cfp.model.Contributor;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Integer> {

    // Get donations made by a specific contributor
    public List<Donation> findByContributor(Contributor contributor);

    // Get all donations for a specific creator's campaigns
    @Query("SELECT d FROM Donation d WHERE d.campaign.creator.id = ?1")
    public List<Donation> getDonationsByCreator(int creatorId);

    // Update the donation amount (optional, for future)
    @Modifying
    @Transactional
    @Query("UPDATE Donation d SET d.amount = ?1 WHERE d.id = ?2")
    public int updateDonationAmount(double amount, int id);
}
