package console.util;


public class ConsoleWriter implements Writer {
    @Override
    public void writer(String msg) {
        System.out.println(msg);
    }
}