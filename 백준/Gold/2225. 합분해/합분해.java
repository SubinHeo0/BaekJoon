import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int MOD = 1000000000;
        int N = Integer.parseInt(st.nextToken()); // 만들 숫자
        int K = Integer.parseInt(st.nextToken()); // 사용할 숫자 개수
        long[][] dp = new long[N + 1][K + 1];
        // K가 1일때는 1로 초기화
        for (int i = 0; i <= N; i++) {
            dp[i][1] = 1L;
        }
        // N이 0일 때 K가 1~K까지는 1로 초기화
        for (int i = 1; i <= K; i++) {
            dp[0][i] = 1L;
        }

        // dp[N][K] = 왼쪽옆 + 윗칸
        for (int i = 1; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % MOD;
            }
        }

        System.out.println(dp[N][K]);

    }
}
