import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int[] dx = {-1, 0, 1, 0}; //0:북, 1:동, 2:남, 3:서
    private static int[] dy = {0, 1, 0, -1};
    private static int[][] room;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        room = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int[] robot = new int[3];
        for (int i = 0; i < 3; i++) {
            robot[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        start(robot[0], robot[1], robot[2]);
        System.out.println(answer);

    }

    private static void start(int x, int y, int dir) { // x:row | y:col 의미
        if (room[x][y] == 0) {
            room[x][y] = -1;
            answer++;
        }
        if (isExistZero(x, y)) { // 동서남북에 0이 있으면
            int newDir = dir - 1; // 1. 반시계 방향으로 90도 회전
            for (int i = 0; i < 4; i++) {
                if (newDir < 0) newDir = 3;
                // 2. 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진
                int frontX = x + dx[newDir];
                int frontY = y + dy[newDir];
                if (room[frontX][frontY] == 0) {
                    start(frontX, frontY, newDir);
                    break;
                } else { // 90도 돌린 방향의 앞 칸이 0이 아니면 다시 90도 회전
                    newDir--;
                }
            }
        } else { // 주변이 벽이거나 이미 청소된 칸일 때 (주위에 1아니면 -1밖에 없는 경우)
            List<Integer> back = checkBack(x, y, dir); // 후진 좌표
            if (room[back.get(0)][back.get(1)] == -1) start(back.get(0), back.get(1), dir);// 뒷 칸이 -1이면 후진후 start
            else return; // 뒷칸이 벽이면 작동 종료
        }
    }

    // 후진 좌표 반환
    private static List<Integer> checkBack(int x, int y, int dir) {
        List<Integer> back = new ArrayList<>();
        int backX = 0;
        int backY = 0;

        if (dir == 0) { // 북(0)이면 남쪽(2)으로 후진
            backX = x + dx[2];
            backY = y + dy[2];
        } else if (dir == 1) { // 동(1)이면 서(3)로 후진
            backX = x + dx[3];
            backY = y + dy[3];
        } else if (dir == 2) { // 남(2)이면 북(0)으로 후진
            backX = x + dx[0];
            backY = y + dy[0];
        } else { // 동(1)으로 후진
            backX = x + dx[1];
            backY = y + dy[1];
        }

        back.add(0, backX);
        back.add(1, backY);

        return back;
    }

    // 동서남북에 0이 있는지 확인
    private static boolean isExistZero(int x, int y) {
        for (int i = 0; i < 4; i++) { // 북, 동, 남, 서 순서로 탐색
            if (room[x + dx[i]][y + dy[i]] == 0) return true;
        }
        return false;
    }
}