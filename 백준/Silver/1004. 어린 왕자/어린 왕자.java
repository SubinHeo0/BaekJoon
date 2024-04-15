import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] s = new int[2];
            s[0] = Integer.parseInt(st.nextToken());
            s[1] = Integer.parseInt(st.nextToken());
            int[] e = new int[2];
            e[0] = Integer.parseInt(st.nextToken());
            e[1] = Integer.parseInt(st.nextToken());

            int cnt = Integer.parseInt(br.readLine());
            for (int j = 0; j < cnt; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                double r = Double.parseDouble(st.nextToken());

                // 출발점과 원점의 거리, 도착점과 원점의 거리
                double sDistance = Math.sqrt(Math.pow(s[0] - x, 2) + Math.pow(s[1] - y, 2));
                double eDistance = Math.sqrt(Math.pow(e[0] - x, 2) + Math.pow(e[1] - y, 2));
                // 두 점이 한 원에 같이 포함되면 카운트X, 한 점만이 원 안에 포함되어 있어야 카운트
                if ((sDistance < r && eDistance > r) || (sDistance > r && eDistance < r)) answer++;

            }
            bw.write(answer + "\n");
        }

        bw.flush();

    }
}
