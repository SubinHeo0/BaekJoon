import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N + 1][N + 1];

        // 사과 정보
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }

        // 방향 변환 정보
        int L = Integer.parseInt(br.readLine());
        Queue<Info> info = new LinkedList<>();
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            info.add(new Info(Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        // 방향(동남서북)
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        // 현재 정보
        int sec = 0;
        int dirIdx = 0;
        int x = 1;
        int y = 1;

        // 뱀 좌표
        Queue<int[]> snake = new LinkedList<>();
        snake.add(new int[]{1, 1});

        // 다음 방향 정보
        Info next = info.poll(); // 8 D

        while (true) {
            // 1초 증가
            sec++;

            // 이동한 좌표
            x = x + dx[dirIdx];
            y = y + dy[dirIdx];

            if (x <= 0 || y <= 0 || x > N || y > N) break;
            if (isSnake(x, y, snake)) break;

            if (board[y][x] == 1) board[y][x] = 0;
            else snake.poll();
            snake.add(new int[]{x, y});

            // 다음 정보 반영
            if (sec == next.sec) {
                if (next.dir.equals("D")) dirIdx = (dirIdx + 1) % 4; // 오른쪽 회전
                else dirIdx = (dirIdx + 3) % 4; // 왼쪽 회전
                if (!info.isEmpty()) next = info.poll();
            }
        }

        System.out.println(sec);

    }

    private static boolean isSnake(int x, int y, Queue<int[]> snake) {
        for (int[] point : snake) {
            if (point[0] == x && point[1] == y) return true;
        }
        return false;
    }

    private static class Info {
        int sec;
        String dir;

        public Info(int sec, String dir) {
            this.sec = sec;
            this.dir = dir;
        }
    }

}