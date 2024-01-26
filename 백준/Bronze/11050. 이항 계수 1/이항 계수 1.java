import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] data = new int[N + 1][N + 1];

        // 배열 초기화
        for (int i = 0; i <= N; i++) {
            data[i][i] = 1;
            data[i][0] = 1;
            data[i][1] = i;
        }

        // 점화식 초기화
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                data[i][j] = data[i - 1][j] + data[i - 1][j - 1];
            }
        }

        System.out.println(data[N][K]);

    }
}