import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < cnt; i++) { // 공백
            for (int j = 0; j < i; j++) {
                bw.write(" ");
            }
            for (int j = 0; j < cnt * 2 - i * 2 - 1; j++) {
                bw.write("*");
            }
            bw.write("\n");
        }

        for (int i = cnt - 2; i >= 0; i--) { // 공백
            for (int j = 0; j < i; j++) {
                bw.write(" ");
            }
            for (int j = 0; j < (cnt * 2 - 1) - (i * 2); j++) {
                bw.write("*");
            }
            bw.write("\n");
        }


        bw.flush();

    }
}