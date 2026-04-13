class Solution {
    public long solution(int[] sequence) {
        int n = sequence.length;
        
        // 펄스 적용: a는 [1,-1,1,-1,...], b는 [-1,1,-1,1,...]
        long[] a = new long[n];
        long[] b = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = (i % 2 == 0) ? sequence[i] : -sequence[i];
            b[i] = (i % 2 == 0) ? -sequence[i] : sequence[i];
        }
        
        return Math.max(kadane(a), kadane(b));
    }
    
    private long kadane(long[] arr) {
        long maxSum = Long.MIN_VALUE;
        long cur = 0;
        for (long val : arr) {
            cur = Math.max(val, cur + val);
            maxSum = Math.max(maxSum, cur);
        }
        return maxSum;
    }
}