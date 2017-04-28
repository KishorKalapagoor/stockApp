package com.project;
/*package com.project;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.project.stockservice.web.StockController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class TestUsingWebAppContextSetUp extends StockControllerTest {

   // @Autowired
   // private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(new StockController())
                .build();
       mockMvc = MockMvcBuilders.standaloneSetup(new StockController())
                .build();
    }

    @Test
    public void validate_getQuote() throws Exception {

        mockMvc.perform(get("/stock/getQuote?symbols=FB+BAC+F+BMY"))
                .andExpect(status().isOk())
                .andExpect(
                        content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.street").value("12345 Horton Ave"));

    }

}*/