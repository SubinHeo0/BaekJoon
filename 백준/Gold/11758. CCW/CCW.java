import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x3 = Integer.parseInt(st.nextToken());
        int y3 = Integer.parseInt(st.nextToken());

        System.out.println(ccw(x1, y1, x2, y2, x3, y3));

    }

    private static int ccw(int x1, int y1, int x2, int y2, int x3, int y3) {
        int a = x1 * y2 + x2 * y3 + x3 * y1;
        int b = x2 * y1 + x3 * y2 + x1 * y3;

        if (a - b > 0) return 1; // 반시계 방향
        else if (a == b) return 0; // 일직선
        else return -1; // 시계 방향
    }
}
