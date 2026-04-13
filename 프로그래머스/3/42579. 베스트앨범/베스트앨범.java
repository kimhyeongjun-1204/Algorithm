import java.util.*; 

class Solution {
    public ArrayList solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>(); 
        
        ArrayList<String> list = new ArrayList<>();  
        ArrayList<Integer> sum = new ArrayList<>();  
        PriorityQueue<int[]> pqG = new PriorityQueue<>((a,b) -> b[1]-a[1]); 
        ArrayList<PriorityQueue<int[]>> pqS = new ArrayList<>(); 
        
        
        for(int i=0;i<plays.length;i++) {
            String genre = genres[i]; 
            int play = plays[i];
            
            if(!list.contains(genre)) {
                list.add(genre); 
                sum.add(0); 
                pqS.add(new PriorityQueue<>((a,b) -> b[1] - a[1]));
            }
            
            int idx = list.indexOf(genre); 
            pqS.get(idx).add(new int[]{i, play}); 
            sum.set(idx, sum.get(idx) + play); 
        }
        
        for(int i=0;i<sum.size();i++) {
            pqG.add(new int[]{i, sum.get(i)});
        }
        
        while(!pqG.isEmpty()) {
            int[] g = pqG.poll(); 
            int idx = g[0];
            
            answer.add(pqS.get(idx).poll()[0]); 
            if(!pqS.get(idx).isEmpty()) 
                answer.add(pqS.get(idx).poll()[0]); 
        }
        
        return answer;
    }
}