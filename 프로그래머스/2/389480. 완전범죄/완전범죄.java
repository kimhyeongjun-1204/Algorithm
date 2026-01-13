import java.util.Arrays;

class Solution {
    public int[][] dp;
    public int[][] info;
    public int n, m;

    public int solve(int i, int b) {
        // 1. 베이스 케이스: 모든 물건을 다 확인했을 때
        if (i == info.length) return 0;

        // 2. 이미 계산한 적이 있다면 그 값을 반환 (Memoization)
        if (dp[i][b] != -1) return dp[i][b];

        int result = 1000000; // 충분히 큰 값 (Integer.MAX_VALUE는 오버플로우 위험)

        // 3. 선택 1: A가 물건을 가져가는 경우
        // A의 흔적은 제한(n)이 없거나 마지막에 체크하므로 일단 더함
        result = Math.min(result, solve(i + 1, b) + info[i][0]);

        // 4. 선택 2: B가 물건을 가져가는 경우 (제한 m을 넘지 않을 때만)
        if (b + info[i][1] < m) {
            result = Math.min(result, solve(i + 1, b + info[i][1]));
        }

        // 5. 결과 저장 및 반환
        return dp[i][b] = result;
    }

    public int solution(int[][] info, int n, int m) {
        this.n = n;
        this.m = m;
        this.info = info;

        // DP 테이블 초기화 (-1은 아직 방문하지 않았음을 의미)
        dp = new int[info.length][m];
        for (int[] row : dp) Arrays.fill(row, -1);

        int answer = solve(0, 0);

        // 결과가 n 이상이거나 초기값 그대로라면 불가능한 경우
        return (answer >= n) ? -1 : answer;
    }
}