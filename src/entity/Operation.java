package entity;

public class Operation extends AbstractEntity {
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

    public User getOwner() {
        return owner;
    }

    @Override
    public long getId() {
        return super.getId();
    }

    @Override
    public void setId(long id) {
        super.setId(id);
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
                ", id=" + getId() +
                '}';
    }
}
