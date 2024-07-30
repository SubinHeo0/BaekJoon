import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[] dp;

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            dp = new int[n + 1]; // n이 4보다 작은 경우도 생각해줘야 함

            if (n == 1) {
                System.out.println(1);
                continue;
            }

            if (n == 2) {
                System.out.println(2);
                continue;
            }

            if (n == 3) {
                System.out.println(4);
                continue;
            }

            if (n >= 4) {
                dp[1] = 1;
                dp[2] = 2;
                dp[3] = 4;

                for (int j = 4; j <= n; j++) {
                    dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
                }

                System.out.println(dp[n]);
            }


        }

    }
}