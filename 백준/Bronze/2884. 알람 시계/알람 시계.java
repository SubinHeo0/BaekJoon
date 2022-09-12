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

        int hour = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());

        if (min - 45 < 0) {
            hour -= 1;
            if (hour < 0) {
                hour = 23;
            }
            min = 60 - 45 + min;
        } else {
            min -= 45;
        }

        bw.write(hour + " " + min);

        br.close();
        bw.flush();
        bw.close();

    }
}
