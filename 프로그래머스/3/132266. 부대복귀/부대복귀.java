import java.util.*; 

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        // roads : 왕복 길 정보 | sources : 출발 지역 | destination : 도착지. 
//      bfs 
        
        List<Integer>[] graph = new ArrayList[n+1]; 
        
        for(int i=1;i<=n;i++) {
            graph[i] = new ArrayList<>(); 
        }
        
        for(int[] road : roads) {
            int r1 = road[0],
                r2 = road[1]; 
            
            graph[r1].add(r2);
            graph[r2].add(r1);
        }
        
        int[] distance = new int[n+1]; 
        Arrays.fill(distance,-1); 
        distance[destination] = 0; 

        Queue<Integer> queue = new ArrayDeque(); 
        
        int now = destination;
        queue.add(now); 
        while(!queue.isEmpty()) {
            now = queue.poll(); 
            
            for(Integer mo : graph[now]) {
                if(distance[mo] == -1) {
                    distance[mo] = distance[now]+1; 
                    queue.add(mo);
                }                                                
            }
        }
        
        int i=0; 
        for(int source : sources) {
            answer[i++] = distance[source];
        }
        
        return answer;
    }
}