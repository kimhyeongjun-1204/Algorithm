import java.util.*;
import java.lang.Math;
class Solution {
    public boolean isChar(char ch) {
        if(ch == 'S' || ch == 'D' || ch =='T') return true;
        return false; 
    }
    
    public boolean isDigit(char ch) {
        if(ch >= '0' && ch <= '9') return true; 
        return false; 
    }
    
    public int solution(String dartResult) {
        int answer = 0;
        
        int[] score = new int[3];   
        int top = -1; 
        HashMap<Character, Integer> area = new HashMap<>(); // S D T 
        area.put('S', 1);area.put('D', 2);area.put('T', 3);
        
        for(int i=0;i<dartResult.length();i++) {
            char ch = dartResult.charAt(i); 
            
            if(isChar(ch)) {
                int num = 0;// 현재 점수 저장(S,D,T로 제곱될 수) 
                if(i == 1 || !isDigit(dartResult.charAt(i-2))) {
                    num = dartResult.charAt(i-1) - '0';
                }else {
                    num = 10; 
                }
                score[++top] = (int)Math.pow(num , area.get(ch));  
                System.out.println(score[top]); 
            }else if(ch == '*') {
                score[top] *= 2;
                if(top >= 1) score[top-1] *= 2;
            }else if(ch == '#') {
                score[top] *= -1; 
            }
        }
        
        for(int sc : score) {
            answer += sc; 
        }
        
        
        return answer;
    }
}