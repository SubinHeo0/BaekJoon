import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        // 계수 정렬(Counting Sort)
        int[] arr = new int[10001]; // 입력받은 값 = arr인덱스
        for (int i = 0; i < num; i++) {
            arr[Integer.parseInt(br.readLine())]++;
        }

        // 출력
        for (int i = 0; i < arr.length; i++) {
            int number = arr[i];
            while (number > 0) {
                bw.write(i + "\n");
                number--;
            }
        }

        br.close();
        bw.flush();
        bw.close();

    }

}
