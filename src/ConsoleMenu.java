public class ConsoleMenu implements Menu {
    @Override
    public void menu(){
        System.out.println("Enter the operation number:");
        System.out.println("1-Addition.");
        System.out.println("2-Division.");
        System.out.println("3-Multiplication.");
        System.out.println("4-Subtraction.");
    }
}
