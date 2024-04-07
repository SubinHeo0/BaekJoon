import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int[][] screen;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        screen = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                screen[i][j] = Integer.parseInt(input[j]);
            }
        }

        quadTree(0, 0, N);
        System.out.println(sb);

    }

    private static void quadTree(int row, int col, int size) {
        if (isExistOne(row, col, size)) {
            sb.append(screen[row][col]);
            return;
        }

        int newSize = size / 2;
        sb.append("(");
        quadTree(row, col, newSize); // 왼쪽 위
        quadTree(row, col + newSize, newSize); // 오른쪽 위
        quadTree(row + newSize, col, newSize); // 왼쪽 아래
        quadTree(row + newSize, col + newSize, newSize); // 오른쪽 아래
        sb.append(")");
    }

    private static boolean isExistOne(int row, int col, int size) {
        int num = screen[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (screen[i][j] != num) return false;
            }
        }
        return true;
    }
}
