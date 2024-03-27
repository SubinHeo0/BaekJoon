import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] S = br.readLine().split("");
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length; i++) {
            if (i == 0) {
                map.put(S[i], 1);
                continue;
            }
            if (!S[i].equals(S[i - 1])) {
                map.put(S[i], map.getOrDefault(S[i], 0) + 1);
            }
        }

        if (map.size() == 1) System.out.println(0);
        else System.out.println(map.get("0") < map.get("1") ? map.get("0") : map.get("1"));

    }
}