package ness.fizzbuzz.app.api;

import ness.fizzbuzz.app.service.FizzBuzzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fizzbuzz/")
public class FizzBuzzController {

    @Autowired
    FizzBuzzService fizzBuzzService;

    @RequestMapping(value = "testfizbuzz/{number}", method = RequestMethod.GET)
    public String getFizzBuzzNumber(@PathVariable("number") Integer number) {
        return fizzBuzzService.fizzBuzz(number);
    }

    @RequestMapping(value = "range1/{r1}/range2/{r2}", method = RequestMethod.GET)
    public List<Object> getFizzBuzzRange(@PathVariable("r1") Integer r1, @PathVariable("r2") Integer r2) {
        return fizzBuzzService.rangeResource(r1, r2);
    }

    @RequestMapping("/")
    public String start(){
        return "index";
    }
}
