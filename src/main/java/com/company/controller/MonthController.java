package com.company.controller;


import com.company.exceptions.NotFoundException;
import com.company.models.Month;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class MonthController {

    private List<Month> monthList;

    private static int idCounter = 1;

    public MonthController() {
        monthList = new ArrayList<>();

        monthList.add(new Month("January", idCounter++));
        monthList.add(new Month("February", idCounter++));
        monthList.add(new Month("March", idCounter++));
        monthList.add(new Month("April", idCounter++));
        monthList.add(new Month("May", idCounter++));
        monthList.add(new Month("June", idCounter++));
        monthList.add(new Month("July", idCounter++));
        monthList.add(new Month("August", idCounter++));
        monthList.add(new Month("September", idCounter++));
        monthList.add(new Month("October", idCounter++));
        monthList.add(new Month("November", idCounter++));
        monthList.add(new Month("December", idCounter++));

    }

    @GetMapping("/month/{monthNumber}")
    @ResponseStatus(value = HttpStatus.OK)
    public Month getMonthByMonthNumber(@PathVariable int monthNumber) {
        Month foundMonth = null;

        for(Month month : monthList) {
            if(month.getMonthNumber() == monthNumber) {
                foundMonth = month;
                break;
            } else if (monthNumber > 13){
                throw new IllegalArgumentException("There are only 12 Months in a year.");
            } else if (monthNumber == 0) {
                throw new IllegalArgumentException("You must input a number between 1 and 12.");
            }
        }
        return foundMonth;
    }

    @GetMapping("/randomMonth")
    @ResponseStatus(value = HttpStatus.OK)
    public Month getRandomMonth() {
//        List<Object> months = Arrays.asList(monthList);
        Random rand = new Random();

        return monthList.get(rand.nextInt(monthList.size()));
    }


}
