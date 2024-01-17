import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        if (num2 > num1) {
            int tmp = num2;
            num2 = num1;
            num1 = tmp;
        }

        int gcdResult = gcd(num1, num2); // 최대공약수
        System.out.println(gcdResult);
        System.out.println((num1 * num2) / gcdResult); // 최소공배수

    }

    private static int gcd(int num1, int num2) {
        if (num1 % num2 == 0) return num2;
        return gcd(num2, num1 % num2);
    }
}