import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N, L;
    private static int[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (isLoad(i, true)) cnt++; // 행 탐색 -> 각 행의 열 탐색
            if (isLoad(i, false)) cnt++;// 열 탐색 -> 각 열의 행 탐색

        }

        System.out.println(cnt);

    }

    private static boolean isLoad(int now, boolean isRow) {
        int[] height = new int[N];
        boolean[] isRunway = new boolean[N];

        for (int i = 0; i < N; i++) {
            if (isRow) height[i] = map[now][i];
            else height[i] = map[i][now];
        }

        for (int i = 0; i < N - 1; i++) {
            int heightDiff = height[i] - height[i + 1];

            if (Math.abs(heightDiff) >= 2) return false;

            // 내리막
            if (heightDiff == 1) {
                for (int j = i + 1; j <= i + L; j++) {
                    if (j < 0 || j >= N) return false;
                    if (isRunway[j] || height[i + 1] != height[j]) return false;
                    isRunway[j] = true;
                }
            }

            // 오르막
            if (heightDiff == -1) {
                for (int j = i; j > i - L; j--) {
                    if (j < 0 || j >= N) return false;
                    if (isRunway[j] || height[i] != height[j]) return false;
                    isRunway[j] = true;
                }
            }
        }

        return true;
    }

}