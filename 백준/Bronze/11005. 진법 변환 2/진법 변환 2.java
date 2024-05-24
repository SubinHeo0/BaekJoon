import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();

        while (N != 0) {
            stack.push(N % B);
            N /= B;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            int num = stack.pop();
            if (num < 10) sb.append(num);
            else sb.append((char)(num - 10 + 'A'));
        }

        System.out.println(sb);

    }
}