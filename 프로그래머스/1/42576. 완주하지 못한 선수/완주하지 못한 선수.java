import java.util.HashMap; 

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String,Integer> parti = new HashMap<>(); 
        
        for(String p : participant) {
            int value =1; 
            if(parti.containsKey(p)) {
                value = parti.get(p)+1; 
            }
            parti.put(p,value); 
        }
        
        for(String c : completion) {
            parti.put(c, parti.get(c)-1); 
        }
        
        for(String k : parti.keySet()) {
            if(parti.get(k) > 0) {
                answer = k;
                break;
            }
        }
        
        
        return answer;
    }
}