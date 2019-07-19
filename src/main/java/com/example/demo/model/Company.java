package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
public class Company {

  @Id
  @GeneratedValue
  private UUID id;

  @NotBlank
  private String annualRevenue;

  @NotBlank
  private String billingCity;

  @NotBlank
  private String billingCounty;

  @NotBlank
  private String customerPriority;

  @NotBlank
  private String companyId;

  // Default no arg constructor for JPA repository
  public Company() {
  }

  public Company(@JsonProperty("id") UUID id,
				 @JsonProperty("annualrevenue") String annualRevenue,
				 @JsonProperty("billingcity") String billingCity,
				 @JsonProperty("billingcountry") String billingCounty,
				 @JsonProperty("customerpriority") String customerPriority,
				 @JsonProperty("companyId") String companyId) {

	this.id = id;
	this.annualRevenue = annualRevenue;
	this.billingCity = billingCity;
	this.billingCounty = billingCounty;
	this.customerPriority = customerPriority;
	this.companyId = companyId;
  }

  public UUID getId() {
	return id;
  }

  public void setId(UUID id) {
	this.id = id;
  }

  public String getAnnualRevenue() {
	return annualRevenue;
  }

  public void setAnnualRevenue(String annualRevenue) {
	this.annualRevenue = annualRevenue;
  }

  public String getBillingCity() {
	return billingCity;
  }

  public void setBillingCity(String billingCity) {
	this.billingCity = billingCity;
  }

  public String getBillingCounty() {
	return billingCounty;
  }

  public void setBillingCounty(String billingCounty) {
	this.billingCounty = billingCounty;
  }

  public String getCustomerPriority() {
	return customerPriority;
  }

  public void setCustomerPriority(String customerPriority) {
	this.customerPriority = customerPriority;
  }

  public String getCompanyId() {
	return companyId;
  }

  public void setCompanyId(String companyId) {
	this.companyId = companyId;
  }
}
