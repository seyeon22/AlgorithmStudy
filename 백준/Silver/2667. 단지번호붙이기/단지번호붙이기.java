import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visit;

    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];
        visit = new boolean[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            String line = br.readLine();
            for (int j = 1; j <= n; j++) {
                map[i][j] = line.charAt(j-1) - '0';
            }
        }

        int all = 0;
        int[] house = new int[n*n/2 + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] == 0) continue;
                if (map[i][j] == 1 && !visit[i][j]) {
                    house[all++] = bfs(i, j);
                }
            }
        }

        Arrays.sort(house);
        System.out.println(all);
        for (int h : house) {
            if (h == 0) continue;
            System.out.println(h);
        }
    }

    public static int bfs(int x, int y) {
        int cnt = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y));
        visit[x][y] = true;
        cnt++;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            x = pair.x;
            y = pair.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length) continue;
                if (map[nx][ny] == 1 && !visit[nx][ny]) {
                    map[nx][ny] = map[x][y] + 1;
                    queue.add(new Pair(nx, ny));
                    visit[nx][ny] = true;
                    cnt++;
                }
            }
        }

        return cnt;
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}