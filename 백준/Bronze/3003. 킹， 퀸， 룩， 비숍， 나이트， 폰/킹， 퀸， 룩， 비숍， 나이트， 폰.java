import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] original = { 1, 1, 2, 2, 2, 8 };
        int[] input = new int[original.length];

        for (int i = 0; i < original.length; i++) {
            input[i] = scanner.nextInt();
            System.out.print((original[i] - input[i]) + " ");
        }

        scanner.close();

    }
}
