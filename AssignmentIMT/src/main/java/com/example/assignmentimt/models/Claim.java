package com.example.assignmentimt.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Entity(name = "claim")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Claim {

    @Id
    @Column(name = "claim_num")
    private int claimNum;

    @Column(name = "description")
    private String description;

    @Column(name = "claim_date")
    private String claimDate;

    @Column(name = "claim_status")
    private String claimStatus;

    public int getClaimNum() {
        return claimNum;
    }

    public void setClaimNum(int claimNum) {
        this.claimNum = claimNum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(String claimDate) {
        this.claimDate = claimDate;
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
    }
}
