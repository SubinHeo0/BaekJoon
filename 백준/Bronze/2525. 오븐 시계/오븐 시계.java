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
        int need = Integer.parseInt(br.readLine());
        int totalMin = min + need;

        if (totalMin > 60) {
            hour += totalMin / 60;
            if (hour >= 24) {
                hour -= 24;
            }
            min = totalMin % 60;
        } else if (totalMin < 60) {
            min = totalMin;
        } else {
            // totalMin == 60
            hour += 1;
            if (hour == 24) {
                hour = 0;
            }
            min = 0;
        }

        bw.write(hour + " " + min);

        br.close();
        bw.flush();
        bw.close();

    }
}
