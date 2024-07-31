import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] cost = new int[2][n + 1];

            for (int row = 0; row < 2; row++) {
                String[] tmp = br.readLine().split(" ");
                for (int col = 1; col <= n; col++) {
                    cost[row][col] = Integer.parseInt(tmp[col - 1]);
                }
            }

            int[][] dp = new int[2][n + 1];
            dp[0][1] = cost[0][1];
            dp[1][1] = cost[1][1];

            for (int j = 2; j <= n; j++) {
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + cost[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + cost[1][j];
            }

            System.out.println(Math.max(dp[0][n], dp[1][n]));

        }

    }
}