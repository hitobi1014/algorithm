package again.ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.StringTokenizer;

/**
 * 설명
 * 김갑동 선생님은 올해 6학년 1반 담임을 맡게 되었다.
 * 김갑동 선생님은 우선 임시로 반장을 정하고 학생들이 서로 친숙해진 후에 정식으로 선거를 통해 반장을 선출하려고 한다.
 * 그는 자기반 학생 중에서 1학년부터 5학년까지 지내오면서 한번이라도 같은 반이었던 사람이 가장 많은 학생을 임시 반장으로 정하려 한다.
 * 그래서 김갑동 선생님은 각 학생들이 1학년부터 5학년까지 몇 반에 속했었는지를 나타내는 표를 만들었다.
 * 예를 들어 학생 수가 5명일 때의 표를 살펴보자.
 * 위 경우에 4번 학생을 보면 3번 학생과 2학년 때 같은 반이었고, 3번 학생 및 5번 학생과 3학년 때 같은 반이었으며,
 * 2번 학생과는 4학년 때 같은 반이었음을 알 수 있다. 그러므로 이 학급에서 4번 학생과 한번이라도
 * 같은 반이었던 사람은 2번 학생, 3번 학생과 5번 학생으로 모두 3명이다.
 * 이 예에서 4번 학생이 전체 학생 중에서 같은 반이었던 학생 수가 제일 많으므로 임시 반장이 된다.
 * 각 학생들이 1학년부터 5학년까지 속했던 반이 주어질 때, 임시 반장을 정하는 프로그램을 작성하시오.
 * <p>
 * 입력
 * 첫째 줄에는 반의 학생 수를 나타내는 정수가 주어진다. 학생 수는 3 이상 1000 이하이다.
 * 둘째 줄부터는 1번 학생부터 차례대로 각 줄마다 1학년부터 5학년까지 몇 반에 속했었는지를 나타내는 5개의 정수가 빈칸 하나를 사이에 두고 주어진다.
 * 주어지는 정수는 모두 1 이상 9 이하의 정수이다.
 * <p>
 * 출력
 * 첫 줄에 임시 반장으로 정해진 학생의 번호를 출력한다.
 * 단, 임시 반장이 될 수 있는 학생이 여러 명인 경우에는 그 중 가장 작은 번호만 출력한다.
 * <p>
 * 예시 입력
 * 5
 * 2 3 1 7 3
 * 4 1 9 6 8
 * 5 5 2 4 4
 * 6 5 2 6 7
 * 8 4 2 2 2
 * <p>
 * 출력 => 4
 */
public class Q0211_classPresident {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] numArr = new int[n][n];
        Map<Integer, Integer> student = new HashMap<>();
        int answer = 0;
        int max = 0;

        for (int i = 0; i < numArr.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < numArr.length; j++) {
                numArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int j = 0; j < numArr.length; j++) {

            for (int i = 0; i < numArr.length; i++) {
                int a = numArr[i][j];
                int repeat = 0;

                for (int k = 0; k < numArr.length; k++) {
                    if (i == k) continue;

                    if (a == numArr[k][j]) repeat++;
                }

                student.put(i + 1, Optional.ofNullable(student.get(i+1)).orElse(0) + repeat);
            }
        }

        for (Map.Entry<Integer,Integer> entry : student.entrySet()) {
            int x =  entry.getValue();
            if (max < x) {
                max = x;
                answer = entry.getKey();
            }
        }

        System.out.println(answer);
    }
}
