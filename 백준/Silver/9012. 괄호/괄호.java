import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String input = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean isVPS = true;
            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == '(') stack.push(input.charAt(j));
                else {
                    if (stack.isEmpty()) {
                        isVPS = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if (!stack.isEmpty()) isVPS = false;
            System.out.println(isVPS ? "YES" : "NO");
        }

    }
}