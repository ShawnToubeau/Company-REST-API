package com.example.demo.dao;

import com.example.demo.model.Company;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CompanyDAO {

	String insertCompany(UUID id, Company company);

	default String insertCompany(Company company) {
	  UUID id = UUID.randomUUID();
	  return insertCompany(id, company);
	}

  	String loadCompanyCSV(String filePath) throws IOException;

	List<Company> selectAllCompanies();

	Optional<Company> selectCompanyById(UUID id);

	String deleteCompany(UUID id);

	String updateCompany(UUID id, Company company);
}
