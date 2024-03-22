package com.example.homework2;

public class Contribution {
    private String contribution, user;
    private int contributionId;
    private boolean isVisible;

    public Contribution(String contribution, String user, int contributionId, boolean isVisible) {
        this.contribution = contribution;
        this.user = user;
        this.contributionId = contributionId;
        this.isVisible = isVisible;
    }
    //region Getters and setters

    public String getContribution() {
        return contribution;
    }

    public void setContribution(String contribution) {
        this.contribution = contribution;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getContributionId() {
        return contributionId;
    }

    public void setContributionId(int contributionId) {
        this.contributionId = contributionId;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    //endregion

    public String toSavingFormat(){
        return this.contribution + "\t" + this.user+ "\t" + this.contributionId+ "\t" + this.isVisible ;
    }
}
