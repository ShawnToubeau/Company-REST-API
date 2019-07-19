package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
public class Company {

  @Id
  @GeneratedValue
  private final UUID id;

  @NotBlank
  private final String annualRevenue;

  @NotBlank
  private final String billingCity;

  @NotBlank
  private final String billingCounty;

  @NotBlank
  private final String customerPriority;

  @NotBlank
  private final String companyId;

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

  public String getAnnualRevenue() {
	return annualRevenue;
  }

  public String getBillingCity() {
	return billingCity;
  }

  public String getBillingCounty() {
	return billingCounty;
  }

  public String getCustomerPriority() {
	return customerPriority;
  }

  public String getCompanyId() {
	return companyId;
  }
}
