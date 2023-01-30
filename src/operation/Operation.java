package operation;

public class Operation {
    private  double number1;
    private  double number2;
    private  String operationNumber;
    private double result;

    public Operation(double n1, double n2, String operation) {
        this.number1 = n1;
        this.number2 = n2;
        this.operationNumber = operation;
    }

     public Operation(){

     }
    public double getNumber1() {
        return number1;
    }

    public double getNumber2() {
        return number2;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String getOperationNumber() {
        return operationNumber;
    }

}
