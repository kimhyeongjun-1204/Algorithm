import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> kinds = new HashSet<>(Arrays.asList(gems));
        int total = kinds.size();

        Map<String, Integer> count = new HashMap<>();
        int left = 0, ansLeft = 0, ansLen = gems.length;

        for (int right = 0; right < gems.length; right++) {
            count.merge(gems[right], 1, Integer::sum);

            while (count.size() == total) {
                if (right - left < ansLen) {
                    ansLen = right - left;
                    ansLeft = left;
                }
                int c = count.get(gems[left]);
                if (c == 1) count.remove(gems[left]);
                else count.put(gems[left], c - 1);
                left++;
            }
        }

        return new int[]{ansLeft + 1, ansLeft + ansLen + 1};
    }
}