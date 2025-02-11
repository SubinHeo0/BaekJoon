import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int F;
    private static boolean[] isVisited;
    private static int[] button = new int[2]; // U D
    private static boolean flag = false;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken()); // 출발
        int G = Integer.parseInt(st.nextToken()); // 도착
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken()) * -1;

        isVisited = new boolean[F + 1];

        button[0] = U;
        button[1] = D;

        if ((S > G && D >= 0) && (S < G && U <= 0)) {
            System.out.println("use the stairs");
        } else {
            bfs(S, G);
            if (flag) System.out.println(answer);
            else System.out.println("use the stairs");
        }


    }

    private static void bfs(int start, int end) {
        if (start == end) {
            flag = true;
            return;
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        isVisited[start] = true;

        while (!q.isEmpty()) {
            int size = q.size(); // 1
            for (int i = 0; i < size; i++) {
                int now = q.poll(); // 1
                for (int j = 0; j < 2; j++) {
                    int next = now + button[j];
                    if ((1 <= next && next <= F) && !isVisited[next]) {
                        if (next == end) {
                            flag = true;
                            answer++;
                            return;
                        }
                        isVisited[next] = true;
                        q.offer(next);
                    }
                }
            }
            answer++;
        }
    }

}