import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        final int size = sc.nextInt();
        int push = 1; // 다음 스택에 넣을 수
        boolean success = false;
        boolean breaks = false;

        StringBuilder result = new StringBuilder();

        for(int i=0;i<size;i++){
            int num = sc.nextInt(); // pop 해야 되는 수
            if(breaks) break;

            // 1. push 진행
            while(stack.isEmpty() || num > stack.peek()) {
                if(push > num) {breaks = true; break;}
                stack.push(push++);
                result.append("+\n");
            }

            // 2. pop 진행
            if(stack.isEmpty() || stack.pop() != num) {
                break;
            }
            result.append("-\n");

            if(i == size-1) success = true;
        }

        if(success) System.out.println(result);
        else System.out.println("NO");
    }
}