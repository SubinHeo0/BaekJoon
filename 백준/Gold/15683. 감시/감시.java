import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Cctv {
    int num;
    int row;
    int col;

    public Cctv(int num, int row, int col) {
        this.num = num;
        this.row = row;
        this.col = col;
    }
}

public class Main {

    private static int N, M;
    private static int[][] office;
    private static int[] dr = {-1, 1, 0, 0}; // 상하좌우
    private static int[] dc = {0, 0, -1, 1};
    private static List<Cctv> cctv = new ArrayList<>();
    private static List<List<List<Integer>>> cctvDir = List.of(
            List.of(),
            List.of( // 1번 cctv
                    List.of(0),
                    List.of(1),
                    List.of(2),
                    List.of(3)
            ),
            List.of( // 2번 cctv
                    List.of(2, 3),
                    List.of(0, 1)
            ),
            List.of( // 3번 cctv
                    List.of(0, 3),
                    List.of(1, 3),
                    List.of(1, 2),
                    List.of(0, 2)
            ),
            List.of( // 4번 cctv
                    List.of(0, 2, 3),
                    List.of(0, 1, 3),
                    List.of(1, 2, 3),
                    List.of(0, 1, 2)
            ),
            List.of( // 5번 cctv
                    List.of(0, 1, 2, 3)
            )
    );
    private static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        office = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());
                if (office[i][j] != 0 && office[i][j] != 6) {
                    cctv.add(new Cctv(office[i][j], i, j));
                }
                if (office[i][j] == 0) answer++;
            }
        }

        combination(0, office);
        System.out.println(answer);

    }

    private static void combination(int idx, int[][] office) {
        if (idx == cctv.size()) {
            answer = Math.min(answer, checkBlind(office));
            return;
        }

        int cctvNum = cctv.get(idx).num;
        int row = cctv.get(idx).row;
        int col = cctv.get(idx).col;

        for (int i = 0; i < cctvDir.get(cctvNum).size(); i++) {
            int[][] copy = new int[N][M];
            for (int j = 0; j < N; j++) {
                copy[j] = office[j].clone();
            }

            List<Integer> direction = cctvDir.get(cctvNum).get(i);
            for (int j = 0; j < direction.size(); j++) {
                int dir = direction.get(j);
                int nr = row + dr[dir];
                int nc = col + dc[dir];

                while (true) {
                    if (nr < 0 || nc < 0 || nr >= N || nc >= M) break;
                    if (office[nr][nc] == 6) break;
                    copy[nr][nc] = -1;
                    nr += dr[dir];
                    nc += dc[dir];
                }
            }

            combination(idx + 1, copy);
        }
    }

    private static int checkBlind(int[][] office) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (office[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }

}