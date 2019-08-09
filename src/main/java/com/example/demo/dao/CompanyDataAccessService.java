package com.example.demo.dao;

import com.example.demo.model.Company;
import com.example.demo.repository.CompanyRepository;
import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("companyDAO")
public class CompanyDataAccessService implements CompanyDAO {

  @Autowired
  private CompanyRepository companyRepository;

  @Override
  public String insertCompany(UUID id, Company company) {
	Company newCompany = new Company(id,
			company.getAnnualRevenue(),
			company.getBillingCity(),
			company.getBillingCountry(),
			company.getCustomerPriority(),
			company.getCompanyId());
	companyRepository.save(newCompany);
	return "Successfully added company: " + newCompany.toString();
  }

  @Override
  public String loadCompanyCSV(String filePath) {
	try {
	  File file = new File(filePath); // Filepath: src/main/resources/Account.csv
	  CSVReader reader = new CSVReader(new FileReader(file), ',', '"', 1);
	  String[] line;

	  while ((line = reader.readNext()) != null) {
		// Generates a random ID
		UUID id = UUID.randomUUID();
		// Create a new company object from the CSV file
		Company company = new Company();
		company.setAnnualRevenue(line[0]);
		company.setBillingCity(line[1]);
		company.setBillingCountry(line[2]);
		company.setCustomerPriority(line[3]);
		company.setCompanyId(line[4]);

		// Inserts company into database
		insertCompany(id, company);
	  }
	  reader.close();
	  return "Successfully loaded CSV into database";
	} catch (Exception e) {
	  System.out.println("Unable to read line: " + e);
	}
	return "Failed to load CSV into database: FilePath: " + filePath;
  }

  @Override
  public List<Company> selectAllCompanies() {
	return companyRepository.findAll();
  }

  @Override
  public Optional<Company> selectCompanyById(UUID id) {
	return companyRepository.findById(id);
  }

  @Override
  public String deleteCompany(UUID id) {
	Company company = companyRepository.findById(id).get();
	companyRepository.deleteById(id);
	return "Successfully deleted company: " + company.toString();
  }

  @Override
  public String updateCompany(UUID id, Company companyUpdate) {
	Company companyToUpdate = companyRepository.getOne(id);
	companyToUpdate.setAnnualRevenue(companyUpdate.getAnnualRevenue());
	companyToUpdate.setBillingCity(companyUpdate.getBillingCity());
	companyToUpdate.setBillingCountry(companyUpdate.getBillingCountry());
	companyToUpdate.setCustomerPriority(companyUpdate.getCustomerPriority());
	companyToUpdate.setCompanyId(companyUpdate.getCompanyId());
	companyRepository.save(companyToUpdate);
	return "Successfully updated company: " + companyToUpdate.toString();
  }
}
