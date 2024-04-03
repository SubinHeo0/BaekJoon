import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] arr;
    private static int wCnt = 0;
    private static int bCnt = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cut(0, 0, N);
        System.out.println(wCnt);
        System.out.println(bCnt);

    }

    private static void cut(int row, int col, int size) {
        // 전체가 같은 색이 되면 그 대표색에 맞는 cnt++
        if (isExistOne(row, col, size)) {
            if (arr[row][col] == 0) wCnt++;
            else bCnt++;
            return;
        }

        // 동서남북으로 잘라서 각각 검사
        int newSize = size / 2;
        cut(row, col, newSize);
        cut(row, col + newSize, newSize);
        cut(row + newSize, col, newSize);
        cut(row + newSize, col + newSize, newSize);

    }

    // 전체가 같은 색인지 확인
    private static boolean isExistOne(int row, int col, int size) {
        int num = arr[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (arr[i][j] != num) return false;
            }
        }
        return true;
    }
}