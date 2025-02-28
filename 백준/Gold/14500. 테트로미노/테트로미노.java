import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static int[][] board;
    private static boolean[][] isVisited;
    private static int max = 0;

    private static int[] dx = {-1, 1, 0, 0}; // row
    private static int[] dy = {0, 0, -1, 1}; // col

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                isVisited[i][j] = true;
                dfs(i, j, 1, board[i][j]);
                isVisited[i][j] = false;
            }
        }

        System.out.println(max);

    }

    private static void dfs(int row, int col, int depth, int sum) {
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (isVisited[nx][ny]) continue;

            if (depth == 2) {
                isVisited[nx][ny] = true;
                dfs(row, col, depth + 1, sum + board[nx][ny]);
                isVisited[nx][ny] = false;
            }

            isVisited[nx][ny] = true;
            dfs(nx, ny, depth + 1, sum + board[nx][ny]);
            isVisited[nx][ny] = false;

        }


    }

}