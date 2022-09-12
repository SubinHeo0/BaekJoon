import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int money=0;

        if (a == b && b == c) {
            // 같은 눈 3개
            money = 10000 + a * 1000;
        } else if (a != b && a != c && b != c) {
            // 모두 다른 눈 -> 가장 큰 눈
            int tmp = (a > b) ? a : b;
            int big = (tmp > c) ? tmp : c;
            money = big * 100;
        } else {
            // 같은 눈 2개
            int same = (a == b) ? a : c;
            money = 1000 + same * 100;
        }

        bw.write(Integer.toString(money));

        br.close();
        bw.flush();
        bw.close();

    }
}
