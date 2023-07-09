import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    // 분할 및 요소가 1개남으면 그때부터 합병수행
    public static void mergeSort(int[] array) {
        if (array.length > 1) {
            int middle = array.length / 2;

            int[] left = new int[middle];
            for (int i = 0; i < left.length; i++) {
                left[i] = array[i];
            }

            int[] right = new int[array.length - middle];
            for (int i = 0; i < right.length; i++) {
                right[i] = array[middle];
                middle++;
            }

            mergeSort(left);
            mergeSort(right);

            // 합병
            merge(array, left, right);

        }
    }

    // 합병
    public static void merge(int[] array, int[] left, int[] right) {
        int l = 0, r = 0; // left, right 인덱스
        int i = 0; // array 인덱스

        while (l < left.length && r < right.length) {
            if (left[l] < right[r]) {
                array[i] = left[l];
                l++;
            } else {
                array[i] = right[r];
                r++;
            }
            i++;
        }

        // 하나의 배열은 끝까지 다 돌았는데 left 또는 right에서 요소가 남았을 때
        // 남은 요소들은 그대로 array에 추가
        if (l < left.length) {
            for (int k = l; k < left.length; k++) {
                array[i] = left[k];
                i++;
            }
        }
        if (r < right.length) {
            for (int k = r; k < right.length; k++) {
                array[i] = right[k];
                i++;
            }
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        int input = Integer.parseInt(br.readLine());
        int[] array = new int[input];
        for (int i = 0; i < input; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        // 합병정렬
        mergeSort(array);

        // 실행
        for(int i=0; i<array.length; i++){
            bw.write(array[i]+"\n");
        }

        br.close();
        bw.flush();
        bw.close();

    }

}
