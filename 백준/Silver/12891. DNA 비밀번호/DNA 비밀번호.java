import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] myCount = new int[4];
    private static int[] checkCount = new int[4];
    private static int comparison = 0; //4가 되면 모든 조건 만족 => result++

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int inputLength = Integer.parseInt(st.nextToken());
        int pwLength = Integer.parseInt(st.nextToken());
        int result = 0;
        char[] dna = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            checkCount[i] = Integer.parseInt(st.nextToken());
            if (checkCount[i] == 0) comparison++;
        }

        for (int i = 0; i < pwLength; i++) {
            add(dna[i]);
        }

        if (comparison == 4) result++;

        //슬라이딩 윈도우
        for (int endIdx = pwLength; endIdx < inputLength; endIdx++) {
            int startIdx = endIdx - pwLength;
            add(dna[endIdx]);
            remove(dna[startIdx]);
            if (comparison == 4) result++;
        }

        System.out.println(result);
        br.close();

    }

    private static void remove(char c) {
        switch (c) {
            case 'A':
                if (myCount[0] == checkCount[0]) comparison--;
                myCount[0]--;
                break;
            case 'C':
                if (myCount[1] == checkCount[1]) comparison--;
                myCount[1]--;
                break;
            case 'G':
                if (myCount[2] == checkCount[2]) comparison--;
                myCount[2]--;
                break;
            case 'T':
                if (myCount[3] == checkCount[3]) comparison--;
                myCount[3]--;
                break;
        }
    }

    private static void add(char c) {
        switch (c) {
            case 'A':
                myCount[0]++;
                if (myCount[0] == checkCount[0]) comparison++;
                break;
            case 'C':
                myCount[1]++;
                if (myCount[1] == checkCount[1]) comparison++;
                break;
            case 'G':
                myCount[2]++;
                if (myCount[2] == checkCount[2]) comparison++;
                break;
            case 'T':
                myCount[3]++;
                if (myCount[3] == checkCount[3]) comparison++;
                break;
        }
    }

}