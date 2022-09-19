import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            char[] ch = new char[str.length()];
            int sum = 0;
            int score = 0;
            for (int j = 0; j < str.length(); j++) {
                ch[j] = str.charAt(j);
                if (ch[j] == 'O') {
                    score++;
                    sum += score;
                } else {
                    score = 0;
                    sum += score;
                }
            }

            bw.write(sum + "\n");

        }

        br.close();
        bw.flush();
        bw.close();

    }
}