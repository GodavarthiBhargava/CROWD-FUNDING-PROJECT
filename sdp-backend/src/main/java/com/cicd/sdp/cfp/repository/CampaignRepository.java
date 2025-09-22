package com.cicd.sdp.cfp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cicd.sdp.cfp.model.Campaign;
import com.cicd.sdp.cfp.model.Creator;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Integer> {

    // Find campaigns by creator
    public List<Campaign> findByCreator(Creator creator);

    // Count total campaigns
    @Query("select count(c) from Campaign c")
    public long campaignCount();
}
