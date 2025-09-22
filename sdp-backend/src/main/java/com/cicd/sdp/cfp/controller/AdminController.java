package com.cicd.sdp.cfp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cicd.sdp.cfp.model.Admin;
import com.cicd.sdp.cfp.model.Creator;
import com.cicd.sdp.cfp.model.Contributor;
import com.cicd.sdp.cfp.service.AdminService;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin("*")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Admin Login
    @PostMapping("/login")
    public ResponseEntity<?> checkAdminLogin(@RequestBody Admin admin) {
        try {
            Admin a = adminService.checkAdminLogin(admin.getUsername(), admin.getPassword());
            if (a != null) {
                return ResponseEntity.ok(a);
            } else {
                return ResponseEntity.status(401).body("Invalid Username or Password");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Login failed: " + e.getMessage());
        }
    }

    // Creator Management
    @PostMapping("/add-creator")
    public ResponseEntity<String> addCreator(@RequestBody Creator creator) {
        try {
            String output = adminService.addCreator(creator);
            return ResponseEntity.ok(output);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to Add Creator: " + e.getMessage());
        }
    }

    @GetMapping("/view-creators")
    public ResponseEntity<List<Creator>> viewCreators() {
        return ResponseEntity.ok(adminService.displayCreators());
    }

    @DeleteMapping("/delete-creator")
    public ResponseEntity<String> deleteCreator(@RequestParam int id) {
        try {
            return ResponseEntity.ok(adminService.deleteCreator(id));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to Delete Creator");
        }
    }

    // Contributor Management
    @GetMapping("/view-contributors")
    public ResponseEntity<List<Contributor>> viewContributors() {
        return ResponseEntity.ok(adminService.displayContributors());
    }

    @DeleteMapping("/delete-contributor")
    public ResponseEntity<String> deleteContributor(@RequestParam int id) {
        try {
            return ResponseEntity.ok(adminService.deleteContributor(id));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to Delete Contributor");
        }
    }

    // Platform Statistics
    @GetMapping("/stats/contributors")
    public ResponseEntity<Long> contributorCount() {
        return ResponseEntity.ok(adminService.displayContributorCount());
    }

    @GetMapping("/stats/creators")
    public ResponseEntity<Long> creatorCount() {
        return ResponseEntity.ok(adminService.displayCreatorCount());
    }

    @GetMapping("/stats/campaigns")
    public ResponseEntity<Long> campaignCount() {
        return ResponseEntity.ok(adminService.displayCampaignCount());
    }
}
