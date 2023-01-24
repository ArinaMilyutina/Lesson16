import java.util.Scanner;

public class ConsoleReader implements Reade {
    Scanner scan =new Scanner(System.in);
    @Override
    public double readDouble() {
        return scan.nextDouble();
    }

    @Override
    public String readString() {
        return scan.next();
    }
}
