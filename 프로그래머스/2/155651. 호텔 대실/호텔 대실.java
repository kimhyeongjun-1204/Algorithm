import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        // 1) 입실 시각 기준 정렬
        Arrays.sort(book_time, (a, b) -> a[0].compareTo(b[0]));

        // 2) 최소 힙: 각 방의 "퇴실 + 10분" 시각을 저장
        PriorityQueue<Integer> rooms = new PriorityQueue<>();

        for (String[] book : book_time) {
            int start = toMin(book[0]);
            int end = toMin(book[1]) + 10;  // 청소 10분

            // 가장 빨리 비는 방이 현재 입실 시각 이하면 재사용
            if (!rooms.isEmpty() && rooms.peek() <= start) {
                rooms.poll();
            }

            rooms.offer(end);
        }

        return rooms.size();
    }

    int toMin(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}
