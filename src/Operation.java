public class Operation {
   private final double number1;
   private final double number2;
  private final String operationNumber;
   private double result;
    public Operation(double n1,double n2,String operation) {
        this.number1 = n1;
        this.number2 = n2;
        this.operationNumber = operation;
    }

    public double getNumber1() {
        return number1;
    }

    public double getNumber2() {
        return number2;
    }
public double getResult(){
        return result;
}

    public void setResult(double result) {
        this.result = result;
    }

    public String getOperationNumber() {
        return operationNumber;
    }

}
