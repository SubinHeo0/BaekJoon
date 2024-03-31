import java.io.*;

public class Main {

    private static int[][] screen;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        screen = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                screen[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        quadTree(0, 0, N);
        System.out.println(sb);

    }

    private static void quadTree(int row, int col, int size) { // 0,0,N
        // 전체가 같은 숫자면 대표 숫자 출력
        if (isSame(row, col, size)) {
            sb.append(screen[row][col]);
            return;
        }

        // 동서남북 쪼개서 quadTree
        int mid = size / 2;
        sb.append("(");
        quadTree(row, col, mid); // 왼쪽 위
        quadTree(row, col + mid, mid); // 오른쪽 위
        quadTree(row + mid, col, mid); // 왼쪽 아래
        quadTree(row + mid, col + mid, mid); // 오른쪽 아래
        sb.append(")");
    }

    // 한 가지 숫자로만 구성되어 있는지 확인
    private static boolean isSame(int row, int col, int size) {
        int num = screen[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (screen[i][j] != num) return false;
            }
        }
        return true;
    }

}