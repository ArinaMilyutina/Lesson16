package helpers;


import console.util.ConsoleWriter;
import console.util.Writer;

public class ConsoleHelpers implements Helpers {
    Writer write = new ConsoleWriter();


    @Override
    public void consoleMenuHelper() {
        write.writer("Enter the operation number:");
        write.writer("1-Addition.");
        write.writer("2-Division.");
        write.writer("3-Multiplication.");
        write.writer("4-Subtraction.");
    }


}
