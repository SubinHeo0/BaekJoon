import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            long[] dp = new long[N + 1];
            if (N == 1 || N == 2) {
                dp[N] = 1L;
            } else {
                dp[1] = 1L;
                dp[2] = 1L;
                for (int j = 3; j <= N; j++) {
                    dp[j] = dp[j - 3] + dp[j - 2];
                }
            }
            bw.write(dp[N] + "\n");
        }

        bw.flush();

    }
}
