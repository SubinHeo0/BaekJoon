import java.io.*;

public class Main {

    private static char[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        makeStar(0, 0, N, false);

        for (int i = 0; i < N; i++) {
            bw.write(arr[i]);
            bw.write("\n");
        }

        bw.flush();

    }

    private static void makeStar(int x, int y, int N, boolean isBlank) {
        // 공백칸일 경우
        if (isBlank) {
            for (int i = x; i < x + N; i++) {
                for (int j = y; j < y + N; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        if (N == 1) {
            arr[x][y] = '*';
            return;
        }

        int partSize = N / 3;
        int count = 0;
        for (int i = x; i < x + N; i += partSize) {
            for (int j = y; j < y + N; j += partSize) {
                count++;
                if (count == 5) makeStar(i, j, partSize, true);
                else makeStar(i, j, partSize, false);
            }
        }

    }
}