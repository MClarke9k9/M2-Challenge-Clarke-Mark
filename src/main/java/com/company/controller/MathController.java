package com.company.controller;



import com.company.models.Math;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class MathController {

//    private static int x;
//    private static int y;
//    private static int ans = x + y;

    private static List<Math> mathList = new ArrayList<>(Arrays.asList(
            new Math(0, 0, "type", 0)

    ));

    public int add(int a, int b) {
        return a + b;
    }

    @PostMapping("/add")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Math addition(@RequestBody Math add,
                         @PathVariable int x, int y) {

        add.setA(x);
        add.setB(y);
        add.setOperation("add");
        add.setAnswer(add(x,y));
        mathList.add(add);
       return add;

    }
}

