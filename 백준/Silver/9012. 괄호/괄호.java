import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char[] input = st.nextToken().toCharArray();

            Stack<Character> stack = new Stack<>();
            String answer = "YES";
            for (char c : input) {
                if (c == '(') stack.push(c);
                else {
                    if (stack.isEmpty()) {
                        answer = "NO";
                        break;
                    } else stack.pop();
                }
            }
            if (!stack.isEmpty()) answer = "NO";
            bw.write(answer + "\n");
        }

        bw.flush();

    }
}