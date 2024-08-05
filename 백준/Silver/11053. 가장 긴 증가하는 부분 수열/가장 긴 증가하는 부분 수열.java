import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];
        dp[1] = 1;
        for (int i = 2; i <= N; i++) { // 현재 채워나가는 값
            // 자기보다 작은 값중에서 dp최댓값 찾기!
            int max = 0;
            for (int j = i; j > 0; j--) { // 이전 값
                if (arr[j] < arr[i]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
        }

        // dp에서 가장 큰 값
        Arrays.sort(dp);
        System.out.println(dp[N]);


    }
}