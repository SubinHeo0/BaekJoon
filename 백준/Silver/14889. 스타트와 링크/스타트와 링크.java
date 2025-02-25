import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[][] board;
    private static boolean[] isTeam1;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N + 1][N + 1];
        isTeam1 = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 조합 구한 뒤 각 조합별 능력치 차이 계산
        DFS(0, 1);

        System.out.println(answer);

    }

    private static void DFS(int level, int start) {
        if (level == N / 2) {
            answer = Math.min(answer, difference());
            return;
        }

        for (int i = start; i <= N; i++) {
            isTeam1[i] = true;
            DFS(level + 1, i + 1);
            isTeam1[i] = false;
        }
    }

    private static int difference() {
        int team1Sum = 0;
        int team2Sum = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                if (isTeam1[i] && isTeam1[j]) team1Sum += board[i][j];
                if (!isTeam1[i] && !isTeam1[j]) team2Sum += board[i][j];
            }
        }

        return Math.abs(team1Sum - team2Sum);
    }

}