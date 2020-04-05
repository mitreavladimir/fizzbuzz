package ness.fizzbuzz.app.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class FizzBuzzServiceImpl implements FizzBuzzService {


    public List<Object> rangeResource(int r1, int r2){
        List<Object> result = new ArrayList<>();
        IntStream.range(r1,r2)
                .forEach(number -> result.add(fizzBuzz(number)));

        return result;
    }

    public String fizzBuzz(int number) {

        if(number%15 == 0){
            return "FizzBuzz";
        }

        if(number%5 == 0){
            return "Buzz";
        }

        if(checkNumberThree(number)){
            return "alfresco";
        }

        if(number%3 == 0){
            return "Fizz";
        }

        return String.valueOf(number);
    }

    public boolean checkNumberThree(int n) {
        boolean checkNumberThree = false;
        int r = 0;
        while(n>0){
            r=n%10;
            if(r == 3) {
                checkNumberThree = true;
                break;
            }else{
                break;
            }
        }
        return checkNumberThree;
    }
}
