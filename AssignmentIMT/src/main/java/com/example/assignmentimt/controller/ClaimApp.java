package com.example.assignmentimt.controller;

import com.example.assignmentimt.exceptions.ClaimNumDuplicate;
import com.example.assignmentimt.exceptions.DateError;
import com.example.assignmentimt.exceptions.EmplyFieldsWhileCreating;
import com.example.assignmentimt.exceptions.NotFoundException;
import com.example.assignmentimt.models.Claim;
import com.example.assignmentimt.service.ClaimDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api")
public class ClaimApp {

    @Autowired
    private ClaimDAO claimDAO;

    @GetMapping("/claims")
    public ResponseEntity<?> getAllClaims(){
        return ResponseEntity.ok(claimDAO.getAllClaims());
    }

    @GetMapping("/claims/{claimID}")
    public ResponseEntity<?> getClaim(@PathVariable int claimID){

        if(claimDAO.getClaim(claimID) == null){
            throw new NotFoundException("Claim Not Found");
        }
        else {
            return ResponseEntity.ok(claimDAO.getClaim(claimID));
        }
    }

    @PostMapping("/claims")
    public ResponseEntity<?> createClaim(@RequestBody Claim claim){

        dataIntegrityChecker(claim, "create");

        claimDAO.createClaim(claim);

        return ResponseEntity.ok("Claim Created");
    }

    @DeleteMapping("/claims/{claimNum}")
    public ResponseEntity<?> deleteClaim(@PathVariable int claimNum){

        if(claimDAO.getClaim(claimNum) == null){
            throw new NotFoundException("Claim Not Found");
        }
        else {
            claimDAO.deleteClaim(claimNum);
            return ResponseEntity.ok("Claim Deleted");
        }
    }

    @PutMapping("/claims")
    public ResponseEntity<?> updateClaim(@RequestBody Claim claim){
        dataIntegrityChecker(claim, "update");
            claimDAO.createClaim(claim);
            return ResponseEntity.ok("Claim Update");
    }

    public void dataIntegrityChecker(Claim claim, String createOrUpdate){

        if(claim.getClaimNum() == 0 || isNullOrEmpty(claim.getClaimDate()) || isNullOrEmpty(claim.getClaimStatus())
                || isNullOrEmpty(claim.getDescription())){
            throw new EmplyFieldsWhileCreating();
        }

        Pattern pattern = Pattern.compile("[0-9]{4}-[0-9]{2}-[0-9]{2}");
        Matcher matcher = pattern.matcher(claim.getClaimDate());

        if(!matcher.find()){
            throw new DateError();
        }

        if(createOrUpdate.equalsIgnoreCase("create")){


            Claim claim1 = claimDAO.getClaim(claim.getClaimNum());

            if(claim1!= null){
                throw new ClaimNumDuplicate();
            }
        } else {
            if(claim.getClaimNum() == 0){
                throw new NotFoundException("Claim Not Found. Please Enter Existing ClaimNum");
            } else if (claimDAO.getClaim(claim.getClaimNum()) == null) {
                throw new NotFoundException("Claim Not Found. Please Enter Existing ClaimNum");
            }
        }
    }

    public boolean isNullOrEmpty(String s){
        if(s == null || s == "" || s == " "){
            return true;
        }else {
            return false;
        }
    }
}
