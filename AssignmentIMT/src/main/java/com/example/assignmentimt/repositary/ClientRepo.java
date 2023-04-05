package com.example.assignmentimt.repositary;

import com.example.assignmentimt.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepo extends JpaRepository<Client, Integer> {

    @Query(value = "select * from client",nativeQuery = true)
    List<Client> getAllClient();

    @Query(value = "select * from client where id = ?1", nativeQuery = true)
    Client getClient(int id);

    @Query(value = "select count(*) from client", nativeQuery = true)
    int numberOfClient();
}
