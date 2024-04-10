import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            int maxDp = 0;
            arr[i] = Integer.parseInt(st.nextToken());
            for (int j = 1; j < i; j++) {
                if (arr[j] < arr[i]) {
                    if (dp[j] > maxDp) maxDp = dp[j];
                }
            }
            dp[i] = maxDp + 1;
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);

    }
}
