package com.cicd.sdp.cfp.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "donation_table")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "campaign_id", nullable = false)
    private Campaign campaign;

    @ManyToOne
    @JoinColumn(name = "contributor_id", nullable = false)
    private Contributor contributor;

    @Column(nullable = false)
    private double amount;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime donationTime;

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public Contributor getContributor() {
        return contributor;
    }

    public void setContributor(Contributor contributor) {
        this.contributor = contributor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDonationTime() {
        return donationTime;
    }

    public void setDonationTime(LocalDateTime donationTime) {
        this.donationTime = donationTime;
    }
}
