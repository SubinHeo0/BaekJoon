import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][10];

        // dp[1] = 1로 초기화
        Arrays.fill(dp[1], 1);

        // dp[N][j] = dp[N-1][j] + ... + dp[N-1][10]
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][j] += dp[i - 1][k];
                    dp[i][j] %= 10007;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += dp[N][i];
            answer %= 10007;
        }

        System.out.println(answer);
    }
}