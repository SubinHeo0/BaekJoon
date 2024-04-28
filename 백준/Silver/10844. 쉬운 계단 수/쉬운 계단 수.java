import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long MOD = 1000000000L;
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N + 1][10]; //[자릿수][값(0~9)] 경우의 수 저장

        // 자릿수가 1이면 1로 초기화
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1L;
        }

        // 두 번째 자릿수부터 N(제일 왼쪽 값)번째 자릿수까지 탐색
        for (int i = 2; i <= N; i++) {
            for (int val = 0; val < 10; val++) { // 자릿값 탐색
                if (val == 0) dp[i][val] = dp[i - 1][1] % MOD;
                else if (val == 9) dp[i][val] = dp[i - 1][8] % MOD;
                else dp[i][val] = (dp[i - 1][val - 1] + dp[i - 1][val + 1]) % MOD;
            }
        }

        // 마지막 자릿수의 자릿값 경우의 수 더하기
        long sum = 0L;
        for (int val = 0; val < 10; val++) {
            sum += dp[N][val];
        }

        System.out.println(sum % MOD);

    }
}
