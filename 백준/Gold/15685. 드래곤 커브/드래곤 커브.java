import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static boolean[][] map = new boolean[101][101];
    private static int[] dx = {1, 0, -1, 0}; // col
    private static int[] dy = {0, -1, 0, 1}; // row

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            List<Integer> directions = checkAllDir(d, g);
            checkVisit(x, y, directions);
        }

        System.out.println(checkCnt());

    }

    private static List<Integer> checkAllDir(int d, int g) {
        List<Integer> directions = new ArrayList<>();
        directions.add(d);

        for (int i = 1; i <= g; i++) {
            for (int j = directions.size() - 1; j >= 0; j--) {
                directions.add((directions.get(j) + 1) % 4);
            }
        }

        return directions;
    }

    private static void checkVisit(int col, int row, List<Integer> directions) {
        map[row][col] = true;
        int nr = row;
        int nc = col;

        for (int dir : directions) {
            nr += dy[dir];
            nc += dx[dir];
            map[nr][nc] = true;
        }
    }

    private static int checkCnt() {
        int cnt = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] && map[i][j + 1] && map[i + 1][j + 1] && map[i + 1][j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

}