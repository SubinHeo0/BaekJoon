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

        // 가능한 경계선
        for (int x = 1; x <= N; x++) { // 행
            for (int y = 1; y <= N; y++) { // 열
                for (int d1 = 1; d1 <= N; d1++) {
                    for (int d2 = 1; d2 <= N; d2++) {
                        if ((x + d1 + d2 <= N) && (1 <= y - d1) && (y + d2 <= N)) {
                            splitCity(x, y, d1, d2);
                        }
                    }
                }
            }
        }

        System.out.println(min);

    }

    // 하나의 경계선에 대한 인구차의 최솟값
    private static void splitCity(int x, int y, int d1, int d2) {
        int[] people = new int[5];

        // 경계선
        boolean[][] visit = new boolean[N + 1][N + 1];
        for (int i = 0; i <= d1; i++) {
            visit[x + i][y - i] = true;
            visit[x + d2 + i][y + d2 - i] = true;
        }
        for (int i = 0; i <= d2; i++) {
            visit[x + i][y + i] = true;
            visit[x + d1 + i][y - d1 + i] = true;
        }

        // 1구역
        for (int r = 1; r < x + d1; r++) {
            for (int c = 1; c <= y; c++) { // 5를 만나면 다음 행으로
                if (visit[r][c]) break;
                people[0] += city[r][c];
            }
        }

        // 2구역
        for (int r = 1; r <= x + d2; r++) {
            for (int c = N; c > y; c--) { // 오른쪽에서 왼쪽으로 탐색(<-) 5를 만나면 다음 행으로
                if (visit[r][c]) break;
                people[1] += city[r][c];
            }
        }

        // 3구역
        for (int r = x + d1; r <= N; r++) {
            for (int c = 1; c < y - d1 + d2; c++) {
                if (visit[r][c]) break;
                people[2] += city[r][c];
            }
        }

        // 4구역
        for (int r = x + d2 + 1; r <= N; r++) {
            for (int c = N; c >= y - d1 + d2; c--) { // 오른쪽에서 왼쪽으로 탐색(<-) 5를 만나면 다음 행으로
                if (visit[r][c]) break;
                people[3] += city[r][c];
            }
        }

        // 5구역: 총인구수 - 1~4구역인구수
        people[4] = sum;
        for (int i = 0; i < 4; i++) {
            people[4] -= people[i];
        }

        Arrays.sort(people);
        min = Math.min(min, (people[4] - people[0]));
    }
}
