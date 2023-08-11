import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 회의실 배정
 */
public class Main {
    // 0번 인덱스 => 시작시간
    // 1번 인덱스 => 종료시간
    static List<int[]> roomInfo;
    static int answer = 1;

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        // 회의 수
        int N = sc.nextInt();
        roomInfo = new ArrayList<>(N);

        for (int i=0; i<N; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            roomInfo.add(new int[]{start, end});
        }

        // 종료시간 기준으로 정렬
        roomInfo.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]==o2[1] ? Integer.compare(o1[0],o2[0]) : Integer.compare(o1[1], o2[1]);
            }
        });

        findMaxUseRoom();
        System.out.println(answer);

    }

    private static void findMaxUseRoom() {
        // 이전 방을 비교하기 위해 인덱스 설정
        int idx = 0;
        /**
         * 1. 현재 방의 시작시간이 이전 종료시간보다 크거나 같아야함
         * 1-1.
         * 아닐경우 다음 리스트로 continue
         */

        for (int i = 1; i < roomInfo.size(); i++) {
            if (roomInfo.get(i)[0] < roomInfo.get(idx)[1]) continue;
            answer++;
            idx = i;
        }
    }
}