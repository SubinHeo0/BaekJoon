import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int c = Integer.parseInt(br.readLine());

        for (int i = 0; i < c; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int cnt = Integer.parseInt(st.nextToken()); // 학생수
            int[] score = new int[cnt]; // 학생들의 점수
            int sum = 0; // 점수 합

            for (int j = 0; j < score.length; j++) {
                score[j] = Integer.parseInt(st.nextToken());
                sum += score[j];
            }

            double avg = (double) sum / cnt; // 점수 평균

            int good = 0; // 평균 초과 학생수
            for (int k = 0; k < score.length; k++) {
                if (score[k] > avg) {
                    good++;
                }
            }

            bw.write(String.format("%.3f", 100 * ((double) good / cnt)) + "%\n");

        }

        br.close();
        bw.flush();
        bw.close();

    }
}