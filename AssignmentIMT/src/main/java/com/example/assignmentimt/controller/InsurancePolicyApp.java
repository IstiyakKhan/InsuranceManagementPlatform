package com.example.assignmentimt.controller;

import com.example.assignmentimt.exceptions.*;
import com.example.assignmentimt.models.Claim;
import com.example.assignmentimt.models.InsurancePolicy;
import com.example.assignmentimt.repositary.InsurancePolicyRepo;
import com.example.assignmentimt.service.ClaimDAO;
import com.example.assignmentimt.service.InsurancePolicyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api")
public class InsurancePolicyApp {


    @Autowired
    private InsurancePolicyDAO insurancePolicyDAO;
    @Autowired
    private ClaimDAO claimDAO;

    @GetMapping("/policies")
    public ResponseEntity<?> getAllPolicies(){
        return ResponseEntity.ok(insurancePolicyDAO.allPolicies());
    }

    @GetMapping("/policies/{policyID}")
    public ResponseEntity<?> getPolicy(@PathVariable int policyID){

        if(insurancePolicyDAO.getById(policyID) == null){
            throw new NotFoundException("Policy Not Found");
        }
        return ResponseEntity.ok(insurancePolicyDAO.getById(policyID));
    }

    @PostMapping("/policies")
    public ResponseEntity<?> createPolicy(@RequestBody InsurancePolicy insurancePolicy){

        dataIntegrityChecker(insurancePolicy, "create");

        insurancePolicyDAO.createPolicy(insurancePolicy);
        return ResponseEntity.ok("Created");
    }

    @DeleteMapping("/policies/{policyID}")
    public ResponseEntity<?> deletePolicy(@PathVariable int policyID){

        InsurancePolicy insurancePolicy = insurancePolicyDAO.getById(policyID);

        if(insurancePolicy == null){
            throw new NotFoundException("Policy Not Found");
        }

        insurancePolicyDAO.deletePolicy(policyID);
        return ResponseEntity.ok("Deleted");
    }

    @PutMapping("/policies")
    public ResponseEntity<?> updatePolicy(@RequestBody InsurancePolicy insurancePolicy){
        dataIntegrityChecker(insurancePolicy, "update");
        insurancePolicyDAO.createPolicy(insurancePolicy);
        return ResponseEntity.ok("Policy Updated");
    };



    public void dataIntegrityChecker(InsurancePolicy insurancePolicy, String createOrUpdate){

        System.out.println(insurancePolicy.getClaimNum());

        if(isNullOrEmpty(insurancePolicy.getStartDate()) || isNullOrEmpty(insurancePolicy.getEndDate())
                || insurancePolicy.getClaimNum() == 0 || isNullOrEmpty(insurancePolicy.getType())
                || isNullOrEmpty(insurancePolicy.getCoverageAmount()) || insurancePolicy.getPolicyNumber() == 0){
            throw new EmplyFieldsWhileCreating();
        }

        Pattern pattern = Pattern.compile("[0-9]{4}-[0-9]{2}-[0-9]{2}");
        Matcher matcher = pattern.matcher(insurancePolicy.getStartDate());
        Matcher matcher2 = pattern.matcher(insurancePolicy.getEndDate());

        if(!matcher.find() || !matcher2.find()){
            throw new DateError();
        }

        Claim claim = claimDAO.getClaim(insurancePolicy.getClaimNum());

        if(claim == null){
            throw new NotFoundException("There are no claims with this claim num. Please Check");
        }

        if(createOrUpdate.equalsIgnoreCase("create")) {

            InsurancePolicy insurancePolicy1 = insurancePolicyDAO.getById(insurancePolicy.getPolicyNumber());

            if(insurancePolicy1 != null){
                throw new DuplicatePolicyNumber();
            }

        }
        else {
            if(insurancePolicyDAO.getById(insurancePolicy.getPolicyNumber()) == null){
                throw new InvalidPolicyNumber();
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
