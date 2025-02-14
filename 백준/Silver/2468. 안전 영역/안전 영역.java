import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    private static int N;
    private static int[][] area;
    private static boolean[][] isVisited;
    private static Map<Integer, Integer> height = new TreeMap<>();
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};
    private static int answer = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        area = new int[N][N];
        isVisited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                height.put(area[i][j], height.getOrDefault(area[i][j], 0) + 1);
            }
        }

        for (int height : height.keySet()) {
            clearVisit();
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!isVisited[i][j] && area[i][j] > height) {
                        cnt++;
                        isVisited[i][j] = true;
                        dfs(i, j, height);
                    }
                }
            }
            answer = Math.max(answer, cnt);
        }

        System.out.println(answer);


    }

    private static void clearVisit() {
        for (int i = 0; i < N; i++) {
            Arrays.fill(isVisited[i], false);
        }
    }

    private static void dfs(int x, int y, int height) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < N && 0 <= ny && ny < N && !isVisited[nx][ny] && area[nx][ny] > height) {
                isVisited[nx][ny] = true;
                dfs(nx, ny, height);
            }
        }
    }

}