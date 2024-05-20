import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();

        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < input.length(); j++) {
                sb.append(input.charAt(j));
            }
            list.add(sb);
        }

        Collections.sort(list);
        for (StringBuilder sb : list) {
            bw.write(sb + "\n");
        }

        bw.flush();

    }
}