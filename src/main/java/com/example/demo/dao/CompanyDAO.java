package com.example.demo.dao;

import com.example.demo.model.Company;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CompanyDAO {

	Company insertCompany(UUID id, Company company);

	default Company insertCompany(Company person) {
	  UUID id = UUID.randomUUID();
	  return insertCompany(id, person);
	}

	List<Company> selectAllCompanies();

	Optional<Company> selectCompanyById(UUID id);

	void deleteCompany(UUID id);

	Company updateCompany(UUID id, Company company);
}
