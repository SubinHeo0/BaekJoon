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

    private static void quadTree(int row, int col, int size) throws IOException {

        // 전체가 같은 숫자면
        if (isOne(row, col, size)) {
            sb.append(screen[row][col]);
            return;
        }

        int newSize = size / 2;
        sb.append('(');
        quadTree(row, col, newSize); // 왼쪽 위
        quadTree(row, col + newSize, newSize); // 오른쪽 위
        quadTree(row + newSize, col, newSize); // 왼쪽 아래
        quadTree(row + newSize, col + newSize, newSize); // 오른쪽 아래
        sb.append(')');

    }

    // 전체가 같은 숫자인지 체크
    private static boolean isOne(int row, int col, int size) {
        int num = screen[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (num != screen[i][j]) return false;
            }
        }
        return true;
    }
}