import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        // 최대공약수: 유클리드 호제법
        // MOD 연산을 나머지가 0이 나올 때까지 계속 수행
        int gcd = 0; // 최대공약수
        int first = num1;
        int second = num2;
        while (true) {
            int[] nums = mod(first, second);
            if (nums[1] == 0) {
                gcd = nums[0];
                break;
            }
            first = nums[0];
            second = nums[1];

        }

        System.out.println(gcd);
        System.out.println((num1 * num2) / gcd); // 최소공배수

    }

    private static int[] mod(int first, int second) {
        return new int[]{second, first % second}; // 작은값과 모드결과값 리턴
    }
}