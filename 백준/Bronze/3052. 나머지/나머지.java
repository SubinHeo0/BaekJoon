import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[10];
        int cnt = 0; // 서로 다른 값 개수
        int tmpCnt = 0;

        for (int i = 0; i < arr.length; i++) {

            arr[i] = Integer.parseInt(br.readLine()) % 42;
            if (i == 0) {
                cnt++;
            } else {
                tmpCnt = 0;
                for (int j = 0; j < i; j++) {
                    if (arr[i] != arr[j]) {
                        tmpCnt++;
                    } else { // 서로 같은 값이 있을때
                        tmpCnt = 0;
                        break;
                    }
                }
                if (tmpCnt > 0) {
                    cnt++;
                }
            } // else

        } // for

        bw.write(cnt + "");

        br.close();
        bw.flush();
        bw.close();

    }
}