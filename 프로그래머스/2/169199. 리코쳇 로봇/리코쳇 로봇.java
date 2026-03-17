import java.util.*;

class Solution {
    static int[][] direct = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static int R, C;
    static boolean[][] map;

    public int solution(String[] board) {
        R = board.length;
        C = board[0].length();
        int sr = 0, sc = 0, er = 0, ec = 0;

        map = new boolean[R][C];

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                char ch = board[r].charAt(c);
                switch (ch) {
                    case 'G':
                        er = r; ec = c;
                        map[r][c] = true;
                        break;
                    case 'R':
                        sr = r; sc = c;
                        map[r][c] = true;
                        break;
                    case '.':
                        map[r][c] = true;
                        break;
                }
            }
        }

        // BFS
        boolean[][] visited = new boolean[R][C];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{sr, sc, 0});
        visited[sr][sc] = true;

        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            int nowR = info[0], nowC = info[1], total = info[2];

            if (nowR == er && nowC == ec) return total;

            for (int i = 0; i < 4; i++) {
                int nextR = nowR, nextC = nowC;

                // 벽이나 장애물에 부딪힐 때까지 미끄러짐
                while (true) {
                    int nr = nextR + direct[i][0];
                    int nc = nextC + direct[i][1];
                    if (nr < 0 || nr >= R || nc < 0 || nc >= C) break;
                    if (!map[nr][nc]) break;
                    nextR = nr;
                    nextC = nc;
                }

                if (!visited[nextR][nextC]) {
                    visited[nextR][nextC] = true;
                    queue.add(new int[]{nextR, nextC, total + 1});
                }
            }
        }

        return -1;
    }
}