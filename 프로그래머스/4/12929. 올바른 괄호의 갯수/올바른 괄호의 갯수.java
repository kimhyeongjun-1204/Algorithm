class Solution {
    int answer = 0; 
    
    public int solution(int n) {
        answer = 0;
        
        dfs(n, n);        
        
        
        return answer;
    }
    
    void dfs(int le , int ri) {
        if(le == 0 && ri >= 0) {answer++; return;}
        if(le > 0 && ri == 0) return; 
        if(le > ri) return; 
        
        dfs(le-1, ri); 
        dfs(le, ri-1); 
    }
}