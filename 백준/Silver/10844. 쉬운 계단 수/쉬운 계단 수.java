import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private final static long MOD = 1000000000L;
    private static long[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new long[N + 1][10]; //[자릿수][값(0~9)] 경우의 수 저장

        // 자릿수가 1이면 1로 초기화
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1L;
        }

        // 마지막 자릿수(제일 왼쪽 값)인 1~9까지의 경우의 수 더하기
        long sum = 0L;
        for (int i = 1; i <= 9; i++) {
            sum += recur(N, i);
        }

        System.out.println(sum % MOD);

    }

    private static long recur(int digit, int val) { // digit:자릿수, val:값
        if (digit == 1) return dp[digit][val];

        if (dp[digit][val] == 0L) {
            if (val == 0) dp[digit][val] = recur(digit - 1, 1);
            else if (val == 9) dp[digit][val] = recur(digit - 1, 8);
            else dp[digit][val] = recur(digit - 1, val - 1) + recur(digit - 1, val + 1);
        }

        return dp[digit][val] % MOD;
    }
}
