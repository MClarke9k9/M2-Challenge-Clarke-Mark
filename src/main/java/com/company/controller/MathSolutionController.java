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

    private static List<MathSolution> mathList = new ArrayList<>(Arrays.asList(
            new MathSolution(0, 0, "type", 0)

    ));



    @PostMapping("/add")
    @ResponseStatus(value = HttpStatus.CREATED)
    public MathSolution addition(@RequestBody MathSolution add) {


        add.setOperation("add");
        add.setAnswer(add.getOperand1() + add.getOperand2());

        return add;

    }

    @PostMapping("/subtract")
    @ResponseStatus(value = HttpStatus.CREATED)
    public MathSolution subtraction(@RequestBody MathSolution subtract) {


        subtract.setOperation("subtract");
        subtract.setAnswer(subtract.getOperand1() - subtract.getOperand2());

        return subtract;

    }

    @PostMapping("/multiply")
    @ResponseStatus(value = HttpStatus.CREATED)
    public MathSolution multiplication(@RequestBody MathSolution multiply) {


        multiply.setOperation("multiply");
        multiply.setAnswer(multiply.getOperand1() * multiply.getOperand2());

        return multiply;

    }

    @PostMapping("/divide")
    @ResponseStatus(value = HttpStatus.CREATED)
    public MathSolution division(@RequestBody MathSolution divide) {


        divide.setOperation("divide");
        divide.setAnswer(divide.getOperand1() / divide.getOperand2());

        return divide;

    }

}

