import java.util.*; 

class Solution {
    String target;
    ArrayList<String> list = new ArrayList<>(); 
    Queue<Alpha> queue = new ArrayDeque<>(); 
    
    int answer = 0; 
    
    public int solution(String begin, String target, String[] words) {
        this.target = target; 
        
        for(String word : words) {
            list.add(word); 
        }
        
        queue.add(new Alpha(begin, 0)); 
        
        while(!queue.isEmpty()) {
            Alpha now = queue.poll(); 
            if(now.str.equals(target)) {answer = now.level; break;}
            
            for(int i=0;i<list.size();i++) {
                String next = list.get(i); 

                if(canConvert(now.str, next)) {
                    queue.add(new Alpha(next, now.level+1)); 
                    list.remove(next);
                    i--; 
                }
            }
        }
        
        return answer;
    }
    
    class Alpha {
        String str; 
        int level; 
        
        Alpha(String str, int level) {
            this.str = str; 
            this.level = level; 
        }
    }
    
    boolean canConvert(String now, String next) {
        int diff = 0; 
        
        for(int i=0;i<now.length();i++) {
            if(now.charAt(i) != next.charAt(i)) diff++; 
            if(diff > 1) return false; 
        }
        
        return true; 
    }
}