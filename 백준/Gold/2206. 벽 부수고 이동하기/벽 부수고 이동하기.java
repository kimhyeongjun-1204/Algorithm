import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][][] visited;
    static int n,m;


    static class Point {
        /* 좌표 */
        int x,y;

        /* 벽 방문 여부 */
        boolean wall;

        /* 이동 거리 */
        int distance;

        Point(int x, int y, boolean wall, int distance) {
            this.x = x;
            this.y = y;
            this.wall = wall;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        /* 1. 사용자 입력 */
        userInput();

        /* 2. bfs 알고리즘 진행 */
        bfs();

    }

    static void userInput() throws IOException {
        /* 1. 사용자 입력 받기 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); //  y 6
        m = Integer.parseInt(st.nextToken()); //  x 4

        map = new int[n][m];
        visited = new boolean[n][m][2]; // 0 => 벽 X 경우 , 1 => 벽 0 경우

        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<m;j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }
    }

    static void bfs() {
        if(n == 1 && m == 1) {
            System.out.println(1);
            return;
        }
        /* 1. Queue 설정 */
        Queue<Point> q = new LinkedList<>();
        visited[0][0][0] = true;
        q.add(new Point(0, 0, false, 1));


        // 상하좌우 이동
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        /* 2. 만약 Queue가 비었으면 경로 없음 */
        while(!q.isEmpty()){
            Point curr = q.poll();

            for(int i=0;i<4;i++){
//              인접 좌표
                int x = curr.x+dx[i];
                int y = curr.y+dy[i];

                if(x<0||x>=n||y<0||y>=m) continue;

                /* 만약 목적지에 도착하면 바로 종료 */
                if(x == n-1 && y == m-1) {
                    System.out.println(curr.distance+1);
                    return; // ⬅️ 최단 경로를 찾았으므로 즉시 종료
                }

                    /* 1. 벽이 아닌 경우 */
                    if(map[x][y]==0)  {
                        /* (1) 벽을 부수고 왔을 때 */
                        if(curr.wall) {
                            if(!visited[x][y][1]) {
                                q.add(new Point(x, y, true, curr.distance+1));
                                visited[x][y][1] = true;
                            }
                        }else {
                            if(!visited[x][y][0]) {
                                q.add(new Point(x, y, false, curr.distance + 1));
                                visited[x][y][0] = true;
                            }
                        }
                    }else if(!curr.wall)  {
                        // 벽이 있고 벽을 아직 안부셨으면 벽을 부수고(wall=true) 큐에 삽입
                        if(!visited[x][y][1]) {
                            q.add(new Point(x, y, true, curr.distance+1));
                            visited[x][y][1] = true;
                        }
                    }
            }
        }
        /* == while문 종료 == */

        System.out.println(-1);

    }
}
