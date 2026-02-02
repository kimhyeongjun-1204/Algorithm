import java.util.*; 
import java.lang.*; 


class Solution {
    public int solution(int[][] scores) {
        int answer = 0;
        int[] wan = scores[0]; 
        int wanScore = wan[0] + wan[1]; 
        
        Arrays.sort(scores, (a,b) -> {
            if(a[0] == b[0]) return a[1] - b[1];    
            return b[0] - a[0];    
        });         
            
        int maxScore = 0; 
        int rank = 1; 
        
        
        for(int[] score : scores) {
            if(score[0] == wan[0] && score[1] == wan[1] && score[1] < maxScore) return -1;
            if(score[1] < maxScore) continue; 
            maxScore = Math.max(maxScore, score[1]); 
            if(score[0]+score[1] > wanScore) rank++; 
        }
        
        
        return rank;
    }
    
}