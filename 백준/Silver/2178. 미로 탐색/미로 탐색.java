import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    private static int N, M;
    private static int[][] maze;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= line.length(); j++) {
                maze[i][j] = Integer.parseInt(line.substring(j - 1, j));
            }
        }

        bfs(1, 1);
        System.out.println(maze[N][M]);

    }

    private static void bfs(int row, int col) {
        boolean[][] isVisited = new boolean[N + 1][M + 1];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});
        isVisited[row][col] = true;
        maze[row][col] = 1;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if ((1 <= nx && nx <= N) && (1 <= ny && ny <= M)
                        && maze[nx][ny] == 1 && !isVisited[nx][ny]) {
                    isVisited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                    maze[nx][ny] = maze[now[0]][now[1]] + 1;
                }
            }
        }

    }

}