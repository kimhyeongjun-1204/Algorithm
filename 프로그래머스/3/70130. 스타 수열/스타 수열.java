import java.util.*; 

class Solution {
    int[] a; 
    
    public int solution(int[] a) {
        int answer = 0;
        this.a = a;  
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : a) {
            map.put(num , map.getOrDefault(num , 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>(map.keySet()); 
        list.sort((x,y) -> map.get(y) - map.get(x)); 
        
        for(int target : list) {
            if(map.get(target)*2 <= answer) break; 
            
            answer = Math.max(answer, findStar(target));
        }
        
        return answer;
    }
    
    int findStar(int contain) {
        boolean hasC = false;
        boolean other = false; 
        int count = 0; 
        for(int i=0;i<a.length;i++) {
            if(a[i] == contain) {
                if(other) {
                    count++; 
                    other = false;
                    continue;
                }
                hasC = true; 
            }else {
                if(hasC) {
                    count++; 
                    hasC = false;
                    continue;
                }
                other = true;
            }
        }
        
        return count * 2; 
    }
    
}