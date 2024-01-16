import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int[][] graph;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 행
        M = Integer.parseInt(st.nextToken()); // 열
        graph = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }
        bfs(0, 0);
        System.out.println(graph[N - 1][M - 1]);

    }

    private static void bfs(int row, int col) {
        visited[row][col] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col}); // 현재 방문한 점을 큐에 넣어줌
        while (!queue.isEmpty()) {
            int[] now = queue.poll(); // 큐의 맨 앞 값을 꺼냄
            for (int i = 0; i < 4; i++) { // 상하좌우 탐색
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                if (x >= 0 && y >= 0 && x < N && y < M) { // 배열을 넘어가면 안됨
                    if (graph[x][y] != 0 && !visited[x][y]) { // 값이 0이거나 이미 방문한 점이면 안됨
                        visited[x][y] = true;
                        graph[x][y] = graph[now[0]][now[1]] + 1; // depth+1
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
    }
}