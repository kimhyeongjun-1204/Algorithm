import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        
        int n = jobs.length;
        if (n == 0) return 0;

        // [요청시각, 소요시간, 작업번호]
        int[][] nJobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            nJobs[i][0] = jobs[i][0];
            nJobs[i][1] = jobs[i][1];
            nJobs[i][2] = i;
        }

        // 요청 시각 기준 정렬
        Arrays.sort(nJobs, (a, b) -> Integer.compare(a[0], b[0]));

        // 우선순위 큐
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1];   // 소요시간
            if (a[0] != b[0]) return a[0] - b[0];   // 요청시각
            return a[2] - b[2];                    // 작업번호
        });

        long total = 0;   // 반환 시간 합
        int time = 0;     // 현재 시간
        int idx = 0;      // 아직 큐에 넣지 않은 작업 인덱스
        int completed = 0;

        while (completed < n) {

            // 현재 시간까지 들어온 작업을 큐에 추가
            while (idx < n && nJobs[idx][0] <= time) {
                pq.offer(nJobs[idx]);
                idx++;
            }

            // 큐가 비어있다면 다음 작업 요청 시점으로 점프
            if (pq.isEmpty()) {
                time = nJobs[idx][0];
                continue;
            }

            // 우선순위 가장 높은 작업 수행
            int[] job = pq.poll();
            time += job[1];
            total += (time - job[0]);
            completed++;
        }

        return (int)(total / n);
    }
}
