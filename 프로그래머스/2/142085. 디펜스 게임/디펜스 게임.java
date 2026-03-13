import java.util.*; 

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = enemy.length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a); 
        
        for(int i=0;i<enemy.length;i++) { // i = 5 
            int ene = enemy[i]; 
            n -= ene; 
            pq.add(ene);                 
            
            while(k>0 && n < 0) {
                n += pq.poll(); 
                k--; 
            }
        
            if(n < 0) {answer = i; break; }
        }
        
        
        return answer;
    }
}