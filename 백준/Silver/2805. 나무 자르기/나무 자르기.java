import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Main {
    static int N, M, tree[];
    static int answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> sToNum = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = sToNum.apply(st.nextToken()); // 나무 수
        M = sToNum.apply(st.nextToken()); // 가져가려는 나무 길이
        tree = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = sToNum.apply(st.nextToken());
        }

        Arrays.sort(tree);
        findTreeHigh(0, tree[N - 1]);
        System.out.println(answer-1);
    }

    private static void findTreeHigh(int start, int end) {
        // 중간 값에서 tree배열에 있는 (1) 나무높이 - 톱날높이
        // (1) 결과가 음수일때는 반영x 모든 값을 더한뒤 합산 결과가 M길이보다 크다면
        // (2) start의 값을 톱날높이로 보내기 end는 나무최대높이 그대로
        //
        if(start >= end) { //start가 end보다 커지면 끝
            answer = end;
            return;
        }
        int mid = (start + end) / 2;
        long sum = 0; // 톱-나무높이 합산

        for (int i = 0; i < N; i++) {
            if (tree[i] - mid > 0){
                sum += tree[i] - mid;
            }
        }

        if (sum >= M){ 
            findTreeHigh(mid+1, end);
        }else if(sum < M) {
            findTreeHigh(start, mid);
        }
    }

}