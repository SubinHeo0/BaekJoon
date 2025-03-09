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

    private static int N, M;
    private static int[][] lab;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static List<Point> blank = new ArrayList<>();
    private static final int WALL = 3;
    private static Point[] comb;
    private static int maxSafe = Integer.MIN_VALUE;
    private static int blankCnt = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lab = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 0) {
                    blank.add(new Point(i, j));
                    blankCnt++;
                }
            }
        }

        comb = new Point[3];
        combination(0, 0);
        System.out.println(maxSafe);

    }

    private static void combination(int idx, int start) {
        if (idx == WALL) { // 1개의 조합 완성
            int[][] clone = new int[N][M];
            Queue<Point> virus = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    clone[i][j] = lab[i][j];
                    if (clone[i][j] == 2) virus.offer(new Point(i, j));
                }
            }

            // 벽 세우기
            int safeCnt = blankCnt;
            for (Point wall : comb) {
                clone[wall.row][wall.col] = 1;
                safeCnt--;
            }

            // 바이러스 전파
            maxSafe = Math.max(maxSafe, spreadVirus(clone, virus, safeCnt));
            return;
        }

        for (int i = start; i < blank.size(); i++) {
            comb[idx] = blank.get(i);
            combination(idx + 1, i + 1);
        }
    }

    private static int spreadVirus(int[][] map, Queue<Point> virus, int safeCnt) {
        int cnt = safeCnt;
        boolean[][] isVisited = new boolean[N][M];

        while (!virus.isEmpty()) {
            Point now = virus.poll();
            for (int i = 0; i < 4; i++) {
                int nr = now.row + dr[i];
                int nc = now.col + dc[i];
                if (nr >= 0 && nc >= 0 && nr < N && nc < M
                        && map[nr][nc] == 0 && !isVisited[nr][nc]) {
                    isVisited[nr][nc] = true;
                    virus.offer(new Point(nr, nc));
                    cnt--;
                }
            }
        }

        return cnt;
    }

}