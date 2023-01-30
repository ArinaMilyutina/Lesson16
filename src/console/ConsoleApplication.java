package console;

import helpers.ConsoleHelpers;
import service.CalculatorService;
import helpers.Helpers;
import operation.Operation;
import storage.FileOperationStorage;

public class ConsoleApplication implements Application {

    private final Writer writer = new ConsoleWriter();
    private final Reader reader = new ConsoleReader();
    private final Helpers menu = new ConsoleHelpers();
    private final CalculatorService calculator = new CalculatorService();
    private final FileOperationStorage fileOperationStorage = new FileOperationStorage();

    @Override
    public void run() {

        while (true) {
            fileOperationStorage.checkFile();
            writer.writer("1.Calculator\n2.Reading from a file\n3.Exit");
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
                fileOperationStorage.writeFromFile(result);
                writer.writer("Result:\n" + n1 + " + " + n2 + " = " + operations.getResult());


            } else if (number.equals("2")) {
                fileOperationStorage.readFromFile();

            } else if (number.equals("3")) {
                return;
            }


        }

    }
}
