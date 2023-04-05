package com.example.assignmentimt.repositary;

import com.example.assignmentimt.models.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClaimRepo extends JpaRepository<Claim, Integer> {

    @Query(value = "select * from claim", nativeQuery = true)
    List<Claim> getAllClaims();

    @Query(value = "select * from claim where claim_num = ?1", nativeQuery = true)
    Claim getClaim(int claimNum);

    @Query(value = "select claim_num from claim", nativeQuery = true)
    List<Integer> getClaimNums();
}
