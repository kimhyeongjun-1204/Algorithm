import java.util.Scanner;

public class Main {
    static int N;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        int[] board = new int[N]; // 각 행별 퀸의 열 위치 정보를 저장함.

        solveNQueen(board, 0);

        System.out.println(count);
    }

    static void solveNQueen(int[] board, int row) {
        if(row == N) {
            count++; return;
        }

        for(int cols=0;cols<N;cols++) {
            if(isSafe(board, row, cols)) {
                board[row] = cols;
                solveNQueen(board, row + 1);
            }
        }
    }

    static boolean isSafe(int[] board,int row, int col) {
        for(int i=0; i<row;i++) {
            if(board[i] == col || Math.abs(row - i) == Math.abs(col - board[i])) {
                return false;
            }
        }

        return true;
    }

}
