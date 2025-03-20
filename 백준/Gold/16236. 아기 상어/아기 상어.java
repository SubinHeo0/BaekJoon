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

    private static int N;
    private static int[][] sea;
    private static int[] dr = {-1, 0, 1, 0}; // 위 왼쪽 아래 오른쪽
    private static int[] dc = {0, -1, 0, 1};
    private static Point shark;
    private static int size = 2;
    private static List<Point> fish = new ArrayList<>();
    private static int cnt = 0; // 먹은 물고기 개수
    private static int sec = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        sea = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                sea[i][j] = Integer.parseInt(st.nextToken());
                if (sea[i][j] == 9) shark = new Point(i, j);
                if (1 <= sea[i][j] && sea[i][j] <= 6) fish.add(new Point(i, j));
            }
        }


        move();
        System.out.println(sec);


    }

    // fish 리스트에 상어보다 작은 물고기가 없을 때까지 반복
    private static void move() {
        while (true) {
            int minDist = Integer.MAX_VALUE;
            int fishIdx = 0;

            for (int i = 0; i < fish.size(); i++) {
                Point point = fish.get(i);
                if (sea[point.row][point.col] >= size) continue;
                // 물고기 크기가 상어보다 작을 때 -> 물고기 좌표와 상어 좌표의 최단 거리 탐색
                int dist = bfs(point.row, point.col);
                if (dist == -1) continue;
                if (dist < minDist) {
                    minDist = dist;
                    fishIdx = i;
                }
            }

            if (minDist == Integer.MAX_VALUE) return;

            // 먹을 수 있는 물고기 탐색 완료, 이동
            sec += minDist;
            cnt++;

            sea[shark.row][shark.col] = 0; // 원래 상어가 있던 자리 0으로
            shark = fish.get(fishIdx);
            sea[shark.row][shark.col] = 0; // 상어가 물고기를 먹은 자리 0으로
            fish.remove(fishIdx);

            if (cnt == size) {
                size++;
                cnt = 0;
            }
        }
    }

    // 물고기와 상어의 최단 거리
    // 리턴값 -1: 물고기까지 가는 경로 존재 X
    private static int bfs(int row, int col) {
        boolean[][] isVisited = new boolean[N][N];
        Queue<Point> q = new LinkedList<>();
        isVisited[shark.row][shark.col] = true;
        q.offer(shark);

        int dist = 0;
        while (!q.isEmpty()) {
            int level = q.size();
            for (int i = 0; i < level; i++) {
                Point now = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nr = now.row + dr[j];
                    int nc = now.col + dc[j];
                    if (nr < 0 || nc < 0 || nr >= N || nc >= N || isVisited[nr][nc]) continue;
                    if (sea[nr][nc] > size) continue;
                    isVisited[nr][nc] = true;
                    q.offer(new Point(nr, nc));
                    if (nr == row && nc == col) return dist + 1;
                }
            }
            dist++;
        }
        return -1;
    }

}
