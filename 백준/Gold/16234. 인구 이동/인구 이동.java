import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point {
    int row;
    int col;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class Main {

    private static int N, L, R;
    private static int[][] A;
    private static boolean[][] isVisited;
    private static int[] dr = {-1, 0, 1, 0};
    private static int[] dc = {0, 1, -0, -1};
    private static List<Point> union; // 같은 연합의 좌표 정보

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        A = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(move());

    }

    private static int move() { // isMove = false 가 될 때까지 반복
        int day = 0;
        while (true) {
            boolean isMove = false;
            isVisited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!isVisited[i][j]) {
                        int sum = bfs(i, j); // 국경선 개방 및 인구 계산
                        if (union.size() > 1) {
                            isMove = true;
                            changePopulation(sum);
                        }
                    }
                }
            }

            if (!isMove) return day;
            day++;
        }
    }

    private static int bfs(int row, int col) {
        Queue<Point> q = new LinkedList<>();
        union = new ArrayList<>();

        q.offer(new Point(row, col));
        union.add(new Point(row, col));
        isVisited[row][col] = true;

        int sum = A[row][col];
        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = now.row + dr[i];
                int nc = now.col + dc[i];
                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if (!isVisited[nr][nc]) {
                    int diff = Math.abs(A[now.row][now.col] - A[nr][nc]);
                    if (L <= diff && diff <= R) {
                        q.offer(new Point(nr, nc));
                        union.add(new Point(nr, nc));
                        sum += A[nr][nc];
                        isVisited[nr][nc] = true;
                    }
                }
            }
        }
        return sum;
    }

    private static void changePopulation(int sum) {
        int avg = sum / union.size();
        for (Point point : union) {
            A[point.row][point.col] = avg;
        }
    }

}
