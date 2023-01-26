package console;

import helpers.ConsoleHelpers;
import service.Calculator;
import helpers.Helpers;
import operation.Operation;

public class ConsoleApplication implements Application {

    private final Writer writer = new ConsoleWriter();
    private final Reader reader = new ConsoleReader();
    private final Helpers menu = new ConsoleHelpers();
    private final Calculator calculator = new Calculator();

    @Override
    public void run() {

        while (true) {
            writer.writer("1.Calculator\n2.Exit");
            String number = reader.readString();
            if (number.equals("1")) {
                writer.writer("Enter the first number:");
                double n1 = reader.readDouble();
                writer.writer("Enter the second number:");
                double n2 = reader.readDouble();
                menu.consoleMenuHelper();
                String operation = reader.readString();
                Operation operations = new Operation(n1, n2, operation);
                Operation result = calculator.calculate(operations);
                writer.writer("Result:\n" + operations.getResult());

            }
            if (number.equals("2")) {
                return;
            }
        }

    }
}
