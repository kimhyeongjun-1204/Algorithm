import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        // 0: 앞 더미, 1~n: 실제 노드, n+1: 뒤 더미
        int[] prev = new int[n + 2];
        int[] next = new int[n + 2];

        for (int i = 0; i <= n + 1; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int cur = k + 1; // 실제 노드가 1부터 시작

        for (String c : cmd) {
            char order = c.charAt(0);
            if (order == 'U') {
                int num = Integer.parseInt(c.substring(2));
                while (num-- > 0) cur = prev[cur];
            } else if (order == 'D') {
                int num = Integer.parseInt(c.substring(2));
                while (num-- > 0) cur = next[cur];
            } else if (order == 'C') {
                stack.push(cur);
                next[prev[cur]] = next[cur];
                prev[next[cur]] = prev[cur];
                cur = (next[cur] == n + 1) ? prev[cur] : next[cur];
            } else {
                int restored = stack.pop();
                next[prev[restored]] = restored;
                prev[next[restored]] = restored;
            }
        }

        char[] answer = new char[n];
        Arrays.fill(answer, 'O');
        for (int d : stack) answer[d - 1] = 'X'; // 1-indexed → 0-indexed
        return new String(answer);
    }
}