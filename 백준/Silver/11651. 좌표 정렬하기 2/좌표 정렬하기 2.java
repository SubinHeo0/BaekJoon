import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int[][] point = new int[num][2];

        for (int i = 0; i < point.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // x좌표를 y좌표에, y좌표를 x좌표에 저장
            point[i][1] = Integer.parseInt(st.nextToken());
            point[i][0] = Integer.parseInt(st.nextToken());
        }

        // Arrays.sort 람다식이용
        Arrays.sort(point, (e1, e2) -> {
            if (e1[0] == e2[0]) {
                return e1[1] - e2[1];
            } else {
                return e1[0] - e2[0];
            }
        });

        // 출력
        for (int i = 0; i < point.length; i++) {
            // x y 좌표를 다시 원래대로 바꾸어서 출력
            bw.write(point[i][1] + " " + point[i][0] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();

    }

}
