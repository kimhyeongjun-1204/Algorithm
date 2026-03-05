class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        // 2554
        
        int quo = storey;
        int remain; 
        
        while(quo != 0) {
            remain = quo % 10; // 4
            quo /= 10; // 255 
            
            if(remain < 5 || (remain == 5 && quo % 10 < 5)) {
                answer += remain; 
            }else {
                answer += 10 - remain;
                quo++; 
            }
        }
        
        return answer;
    }
}