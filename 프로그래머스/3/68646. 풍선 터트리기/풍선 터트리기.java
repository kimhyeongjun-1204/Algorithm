import java.lang.*; 

class Solution {
    public int solution(int[] a) {
        int answer = 2;
        
        if(a.length <= 2) return a.length; 
        int min = a[0]; 
        int minI = 0; 
        
        for(int i=1;i<a.length;i++) {
            if(min > a[i]) {
                min = a[i]; 
                minI = i; 
            }
        }
        
        int leMin = a[0]; 
        for(int i=1;i<minI;i++) {
            if(leMin < a[i]) {
                continue;
            }else {
                answer++;
                leMin = a[i]; 
            }
        }
        
        if(minI != 0 && minI != a.length-1) answer++; 
        
        int riMin = a[a.length-1]; 
        for(int i=a.length-2;i>minI;i--) { // ㅎ
            if(a[i] > riMin) {
                continue; 
            }else {
                answer++; 
                riMin = a[i]; 
            }
        }
        
        return answer;
    }
}



// // 27 남겨야됨 
        
//         for(int i=0;i<a.length;i++) {
//             int num = a[i]; // 남겨야할 수 
//             boolean remove = false; // 보다 큰 수를 지웠는지 
//             int min = Integer.MAX_VALUE; // 왼쪽에서의 최소값
//             for(int j=0;j<i;j++) {
//                 min = Math.min(min, a[j]); 
//             }
//             if(min < a[i]) remove = true; 
            
//             min = Integer.MAX_VALUE;
//             for(int j=i+1;j<a.length;j++) {
//                 min = Math.min(min, a[j]); 
//             }
            
//             if(min < a[i] && remove) continue; 
            
//             answer++; 
//         }