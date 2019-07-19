package com.example.demo.service;

import com.example.demo.dao.CompanyDAO;
import com.example.demo.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CompanyService {

  private final CompanyDAO companyDAO;

  @Autowired
  public CompanyService(@Qualifier("companyDAO") CompanyDAO companyDAO) {
	this.companyDAO = companyDAO;
  }

  public int addCompany(Company company) {
	return companyDAO.insertCompany(company);
  }

  public List<Company> getAllCompanies() {
	return companyDAO.selectAllCompanies();
  }

  public Optional<Company> getCompanyById(UUID id) {
	return companyDAO.selectCompanyById(id);
  }

  public void deleteCompanyById(UUID id) {
	companyDAO.deleteCompany(id);
  }

  public void updateCompanyById(UUID id, Company company) {
    companyDAO.updateCompany(id, company);
  }
}
