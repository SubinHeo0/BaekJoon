import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int subYear = 543;
        int inputYear = scanner.nextInt();

        System.out.println(inputYear - subYear);

        scanner.close();

    }
}
