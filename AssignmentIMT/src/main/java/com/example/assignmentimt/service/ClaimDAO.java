package com.example.assignmentimt.service;

import com.example.assignmentimt.models.Claim;
import com.example.assignmentimt.repositary.ClaimRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaimDAO {

    @Autowired
    private ClaimRepo claimRepo;

    public List<Claim> getAllClaims(){
        List<Claim> claimList = claimRepo.getAllClaims();

        return claimList;
    }

    public Claim getClaim(int claimNum){
        Claim claim = claimRepo.getClaim(claimNum);

        return claim;
    }

    public void createClaim(Claim claim){
        claimRepo.save(claim);
    }

    public List<Integer> getClaimNums(){
        List<Integer> integerList = claimRepo.getClaimNums();

        return integerList;
    }

    public void deleteClaim(int claimNum){
        claimRepo.deleteById(claimNum);
    }
}
