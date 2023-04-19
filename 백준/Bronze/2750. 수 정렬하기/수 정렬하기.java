import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        while(input < 1 || input > 1000){  //1부터 1000사이의 값만 입력받음
            System.out.print("1부터 1000까지의 숫자만 입력가능합니다 : ");
            input = Integer.parseInt(br.readLine());
        }
        
        int data[] = new int[input];
        for(int i=0; i<input; i++){
            data[i] = Integer.parseInt(br.readLine());
        }

        // 선택정렬
        for(int i=0; i<input; i++){
            int min = 9999;
            int minIndex = 0;

            for(int j=i; j<input; j++){ // 배열을 돌면서 작은 값 찾음
                if(data[j] < min) {
                    min = data[j];
                    minIndex = j;
                }
            }

            int tmp = min;
            data[minIndex] = data[i];
            data[i] = tmp;

        }

        for(int i = 0; i<input; i++){
            System.out.println(data[i]);
        }

        br.close();

    }

}
