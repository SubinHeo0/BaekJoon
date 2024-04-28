import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N + 1][2]; // [자릿수][값(0,1)]
        dp[1][1] = 1L; // dp[1][0] = 0(0으로 시작X)
        for (int i = 2; i <= N; i++) { // 자릿수
            if (dp[i - 1][0] != 0) {
                dp[i][0] += dp[i - 1][0];
                dp[i][1] += dp[i - 1][0];
            }
            if (dp[i - 1][1] != 0) dp[i][0] += dp[i - 1][1];
        }

        System.out.println(dp[N][0] + dp[N][1]);

    }
}
