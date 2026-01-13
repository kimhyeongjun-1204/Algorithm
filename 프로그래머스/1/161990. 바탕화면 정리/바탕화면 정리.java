import java.lang.Math; 

class Solution {
    int minR,minC,maxR,maxC; 
    
    public int[] solution(String[] wallpaper) {
        minR = minC = 50; 
        maxR = maxC = 0; 
        
        int i = 0; 
        
        for(String w : wallpaper) {
            for(int j=0;j<w.length();j++) {
                if(w.charAt(j) == '#') {
                    maxR = Math.max(i,maxR);
                    maxC = Math.max(j,maxC);
                    minR = Math.min(i,minR);
                    minC = Math.min(j,minC);
                }
            }
            i++;
        }
        return new int[]{minR,minC,maxR+1,maxC+1};
    }
}