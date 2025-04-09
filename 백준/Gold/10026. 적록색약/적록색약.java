import java.util.*;
import java.io.*;

public class Main {
    static char[][] ch;
    static char[][] ch2;
    static boolean[][] visit;
    static boolean[][] visit2;
    static int n;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int cnt = 0;
    static int cnt2 = 0;

    static Queue<int[]> queue = new LinkedList<>();
    static Queue<int[]> queue2 = new LinkedList<>();

    static void bfs(int x, int y) {
        queue.offer(new int[]{x, y});
        visit[x][y] = true;
        while (!queue.isEmpty()) {
            char now = ch[queue.peek()[0]][queue.peek()[1]];
            int[] index = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = index[0] + dx[i];
                int ny = index[1] + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (ch[nx][ny] == now && !visit[nx][ny]) {
                        visit[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    static void bfs2(int x, int y) {
        queue2.offer(new int[]{x, y});
        visit2[x][y] = true;
        while (!queue2.isEmpty()) {
            char now2 = ch2[queue2.peek()[0]][queue2.peek()[1]];
            int[] index2 = queue2.poll();
            for (int i = 0; i < 4; i++) {
                int nx = index2[0] + dx[i];
                int ny = index2[1] + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (ch2[nx][ny] == now2 && !visit2[nx][ny]) {
                        visit2[nx][ny] = true;
                        queue2.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ch = new char[n][n];
        ch2 = new char[n][n];
        visit = new boolean[n][n];
        visit2 = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                ch[i][j] = s.charAt(j);
                if (ch[i][j] == 'B') ch2[i][j] = 'B';
                else ch2[i][j] = 'R';
            }
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i][0]) {
                cnt++;
                bfs(i, 0);
            }
            for (int j = 1; j < n; j++) {
                if (!visit[i][j]) {
                    cnt++;
                    bfs(i, j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!visit2[i][0]) {
                cnt2++;
                bfs2(i, 0);
            }

            for (int j = 1; j < n; j++) {
                if (!visit2[i][j]) {
                    cnt2++;
                    bfs2(i, j);
                }
            }
        }

        System.out.println(cnt + " " + cnt2);
    }
}
