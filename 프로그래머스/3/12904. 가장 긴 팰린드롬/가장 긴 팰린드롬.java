class Solution
{
    public int solution(String s)
    {
        int answer = 1;
        
        for(int i=0;i<s.length()-1;i++) {
            int palin = 1;
            int len = 0; 
            int le = i , ri = i+1; 
            
            while(true) { // abba     
                if(ri >= s.length() || le < 0) break; 
                if(s.charAt(le) != s.charAt(ri)) break; 
                le--; ri++; 
                len +=2; 
            } 
            answer = Math.max(answer, len); 

            if(i ==0) continue; 
            
            len = 1; 
            while(true) { // abcba
                if(i+palin >= s.length() || i-palin < 0) break; 
                if(s.charAt(i+palin) != s.charAt(i-palin)) break; 
                palin++; 
                len +=2; 
            }
            
            answer = Math.max(answer, len); 
            
        }
        
        return answer;
    }
}