import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N + 1];
        int[] LR = new int[N + 1]; // 순방향 LIS
        int[] RL = new int[N + 1]; // 역방향 LIS

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 순방향 LIS
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) max = Math.max(max, LR[j]);
            }
            LR[i] = max + 1;
        }

        // 역방향 LIS
        RL[N] = 1;
        for (int i = N - 1; i > 0; i--) {
            int max = 0;
            for (int j = i + 1; j <= N; j++) {
                if (A[j] < A[i]) max = Math.max(max, RL[j]);
            }
            RL[i] = max + 1;
        }

        // 두 배열 더해서 최댓값 찾기
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, LR[i] + RL[i]);
        }

        System.out.println(answer - 1);

    }
}
