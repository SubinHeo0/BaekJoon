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

        int line = Integer.parseInt(br.readLine());
        char star = '*';

        for (int i = 0; i < line; i++) {
            for (int j = 0; j <= i; j++) {
                bw.write(star);
            }
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();

    }
}
