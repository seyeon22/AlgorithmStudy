import java.io.*;
import java.util.*;

public class Main {
    static int[] time = new int[100001];
    static int min = Integer.MAX_VALUE;
    static int cnt = 0;
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int[] visit = new int[100001];

        if (k <= n) {
            System.out.println(n-k);
            System.out.println(1);
            return;
        }

        bfs(n);

        System.out.println(min);
        System.out.println(cnt);
    }

    public static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        time[x] = 1;

        while (!queue.isEmpty()) {
            int v = queue.poll();

            if (min < time[v]) return;

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0) next = v - 1;
                else if (i == 1) next = v + 1;
                else next = v * 2;
                if (next < 0 || next > 100000) continue;

                if (next == k) {
                    min = time[v];
                    cnt++;
                }

                if (time[next] == 0 || time[next] == time[v]+1) {
                    queue.add(next);
                    time[next] = time[v] + 1;
                }
            }
        }
    }
}