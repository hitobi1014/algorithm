import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;

/**
 * 걸그룹수 N 맞힐문제수 M
 * 이름이 같은 멤버는 존재 x
 */
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, ArrayList<String>> idol = new HashMap<>();

        // 걸그룹 정보 받기
        for (int i = 0; i < N; i++) {
            ArrayList<String> groupList = new ArrayList<>();
            String groupName = br.readLine();
            int somePeople = Integer.parseInt(br.readLine());
            for (int j = 0; j < somePeople; j++) {
                groupList.add(br.readLine());
            }
            Collections.sort(groupList);
            idol.put(groupName, groupList);
        }

        StringBuilder answer = new StringBuilder();
        // 퀴즈
        for (int i = 0; i < M; i++) {
            String girl = br.readLine();
            int quizType = Integer.parseInt(br.readLine());

            if (quizType == 1) {
                 idol.forEach((key, val) -> {
                    val.forEach(name -> {
                        if(girl.equals(name)) {
                            answer.append(key).append('\n');
                            return;
                        }
                    });
                 });

            } else {
                idol.get(girl).forEach(member -> answer.append(member).append('\n'));
            }
        }

        System.out.println(answer.toString());
    }

}