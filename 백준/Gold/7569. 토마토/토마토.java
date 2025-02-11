import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Tomato {
    int x;
    int y;
    int height;

    public Tomato(int x, int y, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
    }
}

public class Main {

    private static int M, N, H;
    private static List<int[][]> boxes = new ArrayList<>();
    private static Queue<Tomato> q = new LinkedList<>();
    private static int zeroCnt = 0; // 익지 않은 토마토 개수
    private static int answer = -1; // 최소 일수
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};
    private static int[] dz = {1, -1}; // 위 아래 층 탐색

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 가로(col)
        N = Integer.parseInt(st.nextToken()); // 세로(row)
        H = Integer.parseInt(st.nextToken()); // 높이

        for (int i = 0; i < H; i++) {
            boxes.add(new int[N][M]);
            int[][] box = boxes.get(i);
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    box[j][k] = Integer.parseInt(st.nextToken());
                    if (box[j][k] == 1) q.offer(new Tomato(j, k, i));
                    if (box[j][k] == 0) zeroCnt++;
                }
            }
        }

        if (zeroCnt == 0) {
            System.out.println(0);
        } else {
            bfs();
            if (zeroCnt == 0) System.out.println(answer);
            else System.out.println(-1);
        }


    }

    private static void bfs() {
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Tomato now = q.poll();
                // now 기준 상하좌우 & 위아래 같은 좌표 중 0인 토마토 1로 변경 후 큐 삽입
                for (int j = 0; j < 4; j++) {
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];
                    if ((0 <= nx && nx < N) && (0 <= ny && ny < M)
                            && boxes.get(now.height)[nx][ny] == 0) {
                        boxes.get(now.height)[nx][ny] = 1;
                        zeroCnt--;
                        q.offer(new Tomato(nx, ny, now.height));
                    }
                }
                for (int j = 0; j < 2; j++) {
                    int nh = now.height + dz[j];
                    if ((0 <= nh && nh < H) && boxes.get(nh)[now.x][now.y] == 0) {
                        boxes.get(nh)[now.x][now.y] = 1;
                        zeroCnt--;
                        q.offer(new Tomato(now.x, now.y, nh));
                    }
                }
            }
            answer++;
        }
    }

}