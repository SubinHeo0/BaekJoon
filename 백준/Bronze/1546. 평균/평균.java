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

        int n = Integer.parseInt(br.readLine());
        Double[] origin = new Double[n];
        double max = 0;
        double sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < origin.length; i++) {
            origin[i] = Double.valueOf(st.nextToken());
            if (origin[i] > max) {
                max = origin[i];
            }
        }

        for (int i = 0; i < origin.length; i++) {
            origin[i] = origin[i] / max * 100;
            sum += origin[i];
        }

        bw.write(Double.toString(sum / n));

        br.close();
        bw.flush();
        bw.close();

    }
}
