class Solution {
    int MOD = 20170805;

    public int solution(int m, int n, int[][] cityMap) {
        int[][] right = new int[m][n]; // 오른쪽으로 진행하며 도착
        int[][] down  = new int[m][n]; // 아래로 진행하며 도착

        right[0][0] = 1;
        down[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                if (cityMap[i][j] == 1) continue;

                int fromUp   = (i > 0) ? down[i-1][j] : 0;
                int fromLeft = (j > 0) ? right[i][j-1] : 0;

                if (cityMap[i][j] == 0) {
                    down[i][j]  = (fromUp + fromLeft) % MOD;
                    right[i][j] = (fromUp + fromLeft) % MOD;
                } else { // 2: 직진만
                    down[i][j]  = fromUp;
                    right[i][j] = fromLeft;
                }
            }
        }

        if (m == 1 && n == 1) return 1;
        int fromUp   = (m > 1) ? down[m-2][n-1] : 0;
        int fromLeft = (n > 1) ? right[m-1][n-2] : 0;
        return (fromUp + fromLeft) % MOD;
    }
}