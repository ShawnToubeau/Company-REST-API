package com.example.demo.dao;

import com.example.demo.model.Company;
import com.example.demo.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("companyDAO")
public class CompanyDataAccessService implements CompanyDAO{

  @Autowired
  private CompanyRepository companyRepository;

  @Override
  public int insertCompany(UUID id, Company company) {
    companyRepository.save(company);
//	companyRepository.save(new Company(id, // This doesn't seem to work? Throws 'no default constructor for entity'
//			company.getAnnualRevenue(),
//			company.getBillingCity(),
//			company.getBillingCounty(),
//			company.getCustomerPriority(),
//			company.getCompanyId()));
	return 1;
  }

  @Override
  public List<Company> selectAllCompanies() {
	return companyRepository.findAll(); // Seems to work fine but once I add an entry I get 'no default constructor for entity'
  }

  @Override
  public Optional<Company> selectCompanyById(UUID id) {
    return companyRepository.findById(id);
  }
}
