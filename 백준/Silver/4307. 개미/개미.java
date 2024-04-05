import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int totalMin = 0; // 개미들의 최솟값 중 가장 최댓값
            int totalMax = 0;
            for (int j = 0; j < n; j++) {
                int ant = Integer.parseInt(br.readLine());

                int antMin = Math.min(ant, Math.abs(ant - l)); // 해당 개미의 최솟값
                int antMax = Math.max(ant, Math.abs(ant - l)); // 해당 개미의 최댓값

                totalMin = Math.max(totalMin, antMin);
                totalMax = Math.max(totalMax, antMax);

            }
            sb.append(totalMin).append(" ").append(totalMax).append("\n");
        }

        System.out.println(sb);

    }
}