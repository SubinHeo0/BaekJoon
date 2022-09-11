import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        String s2 = Integer.toString(num2);

        int s2Third = Integer.valueOf(Character.toString(s2.charAt(2)));
        int s2Second = Integer.valueOf(Character.toString(s2.charAt(1)));
        int s2First = Integer.valueOf(Character.toString(s2.charAt(0)));

        System.out.println(num1 * s2Third);
        System.out.println(num1 * s2Second);
        System.out.println(num1 * s2First);
        System.out.println(num1 * num2);

        scanner.close();

    }
}
