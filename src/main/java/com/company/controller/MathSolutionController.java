package com.company.controller;



import com.company.models.MathSolution;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class MathSolutionController {

//    private static int x;
//    private static int y;
//    private static int ans = x + y;

//    private static List<MathSolution> mathList = new ArrayList<>(Arrays.asList(
//            new MathSolution(0, 0, "type", 0)
//
//    ));



    @PostMapping("/add")
    @ResponseStatus(value = HttpStatus.CREATED)
    public MathSolution addition(@RequestBody MathSolution add) {

        if(add.getOperand1() <= 0 && add.getOperand2() <= 0) {
            throw new IllegalArgumentException("You must enter a number greater then 0 in both fields Operand1 and Operand2.");
        } else if (add.getOperand1() <= 0) {
            throw new IllegalArgumentException("You must enter a number greater then 0 in Operand1 field.");
        } else if (add.getOperand2() <= 0) {
            throw new IllegalArgumentException("You must enter a number greater then 0 in Operand2 field.");
        }
        
        add.setOperation("add");
        add.setAnswer(add.getOperand1() + add.getOperand2());


        return add;

    }

    @PostMapping("/subtract")
    @ResponseStatus(value = HttpStatus.CREATED)
    public MathSolution subtraction(@RequestBody MathSolution subtract) {

        if(subtract.getOperand1() <= 0 && subtract.getOperand2() <= 0) {
            throw new IllegalArgumentException("You must enter a number greater then 0 in both fields Operand1 and Operand2.");
        } else if (subtract.getOperand1() <= 0) {
            throw new IllegalArgumentException("You must enter a number greater then 0 in Operand1 field.");
        } else if (subtract.getOperand2() <= 0) {
            throw new IllegalArgumentException("You must enter a number greater then 0 in Operand2 field.");
        }

        subtract.setOperation("subtract");
        subtract.setAnswer(subtract.getOperand1() - subtract.getOperand2());


        return subtract;

    }

    @PostMapping("/multiply")
    @ResponseStatus(value = HttpStatus.CREATED)
    public MathSolution multiplication(@RequestBody MathSolution multiply) {

        if(multiply.getOperand1() <= 0 && multiply.getOperand2() <= 0) {
            throw new IllegalArgumentException("You must enter a number greater then 0 in both fields Operand1 and Operand2.");
        } else if (multiply.getOperand1() <= 0) {
            throw new IllegalArgumentException("You must enter a number greater then 0 in Operand1 field.");
        } else if (multiply.getOperand2() <= 0) {
            throw new IllegalArgumentException("You must enter a number greater then 0 in Operand2 field.");
        }

        multiply.setOperation("multiply");
        multiply.setAnswer(multiply.getOperand1() * multiply.getOperand2());

        return multiply;

    }



    @PostMapping("/divide")
    @ResponseStatus(value = HttpStatus.CREATED)
    public MathSolution division(@RequestBody MathSolution divide) {

        if(divide.getOperand1() <= 0 && divide.getOperand2() <= 0) {
            throw new IllegalArgumentException("You must enter a number greater then 0 in both fields Operand1 and Operand2.");
        } else if (divide.getOperand1() == 0 || divide.getOperand1() == 1) {
            throw new IllegalArgumentException("You must enter a number greater then 0 and 1 in Operand1 field.");
        } else if (divide.getOperand2() == 0) {
            throw new IllegalArgumentException("You cannot enter 0 in Operand2 field.");
        }

        divide.setOperation("divide");
        divide.setAnswer(divide.getOperand1() / divide.getOperand2());


        return divide;

    }

}

