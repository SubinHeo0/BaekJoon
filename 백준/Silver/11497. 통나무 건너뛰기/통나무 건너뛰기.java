import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] log = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                log[j] = Integer.parseInt(st.nextToken());
            }
            sb.append(level(log)).append("\n");
        }

        System.out.println(sb);

    }

    private static int level(int[] log) {
        Arrays.sort(log);

        int len = log.length;
        int[] easy = new int[len];
        int lt = 0;
        int rt = len - 1;
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                easy[lt] = log[i];
                lt++;
            } else {
                easy[rt] = log[i];
                rt--;
            }
        }

        // 최대 높이차 구하기
        int max = Math.abs(easy[0] - easy[len - 1]);
        for (int i = 0; i < len - 1; i++) {
            int j = i + 1;
            if (Math.abs(easy[i] - easy[j]) > max) max = Math.abs(easy[i] - easy[j]);
        }
        return max;
    }
}