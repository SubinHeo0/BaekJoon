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

        StringTokenizer st = new StringTokenizer(br.readLine());

        int score = Integer.parseInt(st.nextToken());

        if (score >= 90) {
            bw.write("A");
        } else if (score >= 80) {
            bw.write("B");
        } else if (score >= 70) {
            bw.write("C");
        } else if (score >= 60) {
            bw.write("D");
        } else {
            bw.write("F");
        }

        br.close();
        bw.flush();
        bw.close();

    }
}
