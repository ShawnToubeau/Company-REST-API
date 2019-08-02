package com.example.demo.service;

import com.example.demo.dao.CompanyDAO;
import com.example.demo.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
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

  public String addCompany(Company company) {
	return companyDAO.insertCompany(company);
  }

  public String loadCompanyCSV(String filepath) throws IOException {
    return companyDAO.loadCompanyCSV(filepath);
  }

  public List<Company> getAllCompanies() {
	return companyDAO.selectAllCompanies();
  }

  public Optional<Company> getCompanyById(UUID id) {
	return companyDAO.selectCompanyById(id);
  }

  public String deleteCompanyById(UUID id) {
    return companyDAO.deleteCompany(id);
  }

  public String updateCompanyById(UUID id, Company company) {
    return companyDAO.updateCompany(id, company);
  }
}
