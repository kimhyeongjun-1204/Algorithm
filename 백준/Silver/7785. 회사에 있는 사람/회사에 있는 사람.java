import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 이름을 저장할 HashSet 사용
        HashSet<String> people = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String[] log = br.readLine().split(" ");
            String name = log[0];
            String action = log[1];

            // "enter"이면 HashSet에 추가, "leave"이면 제거
            if (action.equals("enter")) {
                people.add(name);
            } else {
                people.remove(name);
            }
        }

        // 남아 있는 사람들을 리스트로 옮겨 사전 역순 정렬
        List<String> result = new ArrayList<>(people);
        result.sort(Collections.reverseOrder());

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (String name : result) {
            sb.append(name).append("\n");
        }
        System.out.print(sb);
    }
}

