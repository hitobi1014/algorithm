import java.io.*;
import java.util.*;

public class Main {
    static int N, M, answer;
    static int[] person;
    static ArrayList[] partyList;
    static boolean[] visited, personChk;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //사람들 번호는 1~N까지
        //파티도 동일
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        partyList = new ArrayList[M+1];
        for (int i = 1; i <= M; i++) {
            partyList[i] = new ArrayList<>();
        }

        //진실을 아는 사람
        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        person = new int[p];
        for (int i = 0; i < p; i++) {
            person[i] = Integer.parseInt(st.nextToken());
        }

        //파티 참가자
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int pNum = Integer.parseInt(st.nextToken());
            for (int j = 0; j < pNum; j++) {
                partyList[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        answer = M;
        //진실을 아는사람이 없으면 파티수 바로 출력
        if (person.length == 0) {
            System.out.println(answer);
            return;
        }

        visited = new boolean[M+1];
        personChk = new boolean[N+1];
        findMaxParty();
        System.out.println(answer);

    }

    static void findMaxParty(){
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < person.length; i++) {
            //진실아는사람 add
            queue.offer(person[i]);
            personChk[person[i]] = true; //진실아는사람은 방문처리
        }

        while(!queue.isEmpty()){
            int poll = queue.poll();

            //전체 파티수만큼 반복
            for (int i = 1; i <= M; i++) {
                //이미 진실을 아는파티면 pass
                if(visited[i]) continue;

                //진실을 아는사람이 파티에 있을경우 &&
                if(partyList[i].contains(poll)){
                    answer--;
                    visited[i] = true;

                    for (int j=0; j<partyList[i].size(); j++) {
                        int getP = (int) partyList[i].get(j);
                        //queue에 들어간적이 없는 사람
                        if(!personChk[getP]) {
                            queue.offer(getP);
                            personChk[getP] = true;
                        }
                    }
                }
            }
        }

    }
}