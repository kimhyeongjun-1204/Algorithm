import java.util.HashSet; 
import java.lang.Math;

class Solution {
    public void cal(int[] answer, int zero, int correct) {
        int maxRate = 7 - Math.min(6,zero+correct),
            minRate = 7 - correct; 
        
        maxRate = Math.min(maxRate,6); 
        minRate = Math.min(minRate,6); 
        
        answer[0] = maxRate; 
        answer[1] = minRate; 
    }
    
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        HashSet<Integer> lotto = new HashSet<>(); 
        int zero = 0,   // 지워진 갯수 
            correct = 0; // 일치 갯수  
        
        for(int lo : lottos) {
            if(lo == 0) {
                zero++; 
            }else {
                lotto.add(lo); 
            }
        }
        
        for(int win : win_nums) {
            if(lotto.contains(win)) {
                correct++; 
            }
        }
        
        cal(answer,zero,correct); 
        
        return answer;
    }
}