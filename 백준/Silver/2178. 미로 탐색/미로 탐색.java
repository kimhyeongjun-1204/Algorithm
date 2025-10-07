import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static Deque<Point> deque = new ArrayDeque<>();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N,M;

    public static void main(String[] args) throws IOException {
        /* 과정 1 : 사용자 입력 받기 */

//      한줄 입력
        BufferedReader br;
//      구분자를 기준으로 토큰 입력
        StringTokenizer st;

        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        /* 과정 1 종료 */

        /* 과정 2. bfs 메소드 실행 */
        bfs(0, 0);

        System.out.println(map[N-1][M-1]);
    }

    public static void bfs(int n, int m) {
        visited[n][m] = true;
        deque.push(new Point(n, m));

        while(!deque.isEmpty()) {
            Point p = deque.pop();

            for(int i = 0; i < 4; i++) {
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];

                if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
                    if(map[nextX][nextY] != 0 && !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        deque.offer(new Point(nextX, nextY));
                        map[nextX][nextY] = map[p.x][p.y] + 1;
                    }
                }
            }

        }
    }


    }

