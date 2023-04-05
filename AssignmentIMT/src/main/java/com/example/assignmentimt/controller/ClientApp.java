package com.example.assignmentimt.controller;

import com.example.assignmentimt.exceptions.*;
import com.example.assignmentimt.models.Client;
import com.example.assignmentimt.models.InsurancePolicy;
import com.example.assignmentimt.repositary.ClientRepo;
import com.example.assignmentimt.repositary.InsurancePolicyRepo;
import com.example.assignmentimt.service.ClientDAO;
import com.example.assignmentimt.service.InsurancePolicyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController()
@RequestMapping("/api")
public class ClientApp {

    @Autowired
    private ClientDAO clientDAO;
    @Autowired
    private ClientRepo clientRepo;

    @Autowired
    private InsurancePolicyRepo insurancePolicyRepo;

    @Autowired
    private InsurancePolicyDAO insurancePolicyDAO;

    @GetMapping("/clients")
    public ResponseEntity<?> getAllClient(){
        return ResponseEntity.ok(clientDAO.allClients());
    }

    @GetMapping("/clients/{clientID}")
    public ResponseEntity<?> getClient(@PathVariable int clientID){

        if(clientDAO.getClient(clientID) == null){
            throw new NotFoundException("Client Not Found");

        }
        return ResponseEntity.ok(clientDAO.getClient(clientID));
    }

    @PostMapping("/clients")
    public ResponseEntity<?> createClient(@RequestBody Client client) {


        dataIntegrityChecker(client);

        int n = clientDAO.getNumOfClients();
        client.setId(n + 1);
        clientRepo.save(client);
        return ResponseEntity.ok("Client Created");
    }

    @DeleteMapping("/clients/{clientID}")
    public ResponseEntity<?> deleteClient(@PathVariable int clientID){
        if(clientID == 0 || clientID > clientDAO.getNumOfClients()){
            throw new NotFoundException("Client Not Found");
        }
        clientRepo.deleteById(clientID);
        return ResponseEntity.ok("Client Deleted");
    }

    @PutMapping("/clients")
    public ResponseEntity<?> updateClient(@RequestBody Client client){

        if(client.getId() == 0){
            throw new NotFoundException("Specify Id for Updating");
        }

        dataIntegrityChecker(client);

        System.out.println(client.getId());
        clientRepo.save(client);

        return ResponseEntity.ok("Client Updated");
    }

    public void dataIntegrityChecker(Client client){
        if(isNullOrEmpty(client.getName()) || isNullOrEmpty(client.getDateOfBirth())
                || isNullOrEmpty(client.getAddress()) || isNullOrEmpty(client.getContactInformation())){
            throw new EmplyFieldsWhileCreating();
        }

        Pattern pattern2 = Pattern.compile("^[0-9]+$");
        Matcher matcher2 = pattern2.matcher(client.getContactInformation());

        if(!matcher2.find()){
            throw new InvalidContactNumber();
        }


        if(client.getContactInformation().length() != 10){
            throw new InvalidContactNumber();
        }

        Pattern pattern = Pattern.compile("[0-9]{4}-[0-9]{2}-[0-9]{2}");
        Matcher matcher = pattern.matcher(client.getDateOfBirth());

        if(!matcher.find()){
            throw new DateError();
        }

        InsurancePolicy insurancePolicy = insurancePolicyDAO.getById(client.getInsurancePolicyNum());

        if(insurancePolicy == null){
            throw new InvalidPolicyNumber();
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
