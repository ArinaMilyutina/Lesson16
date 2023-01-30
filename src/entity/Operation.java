package entity;

public class Operation {
    private final double number1;
    private final double number2;
    private final String operationNumber;
    private double result;
    private long id = 1;

    public Operation(double n1, double n2, String operation) {
        this.number1 = n1;
        this.number2 = n2;
        this.operationNumber = operation;
    }


    public void setId(long id) {
        this.id = id;
    }


    public double getNumber1() {
        return number1;
    }

    public double getNumber2() {
        return number2;
    }


    public void setResult(double result) {
        this.result = result;
    }

    public String getOperationNumber() {
        return operationNumber;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "number1=" + number1 +
                ", number2=" + number2 +
                ", result=" + result +
                ", id=" + id +
                '}';
    }
}
