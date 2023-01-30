package console;

import console.util.ConsoleReader;
import console.util.ConsoleWriter;
import console.util.Reader;
import console.util.Writer;
import helpers.ConsoleHelpers;
import service.CalculatorService;
import helpers.Helpers;
import entity.Operation;
import storage.FileOperationStorage;


import java.util.List;


public class ConsoleApplication implements Application {

    private final Writer writer = new ConsoleWriter();
    private final Reader reader = new ConsoleReader();
    private final Helpers helpers = new ConsoleHelpers();
    private final CalculatorService calculator = new CalculatorService();
    private final FileOperationStorage fileOperationStorage = new FileOperationStorage();

    @Override
    public void run() {

        while (true) {
            fileOperationStorage.checkFile();
            writer.writer("1.Calculator\n2.Reading from a file\n3.Reading from a List\n4.Exit");
            String number1 = reader.readString();
            switch (number1) {
                case "1": {
                    writer.writer("Enter the first number:");
                    double n1 = reader.readDouble();
                    writer.writer("Enter the second number:");
                    double n2 = reader.readDouble();
                    helpers.consoleMenuHelper();
                    String operation = reader.readString();
                    Operation operations = new Operation(n1, n2, operation);
                    Operation result = calculator.calculate(operations);
                    writer.writer(result.toString());

                    break;
                }
                case "2":
                    fileOperationStorage.readFromFile();

                    break;
                case "3": {

                    List<Operation> operations = calculator.showHistoryList();
                    operations.forEach((operation) -> writer.writer(operation.toString()));

                    break;
                }
                case "4":
                    return;
            }


        }

    }
}
