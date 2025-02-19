import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static int[][] room;
    private static boolean[][] isVisited;
    private static int d; // 방향(dx, dy의 인덱스로 사용)
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // row
        M = Integer.parseInt(st.nextToken()); // col

        room = new int[N][M];
        isVisited = new boolean[N][M];

        st = new StringTokenizer(br.readLine());
        int rx = Integer.parseInt(st.nextToken());
        int ry = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recur(rx, ry);
        System.out.println(cnt);

    }

    private static void recur(int row, int col) {
        if (!isVisited[row][col]) {
            cnt++;
            isVisited[row][col] = true;
        }

        // 주변 4곳 중 청소하지 않은 빈칸이 있는지 반시계방향으로 탐색
        int nd = d; // 다음 방향
        for (int i = 0; i < 4; i++) {
            if (nd == 0) nd = 3;
            else nd = nd - 1;

            // 다음 좌표 확인
            int nx = row + dx[nd];
            int ny = col + dy[nd];
            if (0 <= nx && nx < N && 0 <= ny && ny < M
                    && room[nx][ny] == 0 && !isVisited[nx][ny]) { // 주변에 청소 안 한 빈칸이 있으면 바로 다음 재귀로 이동, 이 함수는 즉시 종료
                d = nd; // 방향 전환 후
                recur(nx, ny); // 다시 1번으로. 1번으로 돌려보낸 이 함수는 이제 종료
                return;
            }
        }

        // 여기까지 내려왔으면 주변에 청소 안 한 빈칸이 없다는 의미
        // 후진 또는 종료
        int nx = row + dx[backD(d)];
        int ny = col + dy[backD(d)];
        if (0 <= nx && nx < N && 0 <= ny && ny < M
                && room[nx][ny] != 1) {
            recur(nx, ny);
        }

    }

    // 후진
    private static int backD(int nowD) {
        switch (nowD) {
            case 0:
                return 2;
            case 1:
                return 3;
            case 2:
                return 0;
            default:
                return 1;
        }
    }

}