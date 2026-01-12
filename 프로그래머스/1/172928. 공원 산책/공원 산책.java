class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        // park = 공원 | routes = 수행할 명령 
        // routes => N : 위 , S : 아래 , W : 왼쪽 , S : 오른쪽          
        // 1. 시작 좌표 및 map 그리기 

        char[][] map = new char[50][50]; 
        int r = -1, c = -1; // 현재 좌표 
        
        int rows = park.length,
        cols = park[0].length(); 
        

        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                char ch = park[i].charAt(j);
                if(ch == 'S') {
                    r = i;
                    c = j; 
                }
                
                map[i][j] = ch; 
            }
        }
        
//      2. 명령 수행 : 장외 or 장애물 : 명령 X and 원위치 
        for(String order : routes) {
            char direct = order.charAt(0); 
            int move = order.charAt(2) - '0'; 
            
            int nextR = r; 
            int nextC = c; 
            
            int i = 0; 
            for(; i<move;i++) {
                
                switch(direct) {
                    case 'N':
                        nextR--; 
                        break;
                    case 'S':
                        nextR++; 
                        break;
                    case 'W':
                        nextC--;
                        break;
                    case 'E':
                        nextC++;
                        break;
                }
                
                if(nextR < 0 || nextC < 0 || nextR >= rows || nextC >= cols || map[nextR][nextC] == 'X') {
                    break; 
                }
            }
            
            if(i == move) {
                r = nextR; 
                c = nextC;     
            }
        }
        
        answer[0] = r; 
        answer[1] = c; 
        
        return answer;
    }
}