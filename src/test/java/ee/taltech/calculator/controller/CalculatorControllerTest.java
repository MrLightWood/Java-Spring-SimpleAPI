package ee.taltech.calculator.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@AutoConfigureMockMvc
@SpringBootTest
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mvc;

    // CALCULATE 1

    @Test
    @DisplayName("Calculate1: First 10 numbers")
    void calculate1First10Numbers() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/calculator/calculate1?input=0,1,2,3,4,5,6,7,8,9"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.sumOfEvenResult").value(20))
                .andExpect(jsonPath("$.maxOddResult").value(9))
                .andExpect(jsonPath("$.oddsResult[0]").value(1))
                .andExpect(jsonPath("$.oddsResult[1]").value(3))
                .andExpect(jsonPath("$.oddsResult[2]").value(5))
                .andExpect(jsonPath("$.oddsResult[3]").value(7))
                .andExpect(jsonPath("$.oddsResult[4]").value(9));
    }


    @Test
    @DisplayName("Calculate1: First 10 odd numbers")
    void calculate1First10NumbersWithoutEvens() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/calculator/calculate1?input=1,3,5,7,9"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.sumOfEvenResult").value(0))
                .andExpect(jsonPath("$.maxOddResult").value(9))
                .andExpect(jsonPath("$.oddsResult[0]").value(1))
                .andExpect(jsonPath("$.oddsResult[1]").value(3))
                .andExpect(jsonPath("$.oddsResult[2]").value(5))
                .andExpect(jsonPath("$.oddsResult[3]").value(7))
                .andExpect(jsonPath("$.oddsResult[4]").value(9));
    }

    @Test
    @DisplayName("Calculate1: First even 10 numbers")
    void calculate1First10NumbersWithoutOdds() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/calculator/calculate1?input=0,2,4,6,8"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.sumOfEvenResult").value(20));
    }

    @Test
    @DisplayName("Calculate1: First 10 negative numbers")
    void calculate1First10NegativeNumbers() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/calculator/calculate1?input=-0,-1,-2,-3,-4,-5,-6,-7,-8,-9"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.sumOfEvenResult").value(-20))
                .andExpect(jsonPath("$.maxOddResult").value(-1))
                .andExpect(jsonPath("$.oddsResult[0]").value(-1))
                .andExpect(jsonPath("$.oddsResult[1]").value(-3))
                .andExpect(jsonPath("$.oddsResult[2]").value(-5))
                .andExpect(jsonPath("$.oddsResult[3]").value(-7))
                .andExpect(jsonPath("$.oddsResult[4]").value(-9));
    }

    @Test
    @DisplayName("Calculate1: Empty Input")
    void calculate1EmptyInput() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/calculator/calculate1?input="))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().string("{}"));
    }

    @Test
    @DisplayName("Calculate1: No Input")
    void calculate1NoInput() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/calculator/calculate1?input"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    @DisplayName("Calculate1: Strings")
    void calculate1Strings() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/calculator/calculate1?input=a,b"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().string("Provided arguments are invalid"));
    }



    // CALCULATE 2

    @Test
    @DisplayName("Calculate2: First 10 numbers")
    void calculate2First10Numbers() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/calculator/calculate2?input=0,1,2,3,4,5,6,7,8,9"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.sumOfEvenResult").value(20))
                .andExpect(jsonPath("$.averageOfNegativesResult").value(0.0))
                .andExpect(jsonPath("$.powerOf4Result[0]").value(0))
                .andExpect(jsonPath("$.powerOf4Result[1]").value(1))
                .andExpect(jsonPath("$.powerOf4Result[2]").value(16))
                .andExpect(jsonPath("$.powerOf4Result[3]").value(81))
                .andExpect(jsonPath("$.powerOf4Result[4]").value(256))
                .andExpect(jsonPath("$.powerOf4Result[5]").value(625))
                .andExpect(jsonPath("$.powerOf4Result[6]").value(1296))
                .andExpect(jsonPath("$.powerOf4Result[7]").value(2401))
                .andExpect(jsonPath("$.powerOf4Result[8]").value(4096))
                .andExpect(jsonPath("$.powerOf4Result[9]").value(6561));
    }


    @Test
    @DisplayName("Calculate2: First 10 odd numbers")
    void calculate2First10NumbersWithoutEvens() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/calculator/calculate2?input=1,3,5,7,9"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.sumOfEvenResult").value(0))
                .andExpect(jsonPath("$.averageOfNegativesResult").value(0.0))
                .andExpect(jsonPath("$.powerOf4Result[0]").value(1))
                .andExpect(jsonPath("$.powerOf4Result[1]").value(81))
                .andExpect(jsonPath("$.powerOf4Result[2]").value(625))
                .andExpect(jsonPath("$.powerOf4Result[3]").value(2401))
                .andExpect(jsonPath("$.powerOf4Result[4]").value(6561));
    }

    @Test
    @DisplayName("Calculate2: First even 10 numbers")
    void calculate2First10NumbersWithoutOdds() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/calculator/calculate2?input=0,2,4,6,8"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.sumOfEvenResult").value(20))
                .andExpect(jsonPath("$.averageOfNegativesResult").value(0.0))
                .andExpect(jsonPath("$.powerOf4Result[0]").value(0))
                .andExpect(jsonPath("$.powerOf4Result[1]").value(16))
                .andExpect(jsonPath("$.powerOf4Result[2]").value(256))
                .andExpect(jsonPath("$.powerOf4Result[3]").value(1296))
                .andExpect(jsonPath("$.powerOf4Result[4]").value(4096));
    }

    @Test
    @DisplayName("Calculate2: Empty Input")
    void calculate2EmptyInput() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/calculator/calculate2?input="))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().string("{}"));
    }

    @Test
    @DisplayName("Calculate2: First 10 negative numbers")
    void calculate2First10NegativeNumbers() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/calculator/calculate2?input=-0,-1,-2,-3,-4,-5,-6,-7,-8,-9"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.sumOfEvenResult").value(-20))
                .andExpect(jsonPath("$.averageOfNegativesResult").value(-5.0))
                .andExpect(jsonPath("$.powerOf4Result[0]").value(0))
                .andExpect(jsonPath("$.powerOf4Result[1]").value(1))
                .andExpect(jsonPath("$.powerOf4Result[2]").value(16))
                .andExpect(jsonPath("$.powerOf4Result[3]").value(81))
                .andExpect(jsonPath("$.powerOf4Result[4]").value(256))
                .andExpect(jsonPath("$.powerOf4Result[5]").value(625))
                .andExpect(jsonPath("$.powerOf4Result[6]").value(1296))
                .andExpect(jsonPath("$.powerOf4Result[7]").value(2401))
                .andExpect(jsonPath("$.powerOf4Result[8]").value(4096))
                .andExpect(jsonPath("$.powerOf4Result[9]").value(6561));
    }

    @Test
    @DisplayName("Calculate2: No Input")
    void calculate2NoInput() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/calculator/calculate2?input"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    @DisplayName("Calculate2: Strings")
    void calculate2Strings() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/calculator/calculate2?input=a,b"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().string("Provided arguments are invalid"));
    }
}
