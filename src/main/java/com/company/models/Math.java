package com.company.models;

import java.util.Objects;

public class Math {

    private int a;
    private int b;
    private String operation;
    private int answer;

    public Math(int a, int b, String operation, int answer) {
        this.a = a;
        this.b = b;
        this.operation = operation;
        this.answer = answer;
    }

    public int getA() {
        return a;
    }

    public int setA(int a) {
        this.a = a;
        return a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Math math = (Math) o;
        return a == math.a && b == math.b && answer == math.answer && Objects.equals(operation, math.operation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, operation, answer);
    }

    @Override
    public String toString() {
        return "Math{" +
                "operand1='" + a + '\''+
                "operand2='" + b + '\'' +
                "operation='" + operation + '\''+
                "answer='" + answer + '\'' +
                '}';
    }

}
