import java.util.*; 

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        if(n > s) return new int[]{-1};  
        
        int quo = s / n; 
        int remain = s % n; 
        
        Arrays.fill(answer, quo); 
        for(int i=n-remain;i<n;i++) {
            answer[i]++; 
        }
        
        
        
        
        return answer;
    }
}