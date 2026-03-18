import java.util.*;

class Solution {
    ArrayList<ArrayList<Integer>> children = new ArrayList<>();
    int[] info;
    int answer = 0;

    public int solution(int[] info, int[][] edges) {
        this.info = info;

        for (int i = 0; i < info.length; i++)
            children.add(new ArrayList<>());

        for (int[] ed : edges)
            children.get(ed[0]).add(ed[1]);

        List<Integer> candidates = new ArrayList<>();
        candidates.add(0);
        dfs(candidates, 0, 0);

        return answer;
    }

    void dfs(List<Integer> candidates, int sheep, int wolf) {
        for (int i = 0; i < candidates.size(); i++) {
            int node = candidates.get(i);

            int nSheep = sheep + (info[node] == 0 ? 1 : 0);
            int nWolf = wolf + (info[node] == 1 ? 1 : 0);

            if (nWolf >= nSheep) continue;

            answer = Math.max(answer, nSheep);

            // 현재 후보에서 node를 제거하고, node의 자식들을 추가
            List<Integer> next = new ArrayList<>(candidates);
            next.remove(i);
            next.addAll(children.get(node));

            dfs(next, nSheep, nWolf);
        }
    }
}