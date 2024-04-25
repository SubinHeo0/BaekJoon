import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        for (int i = 1; i <= cnt; i++) { // 1 2 3 4 5
            for (int j = 0; j < i; j++) {
                bw.write("*");
            }
            for (int j = 0; j < cnt * 2 - i * 2; j++) {
                bw.write(" ");
            }
            for (int j = 0; j < i; j++) {
                bw.write("*");
            }
            bw.write("\n");
        }

        for (int i = cnt - 1; i > 0; i--) { // 4 3 2 1
            for (int j = 0; j < i; j++) {
                bw.write("*");
            }
            for (int j = 0; j < cnt * 2 - i * 2; j++) {
                bw.write(" ");
            }
            for (int j = 0; j < i; j++) {
                bw.write("*");
            }
            bw.write("\n");
        }

        bw.flush();

    }
}