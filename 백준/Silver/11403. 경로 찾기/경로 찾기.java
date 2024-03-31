import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 플로이드-워셜 알고리즘
        for (int k = 0; k < N; k++) {
            for (int s = 0; s < N; s++) {
                for (int e = 0; e < N; e++) {
                    if ((graph[s][k] == 1) && (graph[k][e] == 1)) graph[s][e] = 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(graph[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();

    }
}