import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        if (N % 2 == 0) {
            dp[0] = 1; // 추가되는 예외 케이스 계산을 위해 1로 초기화
            dp[2] = 3;
            for (int i = 4; i <= N; i += 2) {
                dp[i] = dp[i - 2] * dp[2];
                for (int j = i - 4; j >= 0; j -= 2) {
                    dp[i] += (dp[j] * 2); // 2가지 예외
                }
            }

        }

        System.out.println(dp[N]);

    }
}
