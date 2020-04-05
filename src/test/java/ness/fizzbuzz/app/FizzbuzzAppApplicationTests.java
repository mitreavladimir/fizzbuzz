package ness.fizzbuzz.app;

import ness.fizzbuzz.app.service.FizzBuzzServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

@SpringBootTest
class FizzbuzzAppApplicationTests {

    FizzBuzzServiceImpl fizzBuzzServiceImpl = new FizzBuzzServiceImpl();
    @Test
    public void fizzBuzzTest(){
        Assertions.assertEquals("1", fizzBuzzServiceImpl.fizzBuzz(1));
        Assertions.assertEquals("2", fizzBuzzServiceImpl.fizzBuzz(2));

        System.out.println("fizzBuzzTest");
    }

    @Test
    public void multiplesOfThree(){
        Assertions.assertEquals("Fizz", fizzBuzzServiceImpl.fizzBuzz(6));
        System.out.println("multiplesOfThree");
    }

    @Test
    public void multiplesOfFive(){
        Assertions.assertEquals("Buzz", fizzBuzzServiceImpl.fizzBuzz(5));
        System.out.println("multiplesOfFive");
    }

    @Test
    public void multiplesOfThreeAnFive(){

        Assertions.assertEquals("FizzBuzz", fizzBuzzServiceImpl.fizzBuzz(15));
        System.out.println("multiplesOfThreeAnFive");
    }

    @Test
    public void checkAlfrescoNumber(){

        Assertions.assertEquals("alfresco", fizzBuzzServiceImpl.fizzBuzz(3));
        Assertions.assertEquals("alfresco", fizzBuzzServiceImpl.fizzBuzz(33));
        System.out.println("checkAlfrescoNumber");
    }

    @Test
    public void contextLoads() {
        List<Object> result = new ArrayList<>();

        IntStream.range(1,21)
                .forEach(number -> result.add(fizzBuzzServiceImpl.fizzBuzz(number)));

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
}
