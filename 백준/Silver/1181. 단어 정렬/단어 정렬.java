import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());
        String[] words = new String[input];

        for (int i = 0; i < input; i++) {
            words[i] = br.readLine();
        }

        Arrays.sort(words, new Comparator<String>() {
            public int compare(String s1, String s2) {
                if (s1.length() == s2.length()) {
                // 단어 길이가 같을 경우
                    return s1.compareTo(s2);
                } else {
                    return s1.length() - s2.length();
                }
            }

        });

        // 실행
        // 중복된 입력값은 패스
        bw.write(words[0] + "\n");
        for (int i = 1; i < words.length; i++) {
            if (!words[i].equals(words[i - 1])) {
                bw.write(words[i] + "\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();

    }

}
