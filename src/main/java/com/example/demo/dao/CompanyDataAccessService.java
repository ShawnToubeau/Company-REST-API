package com.example.demo.dao;

import com.example.demo.model.Company;
import com.example.demo.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("companyDAO")
public class CompanyDataAccessService implements CompanyDAO {

  @Autowired
  private CompanyRepository companyRepository;

  @Override
  public int insertCompany(UUID id, Company company) {
	companyRepository.save(new Company(id,
			company.getAnnualRevenue(),
			company.getBillingCity(),
			company.getBillingCounty(),
			company.getCustomerPriority(),
			company.getCompanyId()));
	return 1;
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
  public int deleteCompany(UUID id) {
	companyRepository.deleteById(id);
	return 1;
  }

  @Override
  public int updateCompany(UUID id, Company companyUpdate) {
    Company companyToUpdate = companyRepository.getOne(id);
    companyToUpdate.setAnnualRevenue(companyUpdate.getAnnualRevenue());
    companyToUpdate.setBillingCity(companyUpdate.getBillingCity());
    companyToUpdate.setBillingCounty(companyUpdate.getBillingCounty());
    companyToUpdate.setCustomerPriority(companyUpdate.getCustomerPriority());
    companyToUpdate.setCompanyId(companyUpdate.getCompanyId());
    companyRepository.save(companyToUpdate);
    return 1;
  }
}
