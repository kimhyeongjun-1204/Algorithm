import java.util.*; 

class Solution {
    public int solution(String[] words) {
        int answer = 0;
        
        Arrays.sort(words);         
        
        for(int i=0;i<words.length;i++) {
            int max = 0; 
            if(i != words.length-1) {
                max = Math.max(max , compare(words[i], words[i+1])); 
            }
            
            if(i != 0) {
                max = Math.max(max , compare(words[i], words[i-1])); 
            }
            answer += max; 
        }
        
        return answer;
    }
    
    int compare(String target, String com) {
        for(int i=0;i<target.length();i++) {
            if(com.length() <= i) return i+1;
            if(target.charAt(i) != com.charAt(i)) {
                return i+1; 
            }
        }
        return target.length();         
    }
    
}
    
