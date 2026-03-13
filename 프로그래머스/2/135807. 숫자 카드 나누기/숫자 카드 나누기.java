import java.util.*; 
import java.lang.*; 


class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        PriorityQueue<Integer> avail = new PriorityQueue<>((a,b) -> b - a);         
        find(avail, arrayA, arrayB);
        find(avail, arrayB, arrayA); 
        
        return avail.size() > 0 ? avail.poll() : 0;
    }
    
    
    void find(PriorityQueue avail, int[] arr1, int[] arr2) {
        Arrays.sort(arr1); 
        Arrays.sort(arr2); 
        
        int min = arr1[0]; 
        
        ArrayList<Integer> divArr = new ArrayList<>(); 
        divArr.add(min); 
        for(int i=2; 2*i<=min;i++) {
            if(min % i == 0) divArr.add(i); 
        }
        
        for(int div : divArr) {
            boolean success = true; 
            
            for(int num : arr1) {
                if(num % div != 0) { success = false; break; }
            }
            
            if(!success) continue; 
            
            for(int num : arr2) {
                if(num % div == 0) { success = false; break; }
            }
            
            if(success) avail.add(div); 
        }
        
        
    }
}