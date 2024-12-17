package com.example.study.controller.calculator;

import com.example.study.dto.calculator.request.CalculatorAddRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {
    @GetMapping("/calc")
    public String addTwoNumbers(CalculatorAddRequest request){
        int Addresult = request.getNumber1()+ request.getNumber2();
        int Minusresult=request.getNumber1()- request.getNumber2();
        int Multiplyresult=request.getNumber1()* request.getNumber2();
        int Divisionresult=request.getNumber1()/ request.getNumber2();
        return "add: "+Addresult+"\n"+"minus: "+Minusresult+"\n"+"multiply: "+Multiplyresult+"\n"+"division: "+Divisionresult;
    }
}
