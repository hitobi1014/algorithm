import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<String> nArr = new HashSet<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // N개의 입력
        for (int i = 0; i < N; i++) {
            nArr.add(br.readLine());
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (nArr.contains(str)) res.add(str);
        }

        System.out.println(res.size());
        Collections.sort(res);
        res.forEach(e-> System.out.println(e));

    }
}