package com.example.assignmentimt.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "client")
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Client {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "address")
    private String address;

    @Column(name = "contact_information")
    private String contactInformation;

//    @OneToOne(fetch = FetchType.LAZY,optional = false)
//    @JoinColumn(name = "insurance_policy_num", referencedColumnName = "policy_number")
//    private InsurancePolicy insurancePolicy;

    @Column(name = "insurance_policy_num")
    private int insurancePolicyNum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

//    public InsurancePolicy getInsurancePolicy() {
//        return insurancePolicy;
//    }
//
//    public void setInsurancePolicy(InsurancePolicy insurancePolicy) {
//        this.insurancePolicy = insurancePolicy;
//    }


    public int getInsurancePolicyNum() {
        return insurancePolicyNum;
    }

    public void setInsurancePolicyNum(int insurancePolicyNum) {
        this.insurancePolicyNum = insurancePolicyNum;
    }
}
