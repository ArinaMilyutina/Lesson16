package helpers;

import console.ConsoleWriter;
import console.Writer;

public class ConsoleHelpers implements Helpers {
    Writer writer = new ConsoleWriter();

    @Override
    public void consoleMenuHelper() {
        writer.writer("Enter the operation number:");
        writer.writer("1-Addition.");
        writer.writer("2-Division.");
        writer.writer("3-Multiplication.");
        writer.writer("4-Subtraction.");
    }

}
