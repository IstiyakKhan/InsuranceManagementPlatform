package com.example.assignmentimt.service;

import com.example.assignmentimt.models.Client;
import com.example.assignmentimt.repositary.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientDAO {

    @Autowired
    private ClientRepo clientRepo;

    public List<Client> allClients(){
        List<Client> clientList = clientRepo.getAllClient();

        return clientList;
    }

    public Client getClient(int id){
        Client client = clientRepo.getClient(id);

        return client;
    }

    public int getNumOfClients(){
        return clientRepo.numberOfClient();
    }


}
