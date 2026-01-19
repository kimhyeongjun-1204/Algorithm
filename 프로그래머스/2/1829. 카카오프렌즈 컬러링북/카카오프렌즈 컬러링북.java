import java.util.*; 
import java.lang.Math;
class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0; // 영역의 개수 
        int maxSizeOfOneArea = 0; // 가장 큰 영역의 넓이 
        int[][] move = {{-1,0},
                        {1,0},
                        {0,-1},
                        {0,1}};
        
        Queue<int[]> queue = new ArrayDeque<>(); 
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(picture[i][j] == 0) continue; 
                numberOfArea++;                 
                
                int num = picture[i][j]; 
                int areaSize = 0; 
                
                picture[i][j] = 0; 
                queue.add(new int[]{i,j});
                while(!queue.isEmpty()){
                    int[] current = queue.poll(); 
                        
                    for(int mo=0;mo<4;mo++) {
                        int r = current[0] + move[mo][0],
                            c = current[1] + move[mo][1]; 
                        
                        if(r < 0 || c < 0 || r >= m || c >= n) continue; 
                        if(picture[r][c] == num) {
                            queue.add(new int[]{r,c}); 
                            picture[r][c] = 0; 
                        }
                    }
                    
                    areaSize++; 
                }
                
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea , areaSize);
            }
        }
        
        
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}