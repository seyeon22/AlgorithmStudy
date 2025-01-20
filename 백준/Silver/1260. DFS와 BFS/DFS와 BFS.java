import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3 ; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        graph = new ArrayList[input[0] + 1];
        visit = new boolean[input[0] + 1];
        for (int i = 1; i <= input[0]; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < input[1] ; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        for (int i = 1; i <= input[0] ; i++) {
            Collections.sort(graph[i]);
        }

        dfs(input[2]);
        Arrays.fill(visit, false);
        System.out.println();
        bfs(input[2]);
    }

    public static void dfs(int v) {
        visit[v] = true;
        System.out.print(v + " ");
        for (int i : graph[v]) {
            if (!visit[i]) dfs(i);
        }
    }

    public static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(v);
        visit[v] = true;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            System.out.print(temp + " ");

            for (int nextV : graph[temp]) {
                if (!visit[nextV]) {
                    queue.add(nextV);
                    visit[nextV] = true;
                }
            }
        }
    }
}