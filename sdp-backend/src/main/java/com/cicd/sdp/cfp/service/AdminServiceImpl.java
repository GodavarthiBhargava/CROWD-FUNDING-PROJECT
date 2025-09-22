package com.cicd.sdp.cfp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cicd.sdp.cfp.model.Admin;
import com.cicd.sdp.cfp.model.Creator;
import com.cicd.sdp.cfp.model.Contributor;
import com.cicd.sdp.cfp.repository.AdminRepository;
import com.cicd.sdp.cfp.repository.CreatorRepository;
import com.cicd.sdp.cfp.repository.ContributorRepository;
import com.cicd.sdp.cfp.repository.CampaignRepository;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private CreatorRepository creatorRepository;

    @Autowired
    private ContributorRepository contributorRepository;

    @Autowired
    private CampaignRepository campaignRepository;

    @Override
    public Admin checkAdminLogin(String username, String password) {
        return adminRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public String addCreator(Creator creator) {
        creatorRepository.save(creator);
        return "Creator Added Successfully";
    }

    @Override
    public List<Creator> displayCreators() {
        return creatorRepository.findAll();
    }

    @Override
    public String deleteCreator(int creatorId) {
        Optional<Creator> creator = creatorRepository.findById(creatorId);
        if (creator.isPresent()) {
            creatorRepository.deleteById(creatorId);
            return "Creator Deleted Successfully";
        } else {
            return "Creator ID Not Found";
        }
    }

    @Override
    public List<Contributor> displayContributors() {
        return contributorRepository.findAll();
    }

    @Override
    public String deleteContributor(int contributorId) {
        Optional<Contributor> contributor = contributorRepository.findById(contributorId);
        if (contributor.isPresent()) {
            contributorRepository.deleteById(contributorId);
            return "Contributor Deleted Successfully";
        } else {
            return "Contributor ID Not Found";
        }
    }

    @Override
    public long displayContributorCount() {
        return contributorRepository.count();
    }

    @Override
    public long displayCreatorCount() {
        return creatorRepository.count();
    }

    @Override
    public long displayCampaignCount() {
        return campaignRepository.count();
    }
}
