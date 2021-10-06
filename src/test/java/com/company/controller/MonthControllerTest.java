package com.company.controller;

import com.company.models.Month;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.http.MediaType;

import java.util.List;

//import static java.util.Collections.get;
import static org.junit.Assert.*;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(MonthController.class)
public class MonthControllerTest {


    // Wiring in the MockMvc object
    @Autowired
    private MockMvc mockMvc;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    private List<Month> monthList;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void shouldReturnMonths() throws Exception {

        Month outputMonth = new Month();
        outputMonth.setMonth("February");
        outputMonth.setMonthNumber(2);

        String outputJson = mapper.writeValueAsString(outputMonth);

        // ACT
        mockMvc.perform(get("/month/2"))
                .andDo(print())
                .andExpect(status().isOk())                     // ASSERT that we got back 200 OK.
                .andExpect(content().json(outputJson));         // ASSERT that what we're expecting is what we got back.

    }

    @Test
    public void shouldReturnRandomMonths() throws Exception {

//        Month outputMonth = new Month();
//        outputMonth.setMonth("February");
//        outputMonth.setMonthNumber(2);
//
//        String outputJson = mapper.writeValueAsString(outputMonth);

        // ACT
        mockMvc.perform(
                get("/randomMonth").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())                     // ASSERT that we got back 200 OK.
                .andExpect(jsonPath("$.month").isNotEmpty())
                .andExpect(jsonPath("$.monthNumber").isNotEmpty());  // ASSERT that what we're expecting is what we got back.

    }




}