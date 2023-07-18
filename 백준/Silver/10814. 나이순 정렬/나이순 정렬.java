import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        String[][] people = new String[num][2];

        for (int i = 0; i < people.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            people[i][0] = st.nextToken();
            people[i][1] = st.nextToken();
        }

        Arrays.sort(people, (e1, e2)->{ // 리턴값이 양수면 자리바뀜
            return Integer.parseInt(e1[0])-Integer.parseInt(e2[0]);
        });
        

        // 출력
        for (int i = 0; i < people.length; i++) {
            bw.write(people[i][0] + " " + people[i][1] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();

    }

}
