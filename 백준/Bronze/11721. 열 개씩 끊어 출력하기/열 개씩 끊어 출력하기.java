import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int cnt = input.length() / 10;
        int last = input.length() % 10;

        for (int i = 0; i < cnt; i++) {
            int start = i * 10;
            for (int j = 0; j < 10; j++) {
                bw.write(input.charAt(start + j));
            }
            bw.write("\n");
        }

        if (last != 0) {
            for (int i = 0; i < last; i++) {
                bw.write(input.charAt(cnt * 10 + i));
            }
        }

        bw.flush();

    }
}