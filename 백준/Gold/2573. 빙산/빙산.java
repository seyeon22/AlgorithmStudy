import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] ice;
    static boolean[][] visit;
    static boolean[][] visited;
    static int cnt;
    static int day;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            visit[now[0]][now[1]] = true;
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!ice[nx][ny] && map[now[0]][now[1]] > 0) {
                        map[now[0]][now[1]]--;
                    } else if (ice[nx][ny] && !visit[nx][ny]) {
                        queue.offer(new int[]{nx, ny});
                        visit[nx][ny] = true;
                    }
                }
            }
        }
    }

    static void count(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 1 && nx < n && ny >= 1 && ny < m) {
                    if (map[nx][ny] > 0 && !visited[nx][ny]) {
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        ice = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) ice[i][j] = true;
            }
        }



        day = 0;
        int ex = 0;
        boolean ch = false;
        while (true) {
            cnt = 0;
            visit = new boolean[n][m];
            for (int i = 1; i < n - 1; i++) {
                for (int j = 1; j < m - 1; j++) {
                    if (ice[i][j] && !visit[i][j]) {
                        bfs(i, j);
                        ex++;
                    }
                }
            }

            if (!ch && ex > 1 || ex == 0) { 
                break;
            }

            for (int i = 1; i < n - 1; i++) {
                for (int j = 1; j < m - 1; j++) {
                    if (map[i][j] == 0) ice[i][j] = false;
                }
            }

            visited = new boolean[n][m];
            for (int i = 1; i < n - 1; i++) {
                for (int j = 1; j < m - 1; j++) {
                    if (ice[i][j] && !visited[i][j]) {
                        count(i, j);
                        cnt++;
                    }
                }
            }
            if (cnt == 1) day++;
            else if (cnt > 1) {
                day++;
                break;
            } else {
                day = 0;
                break;
            }
            ch = true;
        }
        System.out.println(day);
    }
}