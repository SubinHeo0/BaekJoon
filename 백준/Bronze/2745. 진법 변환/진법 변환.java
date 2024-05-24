import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        int sum = 0;
        for (int i = N.length() - 1; i >= 0; i--) { // 몇 승
            int idx = N.length() - 1 - i; // N의 왼쪽부터
            char c = N.charAt(idx);
            if ('A' <= c && c <= 'Z') {
                sum += (c - 'A' + 10) * Math.pow(B, i); // 10부터 A이기 때문에 10을 더해줌
            } else {
                sum += (c - '0') * Math.pow(B, i);
            }
        }

        System.out.println(sum);

    }
}