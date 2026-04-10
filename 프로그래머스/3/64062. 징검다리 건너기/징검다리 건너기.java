import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        Deque<Integer> deque = new ArrayDeque<>(); // 인덱스 저장
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < stones.length; i++) {
            // 윈도우 범위 벗어난 앞쪽 제거
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            // 뒤에서부터 현재값보다 작은 것 제거
            while (!deque.isEmpty() && stones[deque.peekLast()] <= stones[i]) {
                deque.pollLast();
            }
            deque.addLast(i);

            // 첫 윈도우가 완성된 시점(i >= k-1)부터 최소값 갱신
            if (i >= k - 1) {
                answer = Math.min(answer, stones[deque.peekFirst()]);
            }
        }
        return answer;
    }
}