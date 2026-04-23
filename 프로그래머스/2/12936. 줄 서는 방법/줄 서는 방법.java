import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) nums.add(i);

        // 팩토리얼 미리 계산
        long[] fact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) fact[i] = fact[i - 1] * i;

        k--; // 0-indexed로 변환

        for (int i = n; i >= 1; i--) {
            int idx = (int)(k / fact[i - 1]); // 몇 번째 숫자를 꺼낼지
            answer[n - i] = nums.remove(idx);
            k %= fact[i - 1];
        }

        return answer;
    }
}