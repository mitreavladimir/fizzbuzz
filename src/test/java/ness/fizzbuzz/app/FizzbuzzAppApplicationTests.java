package ness.fizzbuzz.app;

import ness.fizzbuzz.app.service.FizzBuzzServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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
        Assertions.assertEquals("Fizz", fizzBuzzServiceImpl.fizzBuzz(3));
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
    public void contextLoads() {

        IntStream.range(1,100)
                .forEach(number -> System.out.println(fizzBuzzServiceImpl.fizzBuzz(number)));
    }
}
