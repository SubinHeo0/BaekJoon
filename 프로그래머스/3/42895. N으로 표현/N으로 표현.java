import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int N, int number) {
        int answer = -1;
        
        Set<Integer>[] setArr = new Set[9];
        int tmp = N;
        for(int i=1; i<9; i++){ // 1~8까지 바구니 초기화 | 각 바구니에는 i개의 N이 이어져 들어가있음 -> N, NN, NNN
            setArr[i] = new HashSet<>();
            setArr[i].add(tmp);
            tmp = tmp * 10 + N;
        }
        
        for(int i=1; i<9; i++){ // 1번 바구니부터 연산값 채움
            for(int j=1; j<i; j++){ // i번째 바구니를 채우기 위해 필요한 두 바구니의 값 차
                for(Integer a : setArr[j]){
                    for(Integer b : setArr[i-j]){
                        setArr[i].add(a + b);
                        setArr[i].add(a - b);
                        setArr[i].add(a * b);
                        if(b != 0) setArr[i].add(a / b);
                    }
                }
            }
        }
        
        for(int i=1; i<9; i++){ // 바구니를 탐색하며 바구니 안에 number에 해당하는 연산값이 있으면 바구니값 리턴
            if(setArr[i].contains(number)) return i;
        }
        
        return answer;
    }
}