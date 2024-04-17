import java.io.*;

public class Main {

    private static int max;
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            max = Integer.parseInt(br.readLine());
            dfs(1, 1, 0, 1, "1");
            bw.write("\n");
        }

        bw.flush();

    }

    private static void dfs(int now, int num, int sum, int op, String str) throws IOException {
        if (now == max) {
            sum += (num * op);
            if (sum == 0) bw.write(str + "\n");
            return;
        }

        dfs(now + 1, num * 10 + (now + 1), sum, op, str + " " + (now + 1));
        dfs(now + 1, now + 1, sum + (num * op), 1, str + "+" + (now + 1));
        dfs(now + 1, now + 1, sum + (num * op), -1, str + "-" + (now + 1));
    }
}
