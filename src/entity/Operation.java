package entity;

public class Operation {
    private int id;
    private final double number1;
    private final double number2;
    private final String operationNumber;
    private double result;
    private User owner;

    public Operation(double n1, double n2, String operation) {
        this.number1 = n1;
        this.number2 = n2;
        this.operationNumber = operation;
    }

    public Operation(int id, double number1, double number2, double result, String operationNumber) {
        this.id = id;
        this.number1 = number1;
        this.number2 = number2;
        this.operationNumber = operationNumber;
        this.result = result;
    }

    public User getOwner() {
        return owner;
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

    public double getResult() {
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
