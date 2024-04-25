import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        char star = '*';
        for (int i = 1; i <= cnt; i++) {
            for (int j = 0; j < i; j++) {
                bw.write(star);
            }
            bw.write("\n");
        }

        bw.flush();

    }
}