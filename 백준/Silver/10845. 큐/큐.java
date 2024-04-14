import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> dq = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            if (input.length == 2) { // push, pop
                if (input[0].equals("push")) dq.add(Integer.parseInt(input[1]));
            } else {
                if (input[0].equals("pop")) {
                    if (dq.isEmpty()) bw.write("-1");
                    else bw.write(dq.pop() + "");
                } else if (input[0].equals("size")) bw.write(dq.size() + "");
                else if (input[0].equals("empty")) bw.write((dq.isEmpty()) ? "1" : "0");
                else if (input[0].equals("front")) {
                    if (dq.isEmpty()) bw.write("-1");
                    else bw.write(dq.peekFirst() + "");
                } else {
                    if (dq.isEmpty()) bw.write("-1");
                    else bw.write(dq.peekLast() + "");
                }
                bw.write("\n");
            }
        }

        bw.flush();

    }
}
