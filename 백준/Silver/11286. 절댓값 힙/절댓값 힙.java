import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    private static int N;
    //    private static List<Integer> list;
//    private static int idx;
    private static PriorityQueue<Integer> pq;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
//        System.setIn(new FileInputStream("D:\\MJ\\algorithm\\src\\main\\java\\test\\text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pq = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1)==Math.abs(o2)) return Integer.compare(o1, o2);
            return Integer.compare(Math.abs(o1), Math.abs(o2));
        });

        N = Integer.parseInt(br.readLine());
//        list = new ArrayList<>();
        // 0번째 인덱스 값 삽입
//        list.add(Integer.parseInt(br.readLine()));

//        for (int i = 1; i < N; i++) {
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num != 0) {
                pq.add(num);
            } else {
                printDelete();
            }
        }
        System.out.println(sb.toString());
    }


    public static void printDelete() {
        if (pq.isEmpty()) {
            sb.append(0).append('\n');
            return;
        }

        sb.append(pq.poll()).append('\n');

//        list.remove(0);
    }


    // 0이 들어왔을때 삭제하는 메서드
//    public static void printDelete() {
//        if (list.isEmpty()) {
//            sb.append(0).append('\n');
//            return;
//        }
//
//        sb.append(list.get(0)).append('\n');
//        int lastNode = list.get(list.size() - 1);
//        list.set(0, lastNode);
//        list.remove(list.size() - 1);
//        if (list.size() > 1) dfsByPreOrder(1);
//
////        list.remove(0);
//    }

//    public static void dfsByPreOrder(int current) {
//        // root -> 좌 -> 우 VLR 전위 순회
//        int child = list.get(current); // 현재 root value
//        int root = list.get(current - 1);
//
//        // 현재 val이 이전 val보다 작거나 같으면 root에 현재 val 넣고
//        if (Math.abs(child) < Math.abs(root)) {
//            // child 값을 root로 변경
//            int temp = child;
//            list.set(current, root);
//            list.set(current-1, temp); // child에 root
//
//        } else if (Math.abs(child) == Math.abs(root)) {
//            // 절대값이 같았을때 , 원래 수 비교 후 작은 수
//            if (child < root) {
//                int temp = child;
//                list.set(current, root);
//                list.set(current-1, temp); // child에 root
//            }
//        }
//
//        // LR 호출
//        if (current * 2 < list.size()) dfsByPreOrder(current*2);
//        if (current * 2+1 < list.size()) dfsByPreOrder(current * 2 + 1);
//    }
}