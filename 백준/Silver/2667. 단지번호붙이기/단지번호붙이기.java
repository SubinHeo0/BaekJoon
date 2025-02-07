import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {

    private static int N;
    private static int[][] map;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};
    private static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            String string = br.readLine();
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(string.substring(j - 1, j));
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] == 1) {
                    answer.add(0);
                    dfs(i, j, answer.size() - 1);
                }
            }
        }

        System.out.println(answer.size());
        Collections.sort(answer);
        for (int cnt : answer) {
            System.out.println(cnt);
        }

    }

    private static void dfs(int row, int col, int idx) {
        map[row][col] = 0;
        answer.set(idx, answer.get(idx) + 1);

        for (int i = 0; i < 4; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];
            if ((1 <= nx && nx <= N) && (1 <= ny && ny <= N)
                    && map[nx][ny] == 1) {
                dfs(nx, ny, idx);
            }
        }
    }

}