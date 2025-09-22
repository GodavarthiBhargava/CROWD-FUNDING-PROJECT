package com.cicd.sdp.cfp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cicd.sdp.cfp.model.Contributor;
import com.cicd.sdp.cfp.model.Donation;
import com.cicd.sdp.cfp.model.Campaign;
import com.cicd.sdp.cfp.repository.ContributorRepository;
import com.cicd.sdp.cfp.repository.DonationRepository;
import com.cicd.sdp.cfp.repository.CampaignRepository;

@Service
public class ContributorServiceImpl implements ContributorService {

    @Autowired
    private ContributorRepository contributorRepository;

    @Autowired
    private CampaignRepository campaignRepository;

    @Autowired
    private DonationRepository donationRepository;

    @Override
    public String registerContributor(Contributor contributor) {
        contributorRepository.save(contributor);
        return "Contributor Registered Successfully";
    }

    @Override
    public Contributor checkContributorLogin(String username, String password) {
        return contributorRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public String updateContributorProfile(Contributor contributor) {
        Optional<Contributor> optionalContributor = contributorRepository.findById(contributor.getId());
        if (optionalContributor.isPresent()) {
            Contributor c = optionalContributor.get();
            c.setName(contributor.getName());
            c.setDob(contributor.getDob());
            c.setMobileno(contributor.getMobileno());
            c.setEmail(contributor.getEmail());
            c.setPassword(contributor.getPassword());
            c.setLocation(contributor.getLocation());
            contributorRepository.save(c);
            return "Contributor Profile Updated Successfully";
        } else {
            return "Contributor ID Not Found to Update";
        }
    }

    @Override
    public List<Campaign> viewAllCampaigns() {
        return campaignRepository.findAll();
    }

    @Override
    public String makeDonation(Donation donation) {
        donationRepository.save(donation);
        return "Donation Made Successfully";
    }

    @Override
    public List<Donation> getDonationsByContributor(int contributorId) {
        Contributor contributor = contributorRepository.findById(contributorId).orElse(null);
        return donationRepository.findByContributor(contributor);
    }

    @Override
    public Contributor getContributorById(int id) {
        return contributorRepository.findById(id).orElse(null);
    }

    @Override
    public Campaign getCampaignById(int id) {
        return campaignRepository.findById(id).orElse(null);
    }
}
