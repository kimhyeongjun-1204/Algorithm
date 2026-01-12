class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int[] server = new int[24];         
        
        int i=0; 
        for(int player : players) {
            if(player >= m * (server[i] + 1)) {
                
//              증설 필요
                int adds = 0; 
                while(true) {
                    if(player < m * (server[i] + adds + 1)) {
                        break;
                    }
                    adds++; 
                }
                
                answer += adds; 
                
//              k시간만큼 유지
                for(int j=0;j<k && (i+j) < 24;j++) {
                    server[i+j] += adds; 
                }
                
            }
            i++; 
        }
        
        return answer;
    }
}