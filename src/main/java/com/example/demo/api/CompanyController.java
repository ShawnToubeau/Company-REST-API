package com.example.demo.api;

import com.example.demo.model.Company;
import com.example.demo.service.CompanyService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Api(value = "contacts", description = "contacts")
@RequestMapping("api/v1/companies")
@RestController
public class CompanyController {

  private final CompanyService companyService;

  @Autowired
  public CompanyController(CompanyService companyService) {
	this.companyService = companyService;
  }

  @PostMapping("/add")
  @Description("Hellllooo")
  public String addCompany(@RequestBody Company company) {
	return companyService.addCompany(company);
  }

  @PostMapping("/readcsv")
  public String loadCompanyCSV(@RequestBody String filepath) throws IOException {
    return (companyService.loadCompanyCSV(filepath));
  }

  @GetMapping("/getall")
  public List<Company> getAllCompanies() {
	return companyService.getAllCompanies();
  }

  @GetMapping(path = "/get/{id}")
  public Company getCompanyById(@PathVariable("id") UUID id) {
	return companyService.getCompanyById(id)
			.orElse(null);
  }

  @DeleteMapping(path = "/delete/{id}")
  public String deleteCompanyById(@PathVariable("id") UUID id) {
    return companyService.deleteCompanyById(id);
  }

  @PutMapping(path = "update/{id}")
  public String updateCompanyById(@PathVariable("id") UUID id, @RequestBody Company company) {
    return companyService.updateCompanyById(id, company);
  }
}
