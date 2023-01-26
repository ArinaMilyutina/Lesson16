package service;

import operation.Operation;

public class Calculator {
    public Operation calculate(Operation operation) {
        switch (operation.getOperationNumber()) {
            case "1" -> {
                operation.setResult(sum(operation.getNumber1(), operation.getNumber2()));
                return operation;

            }
            case "2" -> {
                operation.setResult(div(operation.getNumber1(), operation.getNumber2()));
                return operation;
            }
            case "3" -> {
                operation.setResult(mul(operation.getNumber1(), operation.getNumber2()));
                return operation;
            }
            case "4" -> {
                operation.setResult(res(operation.getNumber1(), operation.getNumber2()));
                return operation;
            }
        }
        return null;

    }

    public double sum(double a, double b) {
        return a + b;
    }


    public double res(double a, double b) {
        return a - b;
    }


    public double div(double a, double b) {
        return a / b;
    }


    public double mul(double a, double b) {
        return a * b;
    }
}
