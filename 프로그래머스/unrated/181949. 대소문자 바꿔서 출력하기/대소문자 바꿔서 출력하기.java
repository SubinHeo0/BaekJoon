import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        char[] alphabet = a.toCharArray();

        for(int i=0; i<alphabet.length; i++){
            if(65 <= alphabet[i] && alphabet[i] <= 90){ // 대문자면 소문자로 변환
                alphabet[i] += 32;
                continue;
            }
            if(97 <= alphabet[i] && alphabet[i] <= 122){ // 소문자면 대문자로 변환
                alphabet[i] -= 32;
            }
        }

        for (char c : alphabet) {
            System.out.print(c);
        }
    }
}