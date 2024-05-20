import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static List<Integer> stack = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push" -> push(Integer.parseInt(st.nextToken()));
                case "pop" -> bw.write(pop() + "\n");
                case "size" -> bw.write(size() + "\n");
                case "empty" -> bw.write(empty() + "\n");
                case "top" -> bw.write(top() + "\n");
            }
        }

        bw.flush();

    }

    private static void push(int num) {
        stack.add(num);
    }

    private static int pop() {
        if (stack.isEmpty()) return -1;

        int top = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return top;
    }

    private static int size() {
        return stack.size();
    }

    private static int empty() {
        if (stack.isEmpty()) return 1;
        return 0;
    }

    private static int top() {
        if (stack.isEmpty()) return -1;
        return stack.get(stack.size() - 1);
    }
}