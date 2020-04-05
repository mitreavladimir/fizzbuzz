package ness.fizzbuzz.app.service;

public class FizzBuzzServiceImpl implements FizzBuzzService {
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
