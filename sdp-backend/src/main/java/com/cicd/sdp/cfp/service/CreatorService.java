package com.cicd.sdp.cfp.service;

import java.util.List;

import com.cicd.sdp.cfp.model.Creator;
import com.cicd.sdp.cfp.model.Campaign;
import com.cicd.sdp.cfp.model.Donation;

public interface CreatorService {

    public Creator checkCreatorLogin(String username, String password);

    public String addCampaign(Campaign campaign);

    public List<Campaign> viewCampaignsByCreator(int creatorId);

    public List<Donation> viewDonationsByCreator(int creatorId);
}
