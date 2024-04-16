import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        // 오름차순 정렬
        Collections.sort(list);

        List<Integer> max = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            if (list.contains(list.get(i))) cnt++;
            if (list.contains(list.get(i) + 1)) cnt++;
            if (list.contains(list.get(i) + 2)) cnt++;
            if (list.contains(list.get(i) + 3)) cnt++;
            if (list.contains(list.get(i) + 4)) cnt++;
            max.add(cnt);
        }
        Collections.sort(max, Collections.reverseOrder());
        System.out.println(5 - max.get(0));

    }
}
