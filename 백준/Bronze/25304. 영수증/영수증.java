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

        int x = Integer.parseInt(br.readLine());
        int cnt = Integer.parseInt(br.readLine());
        int sum = 0;

        for (int i = 0; i < cnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int price = Integer.parseInt(st.nextToken());
            int item = Integer.parseInt(st.nextToken());
            sum += price * item;
        }

        if (sum == x) {
            bw.write("Yes");
        } else {
            bw.write("No");
        }

        br.close();
        bw.flush();
        bw.close();

    }
}
