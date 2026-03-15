import java.util.*; 

class Solution {
    public int[] solution(int[] sequence, int k) {
        // 큐 
        Queue<Integer> queue = new ArrayDeque<>(); 
        
        int sum = 0; 
        int minLen = sequence.length+1; 
        int st =0, end = 0; 
        
        for(int i=0;i<sequence.length;i++) {
            queue.add(i); 
            sum += sequence[i];
            
            if(sum > k) {
                while(sum > k) {
                    int idx = queue.poll(); 
                    sum -= sequence[idx]; 
                }
            }
            
            if(sum == k) {
                int len = i-queue.peek()+1;
                if(len < minLen) {
                    minLen = len; 
                    st = queue.peek(); 
                    end = i; 
                }
            }
        }
        
        
        return new int[]{st, end};
    }
}