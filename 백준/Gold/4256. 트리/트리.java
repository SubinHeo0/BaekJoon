import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int[] pre;
    private static int[] in;
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            n = Integer.parseInt(br.readLine());
            pre = new int[n + 1];
            in = new int[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                pre[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                in[j] = Integer.parseInt(st.nextToken());
            }
            postOrder(0, 0, n);
            bw.write("\n");
        }

        bw.flush();

    }

    private static void postOrder(int root, int start, int end) throws IOException {
        int rootValue = pre[root];

        // 중위 순회 범위 탐색
        for (int i = start; i < end; i++) {
            if (in[i] == rootValue) {
                postOrder(root + 1, start, i); // 왼쪽
                postOrder(root + (i - start) + 1, i + 1, end); // 오른쪽
                bw.write(rootValue + " "); // 루트
                return;
            }
        }
    }
}
