import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int R, C;
    private static int[][] A;
    private static List<Integer> filter = new ArrayList<>();
    private static int[] dr = {-1, 0, 1, 0};
    private static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        A = new int[R + 1][C + 1];
        for (int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= C; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                if (A[i][j] == -1) filter.add(i);
            }
        }

        for (int i = 0; i < T; i++) {
            A = spread();
            clean();
        }

        int sum = 0;
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if (A[i][j] != -1 && A[i][j] != 0) sum += A[i][j];
            }
        }

        System.out.println(sum);

    }

    private static int[][] spread() {
        int[][] tmp = new int[R + 1][C + 1];
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if (A[i][j] == -1) {
                    tmp[i][j] = -1;
                    continue;
                }
                tmp[i][j] += A[i][j];
                for (int k = 0; k < 4; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];
                    if (nr <= 0 || nc <= 0 || nr > R || nc > C) continue;
                    if (A[nr][nc] == -1) continue;
                    tmp[nr][nc] += A[i][j] / 5;
                    tmp[i][j] -= A[i][j] / 5;
                }
            }
        }
        return tmp;
    }

    private static void clean() {
        // 위 필터 -> 반시계 방향
        int top = filter.get(0);
        for (int row = top - 1; row > 1; row--) {
            A[row][1] = A[row - 1][1];
        }
        for (int col = 1; col < C; col++) {
            A[1][col] = A[1][col + 1];
        }
        for (int row = 1; row < top; row++) {
            A[row][C] = A[row + 1][C];
        }
        for (int col = C; col > 2; col--) {
            A[top][col] = A[top][col - 1];
        }
        A[top][2] = 0;

        // 아래 필터 -> 시계 방향
        int bottom = filter.get(1);
        for (int row = bottom + 1; row < R; row++) {
            A[row][1] = A[row + 1][1];
        }
        for (int col = 1; col < C; col++) {
            A[R][col] = A[R][col + 1];
        }
        for (int row = R; row > bottom; row--) {
            A[row][C] = A[row - 1][C];
        }
        for (int col = C; col > 2; col--) {
            A[bottom][col] = A[bottom][col - 1];
        }
        A[bottom][2] = 0;
    }

}
