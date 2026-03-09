import java.util.*;

class Solution {
    HashSet<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        char[] number = numbers.toCharArray();
        // 길이 1~n까지 모든 조합의 수를 만들어야 함
        makeStr(new StringBuilder(), number, new boolean[number.length]);

        int answer = 0;
        for (int num : set) {
            if (isPrime(num)) answer++;
        }
        return answer;
    }

    void makeStr(StringBuilder sb, char[] number, boolean[] visited) {
        if (sb.length() > 0) {
            set.add(Integer.parseInt(sb.toString()));  // 중간 길이도 추가
        }

        for (int i = 0; i < number.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sb.append(number[i]);

                makeStr(sb, number, visited);

                sb.deleteCharAt(sb.length() - 1);  // ← 백트래킹
                visited[i] = false;                  // ← 백트래킹
            }
        }
    }

    boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}