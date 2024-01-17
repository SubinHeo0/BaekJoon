import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
        }

        // 그리디 알고리즘: 가장 큰 동전부터 계산
        int count = 0;
        for (int i = N - 1; i >= 0; i--) {
            count += K / coins[i];
            K %= coins[i];
        }

        System.out.println(count);

    }
}