package com.cicd.sdp.cfp.service;

import java.util.List;

import com.cicd.sdp.cfp.model.Contributor;
import com.cicd.sdp.cfp.model.Donation;
import com.cicd.sdp.cfp.model.Campaign;

public interface ContributorService {

    public String registerContributor(Contributor contributor);

    public Contributor checkContributorLogin(String username, String password);

    public String updateContributorProfile(Contributor contributor);

    public List<Campaign> viewAllCampaigns();

    public String makeDonation(Donation donation);

    public List<Donation> getDonationsByContributor(int contributorId);

    public Contributor getContributorById(int id);

    public Campaign getCampaignById(int id);
}
