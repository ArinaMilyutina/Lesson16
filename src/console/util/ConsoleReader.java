package console.util;


import java.util.Scanner;

public class ConsoleReader implements Reader {
    Scanner scan = new Scanner(System.in);

    @Override
    public double readDouble() {
        return scan.nextDouble();
    }

    @Override
    public String readString() {
        return scan.next();
    }

    @Override
    public int readInt() {
        return scan.nextInt();
    }


}
