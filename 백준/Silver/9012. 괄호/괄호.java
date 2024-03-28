import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) { // testCase
            String test = br.readLine(); // (())())
            Stack<Character> stack = new Stack<>();
            boolean isYPS = true;
            for (int j = 0; j < test.length(); j++) {
                if (test.charAt(j) == '(') stack.push(test.charAt(j));
                else {
                    if (stack.size() > 0) {
                        stack.pop();
                    } else {
                        isYPS = false;
                        break;
                    }
                }
            }
            if (stack.size() != 0) isYPS = false;

            System.out.println(isYPS ? "YES" : "NO");
        }

    }
}