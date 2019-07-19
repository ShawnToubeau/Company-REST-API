package com.example.demo.dao;

import com.example.demo.model.Company;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CompanyDAO {

	int insertCompany(UUID id, Company company);

	default int insertCompany(Company person) {
	  UUID id = UUID.randomUUID();
	  return insertCompany(id, person);
	}

	List<Company> selectAllCompanies();

	Optional<Company> selectCompanyById(UUID id);

	int deleteCompany(UUID id);

	int updateCompany(UUID id, Company company);
}
