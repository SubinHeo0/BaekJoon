import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        if (N == 0) {
            System.out.println(0);
            return;
        }

        while (N != 0) {
            list.add(Math.abs(N % -2));
            N = (int) Math.ceil((double) N / -2);
        }

        Collections.reverse(list);
        for (int n : list) {
            sb.append(n);
        }

        System.out.println(sb);

    }
}