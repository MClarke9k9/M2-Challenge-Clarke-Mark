package com.company.models;

import java.util.Objects;

public class Month {
    private String month;
    private int monthNumber;

    public Month(String month, int monthNumber) {
        this.month = month;
        this.monthNumber = monthNumber;
    }

    public Month() {

    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public void setMonthNumber(int monthNumber) {
        this.monthNumber = monthNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Month month1 = (Month) o;
        return monthNumber == month1.monthNumber && Objects.equals(month, month1.month);
    }

    @Override
    public int hashCode() {
        return Objects.hash(month, monthNumber);
    }

    @Override
    public String toString() {
        return "Month{" +
                "number='" + monthNumber + '\''+
                "month='" + month + '\'' +
                '}';
    }
}
