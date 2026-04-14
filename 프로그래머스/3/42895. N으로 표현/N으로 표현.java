import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;

        Set<Integer>[] dp = new HashSet[9]; // dp[1] ~ dp[8]
        
        for (int i = 1; i <= 8; i++) {
            dp[i] = new HashSet<>();
            // N을 i번 이어붙인 수 (e.g. 5, 55, 555...)
            int repeated = 0;
            for (int k = 0; k < i; k++) {
                repeated = repeated * 10 + N;
            }
            dp[i].add(repeated);

            // j개 + (i-j)개 조합
            for (int j = 1; j < i; j++) {
                for (int a : dp[j]) {
                    for (int b : dp[i - j]) {
                        dp[i].add(a + b);
                        dp[i].add(a - b);
                        dp[i].add(a * b);
                        if (b != 0) dp[i].add(a / b);
                    }
                }
            }

            if (dp[i].contains(number)) return i;
        }

        return -1;
    }
}