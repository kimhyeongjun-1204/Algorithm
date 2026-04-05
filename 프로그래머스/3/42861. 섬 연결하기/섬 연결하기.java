import java.util.*; 

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;

        ArrayList<ArrayList<int[]>> bridge = new ArrayList<>(); 
        for(int i=0;i<n;i++) {
            bridge.add(new ArrayList<>()); 
        }

        for(int[] cost : costs) {
            int n1 = cost[0], n2 = cost[1]; 
            int co = cost[2]; 
            bridge.get(n1).add(new int[]{n2, co}); 
            bridge.get(n2).add(new int[]{n1, co}); 
        }

        boolean[] visited = new boolean[n];  
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]); 
        pq.add(new int[]{0,0});

        while(!pq.isEmpty()) {
            int[] now = pq.poll(); 
            int node = now[0];
            int co = now[1]; 
            
            if (visited[node]) continue;  // 이 줄 추가
            
            visited[node] = true; 
            answer += co; 

            for(int[] next : bridge.get(node)) {
                if(!visited[next[0]]) {
                    pq.add(new int[]{next[0], next[1]}); 
                }
            }
        }



        return answer;
    }

    boolean visitAll(boolean[] visited) {
        for(boolean v : visited) {
            if(!v) return false; 
        }

        return true; 
    }
}