class Solution {
    public int solution(String name) {
        int len = name.length();
        int upDown = 0;
        int leftRight = len - 1; // 최악: 그냥 오른쪽으로 쭉

        for (int i = 0; i < len; i++) {
            // 1. 상하 이동: 위로 가거나 아래로 가거나 최솟값
            char c = name.charAt(i);
            upDown += Math.min(c - 'A', 'Z' - c + 1);

            // 2. 좌우 이동: 연속된 A 구간을 건너뛰는 최적 경로
            int next = i + 1;
            while (next < len && name.charAt(next) == 'A') {
                next++;
            }
            // i까지 갔다가 되돌아와서 나머지를 왼쪽으로 가는 경우
            // 또는 왼쪽으로 먼저 갔다가 되돌아와서 오른쪽으로 가는 경우
            leftRight = Math.min(leftRight,
                Math.min(
                    i * 2 + (len - next),      // 오른쪽 갔다 돌아와서 왼쪽
                    (len - next) * 2 + i        // 왼쪽 갔다 돌아와서 오른쪽
                )
            );
        }

        return upDown + leftRight;
    }
}