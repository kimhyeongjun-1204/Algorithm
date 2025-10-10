import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int P;
    /* 1. 순서 없음 2. 중복 없음 3. 빠르게 검색 가능 */
    static Map<Integer, Integer> hashMap = new HashMap<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        int n = 1; // 몇번째인지 검사
        hashMap.put(A, n++);

        while(true) {
            A = func(A);
            if(hashMap.containsKey(A)) {
                System.out.println(hashMap.get(A)-1);
                break;
            }

            hashMap.put(A, n++);
        }



    }

    static int func(int num) {
        int remain; // 나머지
        int sum = 0;

        do {
            remain = num % 10; // 7
            num = num / 10; // 5
            sum += (int)Math.pow(remain, P);
        }while(num != 0);

        return sum;
    }
}
