import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 0
        int finalNum = -1;
        int cycle = 0;
        int num = 0;

        while (n != finalNum) {
            if (cycle == 0) {
                num = n;
            } else {
                num = finalNum;
            }
            int first = num / 10;
            int last = num % 10;
            int result = (first + last) % 10;
            // String tmp = "";
            // tmp += last+result;
            // finalNum = Integer.valueOf(tmp); // String이 불변이라 그냥 ""로 출력
            finalNum = Integer.valueOf("" + last + result);
            cycle++;
        }

        bw.write(cycle + "");

        br.close();
        bw.flush();
        bw.close();

    }
}
