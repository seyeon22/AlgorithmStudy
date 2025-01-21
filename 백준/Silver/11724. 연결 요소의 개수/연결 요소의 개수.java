import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visit;
    static int cnt = 0;
    static int link = 0;
    static int num = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        graph = new ArrayList[a+1];
        visit = new boolean[a+1];
        for (int i = 1; i < graph.length; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < b; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        num = 1;
        while (cnt < graph.length-1) {
            bfs(num);
            for (int i = 1; i < graph.length; i++) {
                if (!visit[i]) {
                    num = i;
                    break;
                }
            }
        }
        System.out.println(link);
    }

    public static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(v);
        visit[v] = true;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            cnt++;

            for (int nextV : graph[temp]) {
                if (cnt < graph.length && !visit[nextV]) {
                    queue.add(nextV);
                    visit[nextV] = true;
                }
            }
        }
        link++;
    }
}
