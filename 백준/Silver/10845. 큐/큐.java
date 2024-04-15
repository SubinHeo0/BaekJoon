import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static List<Integer> queue = new ArrayList<>();
    private static int lt = 0;
    private static int rt = -1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push" -> push(Integer.parseInt(st.nextToken()));
                case "pop" -> bw.write(pop() + "\n");
                case "size" -> bw.write(size() + "\n");
                case "empty" -> bw.write(empty() + "\n");
                case "front" -> bw.write(front() + "\n");
                case "back" -> bw.write(back() + "\n");
            }
        }

        bw.flush();

    }

    private static void push(int num) {
        rt++;
        queue.add(num);
    }

    private static int pop() {
        if (empty() == 1) return -1;
        int num = queue.get(lt);
        lt++;
        return num;
    }

    private static int size() {
        return rt - lt + 1;
    }

    private static int empty() {
        if (size() > 0) return 0;
        return 1;
    }

    private static int front() {
        if (empty() == 1) return -1;
        return queue.get(lt);
    }

    private static int back() {
        if (empty() == 1) return -1;
        return queue.get(rt);
    }
}
