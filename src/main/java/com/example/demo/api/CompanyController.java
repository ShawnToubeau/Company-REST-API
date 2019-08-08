package com.example.demo.api;

import com.example.demo.model.Company;
import com.example.demo.service.CompanyService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Api(value = "CompanyController", description = "Access to company database")
@RequestMapping("api/v1/companies")
@RestController
public class CompanyController {

  private final CompanyService companyService;

  @Autowired
  public CompanyController(CompanyService companyService) {
	this.companyService = companyService;
  }

  @ApiOperation(value = "Add a company", tags = "company-controller")
  @PostMapping("/add")
  public String addCompany(@ApiParam(value = "Company object that gets added to the database") @RequestBody Company company) {
	return companyService.addCompany(company);
  }

  @ApiOperation(value = "Add companies by a CSV file", tags = "company-controller")
  @PostMapping("/readcsv")
  public String loadCompanyCSV(@ApiParam(value = "Filepath to CSV with company objects") @RequestBody String filepath) throws IOException {
    return (companyService.loadCompanyCSV(filepath));
  }

  @ApiOperation(value = "Get all companies", tags = "company-controller")
  @GetMapping("/getall")
  public List<Company> getAllCompanies() {
	return companyService.getAllCompanies();
  }

  @ApiOperation(value = "Get a company by it's ID", tags = "company-controller")
  @GetMapping(path = "/get/{id}")
  public Company getCompanyById(@ApiParam(value = "ID of the company to be retrieved") @PathVariable("id") UUID id) {
	return companyService.getCompanyById(id)
			.orElse(null);
  }

  @ApiOperation(value = "Delete a company by it's ID", tags = "company-controller")
  @DeleteMapping(path = "/delete/{id}")
  public String deleteCompanyById(@ApiParam(value = "ID of the company to be deleted") @PathVariable("id") UUID id) {
    return companyService.deleteCompanyById(id);
  }

  @ApiOperation(value = "Update a company by it's ID", tags = "company-controller")
  @PutMapping(path = "update/{id}")
  public String updateCompanyById(@ApiParam(value = "ID of the company to be updated") @PathVariable("id") UUID id, @RequestBody Company company) {
    return companyService.updateCompanyById(id, company);
  }
}
