package com.example.assignmentimt.service;

import com.example.assignmentimt.models.InsurancePolicy;
import com.example.assignmentimt.repositary.InsurancePolicyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InsurancePolicyDAO {

    @Autowired
    private InsurancePolicyRepo insurancePolicyRepo;


    public List<InsurancePolicy> allPolicies(){
        List<InsurancePolicy> insurancePolicyList = insurancePolicyRepo.getAllPolicies();

        return insurancePolicyList;
     }

     public int countOfPolicies(){
        int count = insurancePolicyRepo.getCount().size();

        return count;
     }

     public InsurancePolicy getById(int policyNumber){
        InsurancePolicy insurancePolicy = insurancePolicyRepo.getById(policyNumber);

        return insurancePolicy;
     }

     public InsurancePolicy getByClaimNum(int claimNum){
        return insurancePolicyRepo.getByClaim(claimNum);
     }

     public void createPolicy(InsurancePolicy insurancePolicy){
        insurancePolicyRepo.save(insurancePolicy);
     }

     public List<Integer> getAllPolicyNumber(){
        List<Integer> policyNumberList = insurancePolicyRepo.getAllPolicyNumber();

        return policyNumberList;
     }

     public void deletePolicy(int policyID){
        insurancePolicyRepo.deleteById(policyID);
     }
}
