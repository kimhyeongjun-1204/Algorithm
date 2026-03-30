import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        // 진출 지점(routes[i][1]) 기준 오름차순 정렬
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        int camera = 1;
        int lastCamera = routes[0][1]; // 첫 차량의 진출 지점에 카메라 설치

        for (int i = 1; i < routes.length; i++) {
            // 현재 차량의 진입 지점이 마지막 카메라 위치보다 뒤에 있으면
            // 기존 카메라로 커버 불가 → 새 카메라 설치
            if (routes[i][0] > lastCamera) {
                camera++;
                lastCamera = routes[i][1];
            }
        }

        return camera;
    }
}