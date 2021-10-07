package com.company.controller;


import com.company.models.MathSolution;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MathSolutionController.class)
public class MathSolutionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    private List<MathSolution> mathSolutionControllerList;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void shouldReturnSumOfMathSolution() throws Exception {

        MathSolution outputMathSolution = new MathSolution();

       outputMathSolution.setOperand1(7);
       outputMathSolution.setOperand2(8);
       outputMathSolution.setOperation("add");
//       outputMathSolution.setAnswer(outputMathSolution.getOperand1() + outputMathSolution.getOperand2());
//       outputMathSolution.setAnswer(15);
       outputMathSolution.setAnswer(outputMathSolution.add(outputMathSolution.getOperand1(), outputMathSolution.getOperand2()));


        String inputJson = mapper.writeValueAsString(outputMathSolution);
        String outputJson = mapper.writeValueAsString(outputMathSolution);

        mockMvc.perform(
                        post("/add")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));     // ASSERT that we got back 200 OK.

    }

    @Test
    public void shouldReturnDifferenceOfMathSolution() throws Exception {

        MathSolution outputMathSolution = new MathSolution();

        outputMathSolution.setOperand1(8);
        outputMathSolution.setOperand2(3);
        outputMathSolution.setOperation("subtract");
//       outputMathSolution.setAnswer(outputMathSolution.getOperand1() - outputMathSolution.getOperand2());
//       outputMathSolution.setAnswer(5);
        outputMathSolution.setAnswer(outputMathSolution.subtract(outputMathSolution.getOperand1(), outputMathSolution.getOperand2()));


        String inputJson = mapper.writeValueAsString(outputMathSolution);
        String outputJson = mapper.writeValueAsString(outputMathSolution);

        mockMvc.perform(
                        post("/subtract")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));     // ASSERT that we got back 200 OK.

    }

    @Test
    public void shouldReturnProductOfMathSolution() throws Exception {

        MathSolution outputMathSolution = new MathSolution();

        outputMathSolution.setOperand1(7);
        outputMathSolution.setOperand2(8);
        outputMathSolution.setOperation("multiply");
//       outputMathSolution.setAnswer(outputMathSolution.getOperand1() * outputMathSolution.getOperand2());
//       outputMathSolution.setAnswer(56);
        outputMathSolution.setAnswer(outputMathSolution.multiply(outputMathSolution.getOperand1(), outputMathSolution.getOperand2()));


        String inputJson = mapper.writeValueAsString(outputMathSolution);
        String outputJson = mapper.writeValueAsString(outputMathSolution);

        mockMvc.perform(
                        post("/multiply")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));     // ASSERT that we got back 200 OK.

    }

    @Test
    public void shouldReturnQuotientOfMathSolution() throws Exception {

        MathSolution outputMathSolution = new MathSolution();

        outputMathSolution.setOperand1(10);
        outputMathSolution.setOperand2(2);
        outputMathSolution.setOperation("divide");
//       outputMathSolution.setAnswer(outputMathSolution.getOperand1() / outputMathSolution.getOperand2());
//       outputMathSolution.setAnswer(5);
        outputMathSolution.setAnswer(outputMathSolution.divide(outputMathSolution.getOperand1(), outputMathSolution.getOperand2()));


        String inputJson = mapper.writeValueAsString(outputMathSolution);
        String outputJson = mapper.writeValueAsString(outputMathSolution);

        mockMvc.perform(
                        post("/divide")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));     // ASSERT that we got back 200 OK.

    }



    @Test
    public void shouldReturn422ForMissingOperand1OnAddMethod() throws Exception {

        MathSolution outputMathSolution = new MathSolution();
        outputMathSolution.setOperand1(0);
        outputMathSolution.setOperand2(1);

        String inputJson = mapper.writeValueAsString(outputMathSolution);

        // ACT
        mockMvc.perform(
                post("/add")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
    @Test
    public void shouldReturn422ForMissingOperand2OnAddMethod() throws Exception {

        MathSolution outputMathSolution = new MathSolution();
        outputMathSolution.setOperand1(1);
        outputMathSolution.setOperand2(0);

        String inputJson = mapper.writeValueAsString(outputMathSolution);

        // ACT
        mockMvc.perform(
                        post("/add")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
    @Test
    public void shouldReturn422ForMissingOperand1OnSubtractMethod() throws Exception {

        MathSolution outputMathSolution = new MathSolution();
        outputMathSolution.setOperand1(0);
        outputMathSolution.setOperand2(1);

        String inputJson = mapper.writeValueAsString(outputMathSolution);

        // ACT
        mockMvc.perform(
                        post("/subtract")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
    @Test
    public void shouldReturn422ForMissingOperand2OnSubtractMethod() throws Exception {

        MathSolution outputMathSolution = new MathSolution();
        outputMathSolution.setOperand1(1);
        outputMathSolution.setOperand2(0);

        String inputJson = mapper.writeValueAsString(outputMathSolution);

        // ACT
        mockMvc.perform(
                        post("/subtract")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
//    @Test
//    public void shouldReturn422ForMissingOperand1OnMultiplyMethod() throws Exception {
//
//        MathSolution outputMathSolution = new MathSolution();
//        outputMathSolution.setOperand1(0);
//        outputMathSolution.setOperand2(1);
//
//        String inputJson = mapper.writeValueAsString(outputMathSolution);
//
//        // ACT
//        mockMvc.perform(
//                        post("/multiply")
//                                .content(inputJson)
//                                .contentType(MediaType.APPLICATION_JSON)
//                )
//                .andDo(print())
//                .andExpect(status().isUnprocessableEntity());
//    }
//    @Test
//    public void shouldReturn422ForMissingOperand2OnMultiplyMethod() throws Exception {
//
//        MathSolution outputMathSolution = new MathSolution();
//        outputMathSolution.setOperand1(1);
//        outputMathSolution.setOperand2(0);
//
//        String inputJson = mapper.writeValueAsString(outputMathSolution);
//
//        // ACT
//        mockMvc.perform(
//                        post("/multiply")
//                                .content(inputJson)
//                                .contentType(MediaType.APPLICATION_JSON)
//                )
//                .andDo(print())
//                .andExpect(status().isUnprocessableEntity());
//    }
    @Test
    public void shouldReturn422ForMissingOperand1OnDivideMethod() throws Exception {

        MathSolution outputMathSolution = new MathSolution();
        outputMathSolution.setOperand1(0);
        outputMathSolution.setOperand2(10);

        String inputJson = mapper.writeValueAsString(outputMathSolution);

        // ACT
        mockMvc.perform(
                        post("/divide")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
    @Test
    public void shouldReturn422ForHaving1AsOperand1OnDivideMethod() throws Exception {

        MathSolution outputMathSolution = new MathSolution();
        outputMathSolution.setOperand1(1);
        outputMathSolution.setOperand2(10);

        String inputJson = mapper.writeValueAsString(outputMathSolution);

        // ACT
        mockMvc.perform(
                        post("/divide")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
    @Test
    public void shouldReturn422ForHaving0AsOperand2OnDivideMethod() throws Exception {

        MathSolution outputMathSolution = new MathSolution();
        outputMathSolution.setOperand1(10);
        outputMathSolution.setOperand2(0);

        String inputJson = mapper.writeValueAsString(outputMathSolution);

        // ACT
        mockMvc.perform(
                        post("/divide")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }


    @Test
    public void shouldReturn422ForMissingBothAddMethod() throws Exception {

        MathSolution outputMathSolution = new MathSolution();
        outputMathSolution.setOperand1(0);
        outputMathSolution.setOperand2(0);

        String inputJson = mapper.writeValueAsString(outputMathSolution);

        // ACT
        mockMvc.perform(
                        post("/add")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
    @Test
    public void shouldReturn422ForMissingBothOnSubtractMethod() throws Exception {

        MathSolution outputMathSolution = new MathSolution();
        outputMathSolution.setOperand1(0);
        outputMathSolution.setOperand2(0);

        String inputJson = mapper.writeValueAsString(outputMathSolution);

        // ACT
        mockMvc.perform(
                        post("/subtract")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
//    @Test
//    public void shouldReturn422ForMissingBothOnMultiplyMethod() throws Exception {
//
//        MathSolution outputMathSolution = new MathSolution();
//        outputMathSolution.setOperand1(0);
//        outputMathSolution.setOperand2(0);
//
//        String inputJson = mapper.writeValueAsString(outputMathSolution);
//
//        // ACT
//        mockMvc.perform(
//                        post("/multiply")
//                                .content(inputJson)
//                                .contentType(MediaType.APPLICATION_JSON)
//                )
//                .andDo(print())
//                .andExpect(status().isUnprocessableEntity());
//    }
    @Test
    public void shouldReturn422ForMissingBothOnDivideMethod() throws Exception {

        MathSolution outputMathSolution = new MathSolution();
        outputMathSolution.setOperand1(0);
        outputMathSolution.setOperand2(0);

        String inputJson = mapper.writeValueAsString(outputMathSolution);

        // ACT
        mockMvc.perform(
                        post("/divide")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }



}
