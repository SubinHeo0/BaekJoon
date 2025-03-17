import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Point {
    int row;
    int col;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class Main {

    private static int N, M;
    private static int[][] map;
    private static List<Point> houses = new ArrayList<>();
    private static List<Point> stores = new ArrayList<>();
    private static int[] selected; // 살아남은 피자집 인덱스 번호 저장
    private static int minDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        selected = new int[M];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) houses.add(new Point(i, j));
                if (map[i][j] == 2) stores.add(new Point(i, j));
            }
        }

        combination(0, 0);
        System.out.println(minDistance);

    }

    private static void combination(int idx, int start) {
        if (idx == M) {
            int sum = 0;
            for (Point house : houses) {
                int homeDistance = Integer.MAX_VALUE;
                for (int i : selected) {
                    Point pizza = stores.get(i);
                    int distance = Math.abs(house.row - pizza.row) + Math.abs(house.col - pizza.col);
                    homeDistance = Math.min(homeDistance, distance);
                }
                sum += homeDistance;
            }
            minDistance = Math.min(minDistance, sum);
            return;
        }

        for (int i = start; i < stores.size(); i++) {
            selected[idx] = i;
            combination(idx + 1, i + 1);
        }
    }

}