import java.util.ArrayList; 
class Solution {
    public int solution(int[][] board, int[] moves) {
        // board => 맵 , moves 작동 위치 열 : -1 
        // 같으면 사라짐. 
        
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();         
        
        for(int col : moves) {
            col--; 
            
            for(int row=0;row<board.length;row++) {
                int num = board[row][col]; 
                
                if(num != 0) {
                    // System.out.println("넣을려는 인형 : " + num); 
                    
                    // List의 마지막 인형과 같은지 비교 
                    if(!list.isEmpty()) {
                        if(num == list.get(list.size()-1)) {
                            list.remove(list.size()-1); 
                            answer += 2;
                            board[row][col] = 0; 
                            break; 
                        }
                    }
                    // 인형이 마지막 인형과 다르다면 
                    list.add(num);
                    board[row][col] = 0; 
                    break;
                }
                
                // for(int i=0;i<list.size();i++) {
                //     System.out.print(list.get(i) + " "); 
                // }
                // System.out.println(); 
            }
        }
                
        return answer;
    }
}