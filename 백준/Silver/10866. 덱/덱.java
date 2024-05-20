import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    private static LinkedList<Integer> deque = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push_front" -> pushFront(Integer.parseInt(st.nextToken()));
                case "push_back" -> pushBack(Integer.parseInt(st.nextToken()));
                case "pop_front" -> bw.write(popFront() + "\n");
                case "pop_back" -> bw.write(popBack() + "\n");
                case "size" -> bw.write(size() + "\n");
                case "empty" -> bw.write(empty() + "\n");
                case "front" -> bw.write(front() + "\n");
                case "back" -> bw.write(back() + "\n");
            }
        }

        bw.flush();

    }

    private static void pushFront(int num) {
        deque.addFirst(num);
    }

    private static void pushBack(int num) {
        deque.addLast(num);
    }

    // 가장 앞에 있는 정수 출력 및 삭제
    private static int popFront() {
        if (deque.isEmpty()) return -1;
        return deque.pollFirst();
    }

    private static int popBack() {
        if (deque.isEmpty()) return -1;
        return deque.pollLast();
    }

    private static int size() {
        return deque.size();
    }

    private static int empty() {
        if (deque.isEmpty()) return 1;
        return 0;
    }

    // 덱의 가장 앞에 있는 정수 출력
    private static int front() {
        if (deque.isEmpty()) return -1;
        return deque.peekFirst();
    }

    // 가장 뒤에 있는 정수 출력
    private static int back() {
        if (deque.isEmpty()) return -1;
        return deque.peekLast();
    }
}