import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean[] visit = new boolean[100001];
        if (n == k) {
            System.out.println(0);
            return;
        }
        int x = n;
        visit[x] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visit[x] = true;
        int cnt = 0;
        while (true) {
            cnt++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                x = queue.remove();
                visit[x] = true;

                if (x - 1 == k || x + 1 == k || x * 2 == k) {
                    System.out.println(cnt);
                    return;
                }
                if (x - 1 > 0 && !visit[x - 1]) {
                    visit[x - 1] = true;
                    queue.add(x - 1);
                }
                if (x + 1 <= 100000 && !visit[x + 1]) {
                    visit[x + 1] = true;
                    queue.add(x + 1);
                }
                if (x * 2 <= 100000 && !visit[x * 2]) {
                    visit[x * 2] = true;
                    queue.add(x * 2);
                }
            }
        }
    }
}