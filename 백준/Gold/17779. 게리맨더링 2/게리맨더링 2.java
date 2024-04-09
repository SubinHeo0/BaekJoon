import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[][] city;
    private static int sum = 0;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        city = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                sum += city[i][j];
            }
        }

        // 경계선 경우의 수
        for (int x = 1; x <= N; x++) { // 행
            for (int y = 1; y <= N; y++) { // 열
                for (int d1 = 1; d1 <= N; d1++) {
                    for (int d2 = 1; d2 <= N; d2++) {
                        if (x + d1 + d2 <= N) {
                            if ((1 <= y - d1) && (y - d1 < y) && (y + d2 <= N)) {
                                start(x, y, d1, d2);
                            }
                        }
                    }
                }
            }
        }

        System.out.println(min);

    }

    private static void start(int x, int y, int d1, int d2) {
        int[] area = new int[5]; // 선거구
        boolean[][] visit = new boolean[N + 1][N + 1];

        // 경계선
        for (int i = 0; i <= d1; i++) {
            visit[x + i][y - i] = true;
            visit[x + d2 + i][y + d2 - i] = true;
        }
        for (int i = 0; i <= d2; i++) {
            visit[x + i][y + i] = true;
            visit[x + d1 + i][y - d1 + i] = true;
        }

        // 1구역
        for (int i = 1; i < x + d1; i++) {
            for (int j = 1; j <= y; j++) { // 열에서 5를 만나면 다음 행으로
                if (visit[i][j]) break;
                area[0] += city[i][j];
            }
        }

        // 2구역(열은 N -> y로 가야함 | 방향 반대로 가야 올바르게 break에 걸림)
        for (int i = 1; i <= x + d2; i++) {
            for (int j = N; j > y; j--) {
                if (visit[i][j]) break;
                area[1] += city[i][j];
            }
        }

        // 3구역
        for (int i = x + d1; i <= N; i++) {
            for (int j = 1; j < y - d1 + d2; j++) {
                if (visit[i][j]) break;
                area[2] += city[i][j];
            }
        }

        // 4구역(열은 N -> y로 가야함 | 방향 반대로 가야 올바르게 break에 걸림)
        for (int i = x + d2 + 1; i <= N; i++) {
            for (int j = N; j >= y - d1 + d2; j--) {
                if (visit[i][j]) break;
                area[3] += city[i][j];
            }
        }

        // 5구역 인구수는 총 인구수에서 1~4구역 인구수 빼기
        area[4] = sum;
        for (int i = 0; i <= 3; i++) {
            area[4] -= area[i];
        }

        Arrays.sort(area);
        min = Math.min(min, area[4] - area[0]);

    }

}
