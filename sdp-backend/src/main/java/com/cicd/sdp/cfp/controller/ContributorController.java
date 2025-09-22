package com.cicd.sdp.cfp.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cicd.sdp.cfp.model.Contributor;
import com.cicd.sdp.cfp.model.Campaign;
import com.cicd.sdp.cfp.model.Donation;
import com.cicd.sdp.cfp.service.ContributorService;

@RestController
@RequestMapping("/api/contributor")
@CrossOrigin("*")
public class ContributorController {

    @Autowired
    private ContributorService contributorService;

    @GetMapping("/")
    public String home() {
        return "Crowdfunding Platform - Contributor API";
    }

    // Contributor Registration
    @PostMapping("/register")
    public ResponseEntity<String> registerContributor(@RequestBody Contributor contributor) {
        try {
            String output = contributorService.registerContributor(contributor);
            return ResponseEntity.ok(output);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Contributor Registration Failed");
        }
    }

    // Contributor Login
    @PostMapping("/login")
    public ResponseEntity<?> checkContributorLogin(@RequestBody Contributor contributor) {
        try {
            Contributor c = contributorService.checkContributorLogin(contributor.getUsername(), contributor.getPassword());
            if (c != null) {
                return ResponseEntity.ok(c);
            } else {
                return ResponseEntity.status(401).body("Invalid Username or Password");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Login failed: " + e.getMessage());
        }
    }

    // Update Contributor Profile
    @PutMapping("/update-profile")
    public ResponseEntity<String> updateContributorProfile(@RequestBody Contributor contributor) {
        try {
            String output = contributorService.updateContributorProfile(contributor);
            return ResponseEntity.ok(output);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to Update Contributor Profile");
        }
    }

    // View All Campaigns
    @GetMapping("/view-campaigns")
    public ResponseEntity<List<Campaign>> viewAllCampaigns() {
        return ResponseEntity.ok(contributorService.viewAllCampaigns());
    }

    // Make Donation (No payment gateway yet, just simulate)
    @PostMapping("/donate")
    public ResponseEntity<String> makeDonation(@RequestBody Donation donation) {
        try {
            int donationId = new Random().nextInt(900000) + 100000; // 6-digit random ID
            donation.setId(donationId);

            Campaign campaign = contributorService.getCampaignById(donation.getCampaign().getId());
            Contributor contributor = contributorService.getContributorById(donation.getContributor().getId());

            donation.setCampaign(campaign);
            donation.setContributor(contributor);

            String output = contributorService.makeDonation(donation);
            return ResponseEntity.ok(output);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to Make Donation: " + e.getMessage());
        }
    }

    // View all donations made by a contributor
    @GetMapping("/donations/{contributorId}")
    public ResponseEntity<List<Donation>> viewDonationsByContributor(@PathVariable int contributorId) {
        return ResponseEntity.ok(contributorService.getDonationsByContributor(contributorId));
    }
}
