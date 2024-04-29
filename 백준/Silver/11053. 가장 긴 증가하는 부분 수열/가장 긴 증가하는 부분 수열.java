import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N + 1];
        int[] dp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) { // 이전의 값들중 현재 값보다 작은 수의 최대 dp를 가져와서 +1
            int max = dp[0];
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) max = Math.max(max, dp[j]);
            }
            dp[i] = max + 1;
        }

        int max = dp[0];
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);

    }
}
