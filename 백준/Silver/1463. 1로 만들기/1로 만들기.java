import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        for (int i = 2; i <= N; i++) {
            int min = Integer.MAX_VALUE;
            if (i % 3 == 0) min = dp[i / 3];
            if (i % 2 == 0) min = Math.min(min, dp[i / 2]);
            min = Math.min(min, dp[i - 1]);
            dp[i] = min + 1;
        }

        System.out.println(dp[N]);

    }
}