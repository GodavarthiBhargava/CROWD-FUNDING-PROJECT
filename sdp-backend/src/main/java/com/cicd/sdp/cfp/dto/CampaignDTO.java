package com.cicd.sdp.cfp.dto;

public class CampaignDTO 
{
    private String title;
    private String description;
    private double goalAmount;       // target fundraising goal
    private double currentAmount;    // initially 0, updated on donations
    private int creatorId;           // foreign key reference to Creator
    private String category;         // e.g., Health, Education, Technology
    private String status;           // ACTIVE, COMPLETED, CLOSED

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public double getGoalAmount() {
        return goalAmount;
    }
    public void setGoalAmount(double goalAmount) {
        this.goalAmount = goalAmount;
    }

    public double getCurrentAmount() {
        return currentAmount;
    }
    public void setCurrentAmount(double currentAmount) {
        this.currentAmount = currentAmount;
    }

    public int getCreatorId() {
        return creatorId;
    }
    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
