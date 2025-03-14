import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Turn {
    boolean isTurn = false;
    int dir = 0;

    public Turn() {};

    public Turn(boolean isTurn, int dir) {
        this.isTurn = isTurn;
        this.dir = dir;
    }

}

public class Main {

    private static List<int[]> wheels = new ArrayList<>();
    private static boolean[] isVisited;
    private static Turn[] turn; // 각 바퀴의 회전유무, 방향 저장
    private static int[] side = {-1, 1}; // 왼쪽 바퀴, 오른쪽 바퀴

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 4; i++) {
            wheels.add(new int[8]);
            String tmp = br.readLine();
            for (int j = 0; j < 8; j++) {
                wheels.get(i)[j] = Integer.parseInt(tmp.substring(j, j + 1));
            }
        }

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            start(num, dir);
        }

        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += wheels.get(i)[0] == 0 ? 0 : (int) Math.pow(2, i);
        }

        System.out.println(sum);

    }

    private static void start(int num, int dir) {
        isVisited = new boolean[4];
        turn = new Turn[4];
        Queue<Integer> q = new LinkedList<>();

        isVisited[num] = true;
        turn[num] = new Turn(true, dir);
        q.offer(num);

        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == -1) continue;

            // 양 옆 바퀴 확인
            for (int i = 0; i < 2; i++) {
                int next = now + side[i];
                if (next < 0 || next >= 4 || isVisited[next]) continue;

                isVisited[next] = true;
                turn[next] = new Turn(); // 초기화(isTurn=false, dir=0)
                q.offer(next);

                int leftWheel = (i == 0) ? next : now;
                int rightWheel = (i == 0) ? now : next;
                if (turn[now].isTurn && wheels.get(leftWheel)[2] != wheels.get(rightWheel)[6]) {
                    turn[next] = new Turn(true, -turn[now].dir);
                }
            }
        }
        turnWheel(turn);
    }

    private static void turnWheel(Turn[] turn) {
        for (int i = 0; i < 4; i++) {
            if (!turn[i].isTurn) continue;

            int[] wheel = wheels.get(i);

            if (turn[i].dir == -1) { // 반시계 방향 회전
                int tmp = wheel[0];
                for (int j = 1; j < 8; j++) wheel[j - 1] = wheel[j];
                wheel[7] = tmp;
            }

            if (turn[i].dir == 1) { // 시계 방향 회전
                int tmp = wheel[7];
                for (int j = 6; j >= 0; j--) wheel[j + 1] = wheel[j];
                wheel[0] = tmp;
            }
        }
    }

}