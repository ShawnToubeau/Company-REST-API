package com.example.demo;

import com.example.demo.dao.CompanyDAO;
import com.example.demo.model.Company;
import com.example.demo.service.CompanyService;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RunWith(MockitoJUnitRunner.class)
public class CompanyServiceTest {

  @InjectMocks
  CompanyService companyService;

  @Mock
  CompanyDAO dao;

  @Test
  public void addCompanyTest() {
	UUID id = UUID.fromString("aa62307c-b9f1-11e9-a2a3-2a2ae2dbcce4");
	Company company = new Company(id, "9.5E8", "Boston", "USA", "High", "001");

	companyService.addCompany(company);

	verify(dao, times(1)).insertCompany(company);
  }

  @Test
  public void getAllCompaniesTest() {
	List<Company> list = new ArrayList<Company>();
	UUID id1 = UUID.fromString("aa62307c-b9f1-11e9-a2a3-2a2ae2dbcce4");
	UUID id2 = UUID.fromString("5b467959-6495-47a4-a70b-d501958f8547");
	UUID id3 = UUID.fromString("f7e432d2-e3ff-4390-88da-919bb793bdc4");
	Company company1 = new Company(id1, "9.5E8", "Boston", "USA", "High", "001");
	Company company2 = new Company(id2, "3.2E3", "Portland", "USA", "Med", "002");
	Company company3 = new Company(id3, "6.1E9", "Philadelphia", "USA", "Low", "003");

	list.add(company1);
	list.add(company2);
	list.add(company3);

	when(dao.selectAllCompanies()).thenReturn(list);

	List<Company> empList = companyService.getAllCompanies();

	assertEquals(3, empList.size());
	verify(dao, times(1)).selectAllCompanies();
  }

  @Test
  public void getCompanyByIdTest() {
	UUID id = UUID.fromString("aa62307c-b9f1-11e9-a2a3-2a2ae2dbcce4");
	Company company = new Company(id, "9.5E8", "Boston", "USA", "High", "001");

	when(dao.selectCompanyById(id)).thenReturn(Optional.of(company));

	Optional<Company> result = companyService.getCompanyById(id);

	assertEquals("9.5E8", result.get().getAnnualRevenue());
	assertEquals("Boston", result.get().getBillingCity());
	assertEquals("USA", result.get().getBillingCountry());
	assertEquals("High", result.get().getCustomerPriority());
	assertEquals("001", result.get().getCompanyId());
  }

  @Test
  public void updateCompanyByIdTest() {
	UUID id = UUID.fromString("aa62307c-b9f1-11e9-a2a3-2a2ae2dbcce4");
	Company company = new Company(id, "9.5E8", "Boston", "USA", "High", "001");
	Company updatedCompany = new Company(id, "3.2E3", "Portland", "USA", "Med", "002");

	companyService.addCompany(company);

	companyService.updateCompanyById(id, updatedCompany);

	verify(dao, times(1)).updateCompany(id, updatedCompany);
  }

  @Test
  public void deleteCompanyByIdTest() {
	UUID id = UUID.fromString("aa62307c-b9f1-11e9-a2a3-2a2ae2dbcce4");
	Company company = new Company(id, "9.5E8", "Boston", "USA", "High", "001");

	companyService.addCompany(company);

	companyService.deleteCompanyById(id);

	verify(dao, times(1)).deleteCompany(id);
  }
}
