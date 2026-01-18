import java.util.HashSet; 
class Solution {
    
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        // skip 문자 설정 
        HashSet<Character> skips = new HashSet<>(); 
        for(int i=0;i<skip.length();i++) {
            skips.add(skip.charAt(i)); 
        }
     
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            
            int cnt = 0; 
            while(cnt < index) {
                ch = (char)('a' + (ch - 'a' + 1) % 26); // a => b => c => d 1번 
                if(!skips.contains(ch)) cnt++;
                // System.out.println("ch : " + ch + " cnt : " + cnt );
            }
            answer += ch; 
        }        
        
        
            
        return answer;
    }
}