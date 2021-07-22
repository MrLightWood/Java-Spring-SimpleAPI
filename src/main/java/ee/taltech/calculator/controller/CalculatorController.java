package ee.taltech.calculator.controller;

import ee.taltech.calculator.DTO.Calculation1Result;
import ee.taltech.calculator.DTO.Calculation2Result;
import ee.taltech.calculator.service.Calculator1Service;
import ee.taltech.calculator.service.Calculator2Service;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("calculator")
public class CalculatorController {

    private final Calculator1Service calculator1Service;
    private final Calculator2Service calculator2Service;

    @GetMapping(value = "/calculate1")
    public Calculation1Result calculate1(@RequestParam List<Integer> input) {
        return calculator1Service.calculate(input);
    }

    @GetMapping(value = "/calculate2")
    public Calculation2Result calculate2(@RequestParam List<Integer> input) {
        return calculator2Service.calculate(input);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public String handleMissingParams(MethodArgumentTypeMismatchException ex) {
        return "Provided arguments are invalid";
    }
}