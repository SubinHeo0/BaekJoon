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
            point[i][0] = Integer.parseInt(st.nextToken());
            point[i][1] = Integer.parseInt(st.nextToken());
        }

        // point[i][0] 과 point[i+1][0] 정렬
        // 만약 두 값이 같다면 point[i][1] 과 point[i+1][1]을 비교하여 정렬
        // 2차원배열을 매개변수로 받는 Arrays.sort에서 T는 int[]
        Arrays.sort(point, new Comparator<int[]>() {
            @Override
            public int compare(int[] e1, int[] e2) {
                if (e1[0] == e2[0]) { // 첫번째 원소가 같다면 두 번째 원소끼리 비교
                    return e1[1] - e2[1];
                } else {
                    return e1[0] - e2[0];
                }
            }
        });

        // 출력
        for (int i = 0; i < point.length; i++) {
            bw.write(point[i][0] + " " + point[i][1] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();

    }

}
