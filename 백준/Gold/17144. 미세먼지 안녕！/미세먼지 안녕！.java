import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Dust {
    int row;
    int col;
    int amount;

    public Dust(int row, int col, int amount) {
        this.row = row;
        this.col = col;
        this.amount = amount;
    }
}

public class Main {

    private static int R, C;
    private static int[][] A;
    private static List<Integer> filter = new ArrayList<>();
    private static List<Dust> dust; // 미세먼지
    private static List<Integer> dirCnt; // 미세먼지가 확산될 수 있는 방향 개수
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
            dust = new ArrayList<>();
            dirCnt = new ArrayList<>();
            for (int row = 1; row <= R; row++) {
                for (int col = 1; col <= C; col++) {
                    if (A[row][col] != -1 && A[row][col] != 0) dust.add(new Dust(row, col, A[row][col]));
                }
            }
            spread();
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

    private static void spread() {
        // 미세먼지 확산 가능 방향 좌표 및 양 확인
        Queue<Dust> q = checkSpreadDir();
        // 확산
        while (!q.isEmpty()) {
            for (int i = 0; i < dust.size(); i++) {
                int cnt = dirCnt.get(i);
                for (int j = 0; j < cnt; j++) {
                    Dust now = q.poll(); // 퍼트려야할 좌표와 양
                    A[now.row][now.col] += now.amount;

                    Dust source = dust.get(i);
                    A[source.row][source.col] -= now.amount;
                    if (A[source.row][source.col] < 0) A[source.row][source.col] = 0;
                }
            }
        }

    }

    private static Queue<Dust> checkSpreadDir() {
        Queue<Dust> q = new LinkedList<>(); // 미세먼지 확산 좌표, 양 저장
        for (int i = 0; i < dust.size(); i++) {
            Dust now = dust.get(i);
            int cnt = 0;
            for (int j = 0; j < 4; j++) {
                int nr = now.row + dr[j];
                int nc = now.col + dc[j];
                if (nr <= 0 || nc <= 0 || nr > R || nc > C) continue;
                if (A[nr][nc] == -1) continue;
                q.offer(new Dust(nr, nc, now.amount / 5));
                cnt++;
            }
            dirCnt.add(cnt);
        }
        return q;
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
