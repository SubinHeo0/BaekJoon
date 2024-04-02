class Solution {
    
    private int answer = -1;
    
    public int solution(int N, int number) {

        dfs(N, number, 0, 0);
        
        return answer;
    }
    
    private void dfs(int N, int number, int sum, int count){
        if(count > 8) return;
        
        if(sum == number){
            if(count < answer || answer == -1) answer = count;    
        }
        
        int tmpN = 0;
        for(int i=1; i<9; i++){
            tmpN = tmpN * 10 + N;
            dfs(N, number, sum + tmpN, count+i);
            dfs(N, number, sum - tmpN, count+i);
            dfs(N, number, sum * tmpN, count+i);
            dfs(N, number, sum / tmpN, count+i);
        }
        
    }
    
}