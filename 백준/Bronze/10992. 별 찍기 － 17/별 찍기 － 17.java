import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            if (i == N) { // 마지막줄이면 별 2N-1개 출력
                for (int j = 0; j < 2 * N - 1; j++) {
                    bw.write("*");
                }
                break;
            }

            if (i == 1) {
                for (int j = 0; j < N - 1; j++) {
                    bw.write(" ");
                }
                bw.write("*\n");
                continue;
            }

            // 첫줄과 마지막줄빼고는 두개의 별 출력
            for (int j = 0; j < N - i; j++) {
                bw.write(" ");
            }
            bw.write("*");
            for (int j = 0; j < (i - 1) * 2 - 1; j++) {
                bw.write(" ");
            }
            bw.write("*\n");

        }

        bw.flush();

    }
}