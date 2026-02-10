import java.util.*; 

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        HashMap<String, Integer> index = new HashMap<>(); 
        int[] connect = new int[enroll.length];  
        int[] sum = new int[enroll.length]; 
        
        int i=0; 
        for(String en : enroll) {
            index.put(en, i++); 
        } 
        
        i=0; 
        for(String refer : referral) {
            if(refer.equals("-")) {
                connect[i++] = -1; 
            }else {
                connect[i++] = index.get(refer); 
            }
        }
        
        i=0; 
        for(String sell : seller) {
            int now = index.get(sell);
            int earn = amount[i]*100; // 벌어들인 수익 
            
            while(true) {
                sum[now] += earn - (earn / 10);  
                now = connect[now];
                if(now == -1) break;
                earn = earn / 10; 
            }
            i++; 
        }
        
        
        return sum;
    }
}