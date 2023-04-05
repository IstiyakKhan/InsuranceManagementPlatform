package com.example.assignmentimt.repositary;

import com.example.assignmentimt.models.InsurancePolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InsurancePolicyRepo extends JpaRepository<InsurancePolicy,Integer> {

    @Query(value = "select policy_number from insurance_policy",nativeQuery = true)
    List<Integer> getAllPolicyNumber();

    @Query(value = "select * from insurance_policy",nativeQuery = true)
    List<InsurancePolicy> getAllPolicies();

    @Query(value = "select count(*) from insurance_policy", nativeQuery = true)
    List<Integer> getCount();

    @Query(value = "select * from insurance_policy where policy_number = ?1", nativeQuery = true)
    InsurancePolicy getById(int policyNumber);

    @Query(value = "select * from insurance_policy where claim_num = ?1", nativeQuery = true)
    InsurancePolicy getByClaim(int claimNum);
}
