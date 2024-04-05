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

            int min = Integer.MIN_VALUE;
            int max = Integer.MIN_VALUE;

            for (int j = 0; j < n; j++) {
                int ant = Integer.parseInt(br.readLine());

                int antMin = Math.min(ant, l - ant);
                int antMax = Math.max(ant, l - ant);

                min = Math.max(min, antMin);
                max = Math.max(max, antMax);
            }
            sb.append(min).append(" ").append(max).append("\n");
        }

        System.out.println(sb);

    }
}