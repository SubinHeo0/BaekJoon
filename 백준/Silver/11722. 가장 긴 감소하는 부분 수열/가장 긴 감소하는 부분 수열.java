import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N + 1];
        int[] dp = new int[N + 1];
        Arrays.fill(dp, 1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            int max = 0;
            for(int j=0; j<i; j++){
                if(A[j] > A[i]){
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] += max;
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);

    }
}
