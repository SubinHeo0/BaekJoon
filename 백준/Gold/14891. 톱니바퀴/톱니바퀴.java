import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static List<int[]> wheels = new ArrayList<>();

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
        int[] direction = new int[4];
        direction[num] = dir;

        // 왼쪽 톱니바퀴
        for (int i = num - 1; i >= 0; i--) {
            if (wheels.get(i)[2] != wheels.get(i + 1)[6]) direction[i] = -direction[i + 1];
            else break;
        }

        // 오른쪽 톱니바퀴
        for (int i = num + 1; i < 4; i++) {
            if (wheels.get(i)[6] != wheels.get(i - 1)[2]) direction[i] = -direction[i - 1];
            else break;
        }

        // 회전
        for (int i = 0; i < 4; i++) {
            if (direction[i] != 0) turn(i, direction[i]);
        }
    }

    private static void turn(int num, int dir) {
        int[] wheel = wheels.get(num);
        if (dir == -1) { // 반시걔 방향 회전
            int tmp = wheel[0];
            for (int i = 1; i < 8; i++) wheel[i - 1] = wheel[i];
            wheel[7] = tmp;
        }
        if (dir == 1) { // 시계 방향 회전
            int tmp = wheel[7];
            for (int i = 6; i >= 0; i--) wheel[i + 1] = wheel[i];
            wheel[0] = tmp;
        }
    }


}