package ness.fizzbuzz.app;

import ness.fizzbuzz.app.service.FizzBuzzService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class FizzbuzzAppApplicationTests {

    @Autowired
    FizzBuzzService fizzBuzzService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("should return numbers")
    public void fizzBuzzTest(){
        Assertions.assertEquals("1", fizzBuzzService.fizzBuzz(1));
        Assertions.assertEquals("2", fizzBuzzService.fizzBuzz(2));
    }

    @Test
    @DisplayName("should return Fizz")
    public void multiplesOfThree(){
        Assertions.assertEquals("Fizz", fizzBuzzService.fizzBuzz(6));
    }

    @Test
    @DisplayName("should return Buzz")
    public void multiplesOfFive(){
        Assertions.assertEquals("Buzz", fizzBuzzService.fizzBuzz(5));
    }

    @Test
    @DisplayName("should return FizzBuzz")
    public void multiplesOfThreeAnFive(){
        Assertions.assertEquals("FizzBuzz", fizzBuzzService.fizzBuzz(15));
    }

    @Test
    @DisplayName("should return alfresco")
    public void checkAlfrescoNumber(){
        Assertions.assertEquals("alfresco", fizzBuzzService.fizzBuzz(3));
        Assertions.assertEquals("alfresco", fizzBuzzService.fizzBuzz(33));
    }

    @Test
    @DisplayName("should return a report")
    public void contextLoads() {
        List<Object> result = new ArrayList<>();

        IntStream.range(1,21)
                .forEach(number -> result.add(fizzBuzzService.fizzBuzz(number)));

        System.out.println(result);

        Map<String, Integer> report = new HashMap<>();


        int fizzCounter = 1;
        int buzzCounter = 1;
        int fizzbuzzCounter = 1;
        int alfrescoCounter = 1;
        int integerNumbers = 1;
        for(int i=0; i<result.size(); i++){
            if(result.get(i).equals("Fizz")){
                report.put("fizz", fizzCounter++);
            }else if(result.get(i).equals("Buzz")){
                report.put("buzz", buzzCounter++);
            }else if(result.get(i).equals("FizzBuzz")){
                report.put("fizzbuzz", fizzbuzzCounter++);
            }else if(result.get(i).equals("alfresco")){
                report.put("alfresco", alfrescoCounter++);
            }else{
                report.put("integer", integerNumbers++);
            }
        }

        System.out.println(report);
    }


    @Test
    @DisplayName("should return FizzBuzz")
    public void testRetrieveWithSuccess() throws Exception {
        this.mockMvc.perform(get("http://localhost:8080/fizzbuzz/testfizbuzz/15")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("FizzBuzz")));
    }

    @Test
    @DisplayName("should return bad request status 400")
    public void testRetrieveWithFail() throws Exception {
        this.mockMvc.perform(get("http://localhost:8080/fizzbuzz/testfizbuzz/three")).andDo(print()).andExpect(status().isBadRequest())
                .andExpect(status().is(400));
    }
}
