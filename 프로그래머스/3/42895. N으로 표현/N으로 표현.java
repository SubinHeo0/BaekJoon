import java.util.Set;
import java.util.HashSet;
class Solution {
    public int solution(int N, int number) {
        int answer = -1;
        
        Set<Integer>[] set = new Set[9];
        int tmp = N;
        for(int i=1; i<9; i++){ // 바구니 초기화
            set[i] = new HashSet<>();
            set[i].add(tmp);
            tmp = tmp * 10 + N;
        }
        
        for(int i=1; i<9; i++){
            for(int j=1; j<i; j++){
                for(Integer a : set[j]){
                    for(Integer b : set[i-j]){
                        set[i].add(a + b);
                        set[i].add(a - b);
                        set[i].add(a * b);
                        if(b != 0) set[i].add(a / b);
                    }
                }
            }
        }
        
        for(int i=1; i<9; i++){
            if(set[i].contains(number)) return i;
        }
        
        return answer;
    }
}