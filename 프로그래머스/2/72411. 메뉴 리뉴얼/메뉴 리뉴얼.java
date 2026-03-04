import java.util.*; 

class Solution {
    public ArrayList<String> solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>(); 
        
        List<HashMap<String , Integer>> comb = new ArrayList<>(); 
        
        for(int i=0;i<course.length;i++) {
            comb.add(new HashMap<>()); 
        }
        
        
        for(String order : orders) {
            char[] arr = order.toCharArray();
            Arrays.sort(arr); 
            
            int i=0; 
            for(int co : course) { 
                avail(arr, new StringBuilder(),0 , co, comb.get(i));
                i++; 
            }
        }
        
        TreeSet<String> tree = new TreeSet<>(); 
        
        for(HashMap<String, Integer> co : comb) {
            int max = 1; 
            
            for(String key : co.keySet()) {
                int value = co.get(key); 
                
                if(max < value) max = value; 
            }
            
            if(max != 1) {
                for(String key : co.keySet()) {
                    int value = co.get(key); 
                
                    if(value == max) tree.add(key);                     
                } 
            }
        }
        
        int len = tree.size(); 
        for(int i=0;i<len;i++) {
            answer.add(tree.pollFirst()); 
        }

        return answer;
    }
    
    void avail(char[] arr, StringBuilder sb, int idx , int num , HashMap<String, Integer> comb) { 
        if(sb.length() == num) {
            // System.out.println(sb); 
            String newSt = sb.toString(); 
            comb.put(newSt , comb.getOrDefault(newSt, 0) + 1); 
            return; 
        }else if(idx >= arr.length) {
            return; 
        }
        
        avail(arr, sb , idx+1, num , comb); 
        sb.append(arr[idx]); 
        avail(arr, sb, idx+1, num, comb); 
        sb.deleteCharAt(sb.length()-1); 
        
        return; 
    }
}