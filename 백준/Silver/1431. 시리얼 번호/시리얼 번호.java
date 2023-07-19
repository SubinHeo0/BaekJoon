import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    
    // 문자열 안의 수의 합을 구하는 함수
    public static int getSum(String str) {
        int length = str.length();
        char[] strArr = str.toCharArray();
        int sum = 0;
        for (int i = 0; i < length; i++) {
            // 숫자인 경우에만 더하기
            if (0 <= strArr[i] - '0' && strArr[i] - '0' <= 9) {
                sum += strArr[i] - '0';
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        String[] serial = new String[num];
        for (int i = 0; i < serial.length; i++) {
            serial[i] = br.readLine();
        }

        // 정렬
        Arrays.sort(serial, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) { // 리턴값이 양수면 자리바꿈
                // 길이가 다를 땐 => 짧은 것부터
                if (str1.length() < str2.length()) return -1;
                else if (str1.length() > str2.length()) return 1;
                // 길이가 같을 땐 => 수의 합을 비교해서 작은 것부터
                // 수의 합을 비교했는데도 그 합이 같다면 사전순
                else {
                    int str1Sum = getSum(str1);
                    int str2Sum = getSum(str2);
                    if (str1Sum < str2Sum) return -1;
                    else if (str1Sum > str2Sum) return 1;
                    else return str1.compareTo(str2);
                }
            }
        });

        // 출력
        for (String str : serial) {
            bw.write(str + "\n");
        }

        br.close();
        bw.flush();
        bw.close();

    }

}
