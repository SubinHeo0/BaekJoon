import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int line = Integer.parseInt(br.readLine());

        // i가 1일 때 반복문4번 돌면서 공백출력 반복문1번 돌면서 별출력
        // i가 2일 때 3 2
        // i가 3일 때 2 3
        // i가 4일 때 1 4
        // i가 5일 때 0 5
        for (int i = 1; i <= line; i++) {
            for (int j = 1; j <= line - i; j++) {
                bw.write(" ");
            }
            for (int k = 1; k <= i; k++) {
                bw.write("*");
            }
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();

    }
}
