public class ConsoleApplication implements Application {

    private final Write writer=new ConsoleWriter();
    private final Reade reader=new ConsoleReader();
    private final Menu menu=new ConsoleMenu();
    public final Calculator calculator = new Calculator();
    @Override
    public void run() {
     while (true){
         writer.writer("Enter the first number:");
         double n1=reader.readDouble();
         writer.writer("Enter the second number:");
         double n2= reader.readDouble();
         menu.menu();
         String operation= reader.readString();
         Operation operations=new Operation(n1,n2,operation);
         Operation result=calculator.calculate(operations);
         writer.writer("Result:\n"+result);

     }
    }


}
