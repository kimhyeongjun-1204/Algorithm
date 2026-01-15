class Solution {
    public int[] pad(int n) {
            int[] loc = new int[2]; 
            if(n == 0) {
                loc[0] = 3; loc[1] = 1; 
            }else {
                loc[0] = (n-1) / 3;
                loc[1] = (n-1) % 3; 
            }
            
            return loc; 
    }
    
    public String solution(int[] numbers, String hand) {
        String answer = "";
        //  00 01 02
        //  10 11 12
        //  20 21 22 
        //     31
        
        
        
        // 오른, 왼손 좌표
        int riR = 3, riC = 2, leR = 3, leC = 0; 
        
        for(int n : numbers) {
            int[] next = pad(n); // 다음 이동해야할 좌표 
            
            int nR = next[0], nC = next[1]; 
            System.out.println("n : " + n + " Rows : " + nR + "Cols : " + nC); 
            
            if(nC == 1) {
                int sumR = Math.abs(riR - nR) + Math.abs(riC - nC), 
                sumL = Math.abs(leR - nR) + Math.abs(leC - nC); 
            
                if(sumR < sumL || (sumR == sumL && hand.equals("right"))) {
                    answer += 'R'; 
                    riR = nR; riC = nC; 
                }else{
                    answer += 'L'; 
                    leR = nR; leC = nC; 
                }
            }else {
                if(nC == 0) {
                    answer += 'L'; 
                    leR = nR; leC = nC; 
                }else {
                    answer += 'R'; 
                    riR = nR; riC = nC; 
                }
            }
            
            
            
        }
        
        return answer;
    }
}