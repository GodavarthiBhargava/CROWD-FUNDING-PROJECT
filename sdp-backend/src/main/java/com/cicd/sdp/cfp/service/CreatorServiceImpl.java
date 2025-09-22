package com.cicd.sdp.cfp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cicd.sdp.cfp.model.Creator;
import com.cicd.sdp.cfp.model.Campaign;
import com.cicd.sdp.cfp.model.Donation;
import com.cicd.sdp.cfp.repository.CreatorRepository;
import com.cicd.sdp.cfp.repository.CampaignRepository;
import com.cicd.sdp.cfp.repository.DonationRepository;

@Service
public class CreatorServiceImpl implements CreatorService {

    @Autowired
    private CreatorRepository creatorRepository;

    @Autowired
    private CampaignRepository campaignRepository;

    @Autowired
    private DonationRepository donationRepository;

    @Override
    public Creator checkCreatorLogin(String username, String password) {
        return creatorRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public String addCampaign(Campaign campaign) {
        campaignRepository.save(campaign);
        return "Campaign Added Successfully";
    }

    @Override
    public List<Campaign> viewCampaignsByCreator(int creatorId) {
        Creator creator = creatorRepository.findById(creatorId).orElse(null);
        return campaignRepository.findByCreator(creator);
    }

    @Override
    public List<Donation> viewDonationsByCreator(int creatorId) {
        return donationRepository.getDonationsByCreator(creatorId);
    }
}
