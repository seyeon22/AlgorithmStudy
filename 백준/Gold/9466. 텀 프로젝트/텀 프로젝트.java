import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static boolean[] visit;
    static boolean[] finished;

    static int cnt;

    static void dfs(int cur) {
        visit[cur] = true;
        int next = arr[cur];
        if (!visit[next]) {
            dfs(next);
        } else {
            if (!finished[next]) {
                cnt++;
                while (next != cur) {
                    cnt++;
                    next = arr[next];
                }
            }
        }
        finished[cur] = true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n+1];
            visit = new boolean[n+1];
            finished = new boolean[n+1];
            cnt = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (!finished[i]) dfs(i);
            }
            System.out.println(n-cnt);
        }
    }
}