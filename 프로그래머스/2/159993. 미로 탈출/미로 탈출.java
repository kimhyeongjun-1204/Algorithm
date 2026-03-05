import java.util.*; 

import java.util.*; 

class Solution {
    static boolean[][] map; 
    static int[] start, lever, end; 
    
    public int solution(String[] maps) {
        int answer = 0;
        map = new boolean[maps.length][maps[0].length()]; 
        
        for(int i=0;i<map.length;i++) {
            Arrays.fill(map[i], true);
        }
        
        int i=0; 
        for(String m : maps) {
            for(int j=0;j<m.length();j++) {
                switch(m.charAt(j)) {
                    case 'S':
                        start = new int[]{i,j};
                        break; 
                    case 'E':
                        end = new int[]{i,j};     
                        break; 
                    case 'L':
                        lever = new int[]{i,j}; 
                        break; 
                    case 'O':
                        break; 
                    case 'X':
                        map[i][j] = false; 
                        break; 
                }
            }
            i++; 
        }
        
        int s1 = search(start, lever); 
        int s2 = search(lever, end); 
        if(s1 == -1 || s2 == -1) return -1; 
        
        
        
        // 출발 지점 => 레버 => 미로빠져나가는 문 
        return s1 + s2;
    }
    
    static int search(int[] st, int[] e) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{st[0], st[1], 0}); 
        boolean[][] visited = new boolean[map.length][map[0].length]; 
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            if(now[0] == e[0] && now[1] == e[1]) return now[2]; 
            int[][] move = {{-1,0} , {1,0}, {0,-1}, {0,1}};
            
            for(int i=0;i<4;i++) {
                int r = now[0] + move[i][0]; 
                int c = now[1] + move[i][1]; 
                
                if(r >= 0 && r < map.length && c >= 0 && c < map[0].length) 
                    if(map[r][c] && !visited[r][c] ) {
                        queue.add(new int[]{r, c, now[2] + 1}); 
                        visited[r][c] = true; 
                    }
                
            }
        }
        
        return -1; 
    }
    
}