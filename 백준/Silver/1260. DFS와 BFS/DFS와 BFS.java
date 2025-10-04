import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    private static final int MAX_N = 1_000;
    private static final char SPACE = ' ';
    private static final char LINE_BREAK = '\n';
    private static final Edge NIL = new Edge(Integer.MAX_VALUE, null);

    // final 클래스 : 상속을 통한 기능 추가 및 변경 방지
    private static final class Edge {
        int to; // 값
        Edge next; // 다음 노드를 가리킴

        Edge(int to, Edge next) {
            this.to = to;
            this.next = next;
        }
    }

    private static boolean[] visited;

    private static Edge[] adj; //
    private static StringBuilder sb;

    // 간선 추가 함수
    private static void addEdge(int u, int v) {
        Edge edge;

        for(edge = adj[u];edge.next.to < v; edge = edge.next);
        edge.next = new Edge(v, edge.next);
    }


    private static final void dfs(int curr) {
        int to;
        Edge edge;

        for(edge=adj[curr].next; edge != NIL; edge = edge.next) {
            if(!visited[to = edge.to]) {
                sb.append(to).append(SPACE);
                visited[to] = true;
                dfs(to);
            }
        }
    }

    private static void bfs(int start) {
        int to; // 다음 이동할 목적지
        int curr; // 현재 처리중인 정점
        Edge edge;
        ArrayDeque<Integer> q; // 양방향 입출력 가능한 큐

        q = new ArrayDeque<>(MAX_N);
        sb.append(start).append(SPACE);
        visited[start] = true;
        q.addLast(start);
        while(!q.isEmpty()) {
            curr = q.pollFirst(); // 비어있으면 null을 반환
            for(edge = adj[curr].next; edge != NIL; edge = edge.next) {
                if(!visited[to = edge.to]) {
                    sb.append(to).append(SPACE);
                    visited[to] = true;
                    q.addLast(to);
                }
            }
        }



    }

    public static void main(String[] args) throws IOException {
        int n;
        int m;
        int v;
        int v1;
        int v2;
        int i;

        BufferedReader br;
        StringTokenizer st;

        // 한줄의 문자열을 읽어옴
        br = new BufferedReader(new InputStreamReader(System.in));

        // " " => 공백을 구분자로 여러 토큰으로 자름. false => 구분자를 토큰에 포함시키지 않음.
        st = new StringTokenizer(br.readLine()," ", false );

        n = Integer.parseInt(st.nextToken()); // 노드 개수
        m = Integer.parseInt(st.nextToken()); // 간선 개수
        v = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점의 번호

        adj = new Edge[n+1];
        for(i=1;i<=n;i++) {
            // 마지막 노드에 NIL 추가
            adj[i] = new Edge(0, NIL); // 마지막 노드에
        }

        // 간선 추가
        while(m-- > 0) {
            st = new StringTokenizer(br.readLine()," ", false );
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            addEdge(v1, v2);
            addEdge(v2, v1);
        }

        sb = new StringBuilder();
        visited = new boolean[n+1];
        sb.append(v).append(SPACE);
        visited[v] = true;
        dfs(v);
        sb.append(LINE_BREAK);

        visited = new boolean[n+1];
        bfs(v);
        System.out.print(sb.toString());
    }
}

