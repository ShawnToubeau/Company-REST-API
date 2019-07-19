package com.example.demo.api;

import com.example.demo.model.Company;
import com.example.demo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/company")
@RestController
public class CompanyController {

  private final CompanyService companyService;

  @Autowired
  public CompanyController(CompanyService companyService) {
	this.companyService = companyService;
  }

  @PostMapping
  public void addCompany(@Valid @NonNull @RequestBody Company company) {
	companyService.addCompany(company);
  }

  @GetMapping
  public List<Company> getAllCompanies() {
	return companyService.getAllCompanies();
  }

  @GetMapping(path = "{id}")
  public Company getCompanyById(@NonNull @PathVariable("id") UUID id) {
	return companyService.getCompanyById(id)
			.orElse(null);
  }

  @DeleteMapping(path = "{id}")
  public void deleteCompanyById(@NonNull @PathVariable("id") UUID id) {
    companyService.deleteCompanyById(id);
  }

  @PutMapping(path = "{id}")
  public void updateCompanyById(@NonNull @PathVariable("id") UUID id, @RequestBody Company company) {
    companyService.updateCompanyById(id, company);
  }
}
