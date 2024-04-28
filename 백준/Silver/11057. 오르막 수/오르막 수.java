import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int MOD = 10007;
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][10]; //[자릿수][값]
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) { // 자릿수
            for (int val = 0; val < 10; val++) { // 값
                for (int j = val; j < 10; j++) { // 자릿수
                    dp[i][val] += dp[i - 1][j] % MOD;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += dp[N][i] % MOD;
        }

        System.out.println(sum % MOD);


    }
}
