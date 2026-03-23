import java.util.*; 
import java.lang.*; 

class Solution {
    int n;
    ArrayList<ArrayList<int[]>> cost; 
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        this.n = n; 
        
        cost = new ArrayList<>(); 
        for(int i=0;i<=n;i++) {
            cost.add(new ArrayList<>()); 
        }
        
        for(int[] fare : fares) {
            int n1 = fare[0] , n2 = fare[1], co = fare[2]; 
            cost.get(n1).add(new int[]{n2, co});
            cost.get(n2).add(new int[]{n1, co});
        }
        
        int[][] goes = new int[3][n+1]; 
        for(int i=0;i<goes.length;i++) {
            Arrays.fill(goes[i], Integer.MAX_VALUE); 
        }
        
        target(s, goes[0]);
        target(a, goes[1]);
        target(b, goes[2]);
        
        int min = Integer.MAX_VALUE; 
        for(int i=1;i<=n;i++) {
            min = Math.min(min, goes[0][i] + goes[1][i] + goes[2][i]);
        }
        
        return min;
    }
    
    void target(int start, int[] go) {
        // 비용 기준 오름차순
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]); 
        pq.add(new int[]{start, 0}); 
        go[start] = 0;
        
        while(!pq.isEmpty()) {
            int[] now = pq.poll(); 
            int node = now[0] , distance = now[1]; 
            
            if(distance > go[node]) continue; 
            
            for(int[] next : cost.get(node)) {
                int nextNode = next[0], weight = next[1];
                if (go[node] + weight < go[nextNode]) {
                    go[nextNode] = go[node] + weight;
                    pq.offer(new int[]{nextNode, go[nextNode]});
                }
            }
        }
        
    }
}