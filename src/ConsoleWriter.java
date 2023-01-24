

public class ConsoleWriter implements Write {
    @Override
    public void writer(String msg) {
        System.out.println(msg);
    }
}
