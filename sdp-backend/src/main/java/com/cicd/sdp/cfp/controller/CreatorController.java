package com.cicd.sdp.cfp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cicd.sdp.cfp.model.Creator;
import com.cicd.sdp.cfp.model.Campaign;
import com.cicd.sdp.cfp.model.Donation;
import com.cicd.sdp.cfp.service.CreatorService;

@RestController
@RequestMapping("/api/creator")
@CrossOrigin("*")
public class CreatorController {

    @Autowired
    private CreatorService creatorService;

    // Creator Login
    @PostMapping("/login")
    public ResponseEntity<?> checkCreatorLogin(@RequestBody Creator creator) {
        try {
            Creator c = creatorService.checkCreatorLogin(creator.getUsername(), creator.getPassword());
            if (c != null) {
                return ResponseEntity.ok(c);
            } else {
                return ResponseEntity.status(401).body("Invalid Username or Password");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Login failed: " + e.getMessage());
        }
    }

    // Add Campaign
    @PostMapping("/add-campaign")
    public ResponseEntity<String> addCampaign(@RequestBody Campaign campaign) {
        try {
            String output = creatorService.addCampaign(campaign);
            return ResponseEntity.ok(output);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to Add Campaign: " + e.getMessage());
        }
    }

    // View Campaigns by Creator
    @GetMapping("/view-campaigns/{creatorId}")
    public ResponseEntity<List<Campaign>> viewCampaignsByCreator(@PathVariable int creatorId) {
        return ResponseEntity.ok(creatorService.viewCampaignsByCreator(creatorId));
    }

    // View Donations for Creator's Campaigns
    @GetMapping("/view-donations/{creatorId}")
    public ResponseEntity<List<Donation>> viewDonationsByCreator(@PathVariable int creatorId) {
        return ResponseEntity.ok(creatorService.viewDonationsByCreator(creatorId));
    }
}
