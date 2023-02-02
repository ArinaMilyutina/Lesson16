package helpers;


import console.util.ConsoleWriter;
import console.util.Writer;

public class ConsoleHelpers implements Helpers {
    private final Writer write = new ConsoleWriter();


    @Override
    public void consoleMenuHelperOperation() {
        write.writer("Enter the operation number:");
        write.writer("1 - Addition");
        write.writer("2 - Division");
        write.writer("3 - Multiplication");
        write.writer("4 - Subtraction");
    }

    @Override
    public void consoleMenuHelperUser() {
        write.writer("Enter the operation number:");
        write.writer("1 - Registration");
        write.writer("2 - Authorization");
        write.writer("3 - Exit");
    }

    @Override
    public void consoleMenuHelper() {
        write.writer("1 - Calculator");
        write.writer("2 - History(file)");
        write.writer("3 - History operation(List)");
        write.writer("4 - History users(List)");
        write.writer("5 - Logout");
        write.writer("6 - Exit.");
    }


}
