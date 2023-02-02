package console.util;


public class ConsoleWriter implements Writer {
    @Override
    public void writer(String msg) {
        System.out.println(msg);
    }

    public void writerError(String msg) {
        System.err.println(msg);
    }
}
