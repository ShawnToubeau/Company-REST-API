package com.example.demo;

import com.example.demo.api.CompanyController;
import com.example.demo.model.Company;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.service.CompanyService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.mockito.BDDMockito.given;
import static java.util.Collections.singletonList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CompanyController.class)
public class CompanyControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private CompanyService companyService;

  @Test
  public void testGetAllCompanies() throws Exception {

//    UUID id = UUID.fromString("aa62307c-b9f1-11e9-a2a3-2a2ae2dbcce4");
//    Company mockCompany = new Company(id, "9.5E8", "Boston", "USA", "High", "001");
//
//    List<Company> companyList = Arrays.asList(mockCompany);
//
//    given(companyService.getAllCompanies()).willReturn(companyList);
//
//    mockMvc.perform(get("api/v1/companies/getall")
//            .contentType(MediaType.APPLICATION_JSON))
//            .andExpect(status().isOk());

  }

}
