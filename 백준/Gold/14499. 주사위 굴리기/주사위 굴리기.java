import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N, M, x, y;
    private static int[][] board;
    private static int[] dice = new int[6]; // 뒤 위 앞 아래 왼 오

    // 방향 (동서북남)
    private static int[] dx = {0, 0, -1, 1}; // row
    private static int[] dy = {1, -1, 0, 0}; // col

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 지도
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        // 주사위 좌표
        x = Integer.parseInt(st.nextToken()); // row
        y = Integer.parseInt(st.nextToken()); // col

        int K = Integer.parseInt(st.nextToken()); // 명령 개수

        // 지도 숫자
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 명령
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int dir = Integer.parseInt(st.nextToken());
            start(dir - 1);
        }

        System.out.println(sb);
    }

    private static void start(int dir) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (nx < 0 || ny < 0 || nx >= N || ny >= M) return;

        // 방향으로 이동할 다음 칸이 유효하면 이동
        x = nx;
        y = ny;

        // 주사위 굴리기
        rollDice(dir);

        if (board[x][y] == 0) board[x][y] = dice[3];
        else {
            dice[3] = board[x][y];
            board[x][y] = 0;
        }

        sb.append(dice[1]).append("\n");

    }

    private static void rollDice(int dir) {
        int tmp;
        switch (dir) {
            case 0 -> { // 동
                tmp = dice[3];
                dice[3] = dice[5];
                dice[5] = dice[1];
                dice[1] = dice[4];
                dice[4] = tmp;
            }
            case 1 -> { // 서
                tmp = dice[3];
                dice[3] = dice[4];
                dice[4] = dice[1];
                dice[1] = dice[5];
                dice[5] = tmp;
            }
            case 2 -> { // 북
                tmp = dice[2];
                dice[2] = dice[3];
                dice[3] = dice[0];
                dice[0] = dice[1];
                dice[1] = tmp;
            }
            default -> { // 남
                tmp = dice[2];
                dice[2] = dice[1];
                dice[1] = dice[0];
                dice[0] = dice[3];
                dice[3] = tmp;
            }
        }
    }
}