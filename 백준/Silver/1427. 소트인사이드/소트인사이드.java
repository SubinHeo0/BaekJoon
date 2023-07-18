import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        String[] arr = input.split(""); // 한글자씩 잘라서 배열만듦

        // 내림차순정렬(2가지 방법)
        // (1)
        // Arrays.sort(arr, new Comparator<String>() {
        //     public int compare(String e1, String e2) {
        //         return Integer.parseInt(e2) - Integer.parseInt(e1);
        //     }
        // });

        // (2)
        Arrays.sort(arr, Collections.reverseOrder());

        // 출력
        for (String str : arr) {
            bw.write(str);
        }

        br.close();
        bw.flush();
        bw.close();

    }

}
