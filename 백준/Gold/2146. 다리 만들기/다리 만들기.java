import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static int[][] bridge;
    static boolean[][] visit;
    static int min = Integer.MAX_VALUE;
    static int island;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visit[x][y] = true;
        map[x][y] = island;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (!visit[nx][ny] && map[nx][ny] == 1) {
                        map[nx][ny] = island;
                        visit[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    static void distance(int x, int y, int start) {
        Queue<int[]> queue = new LinkedList<>();
        visit = new boolean[n][n];
        visit[x][y] = true;
        queue.add(new int[]{x, y, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int count = now[2];

            if (map[now[0]][now[1]] != 0 && map[now[0]][now[1]] != start) {
                min=Math.min(min, count-1); // 다른 육지까지도 포함해서 거리를 세서 -1해줌
            }
            if (count > min) return;

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (map[nx][ny] == start || visit[nx][ny]) continue;
                    queue.add(new int[]{nx, ny, count+1});
                    visit[nx][ny] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        bridge = new int[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        island = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visit[i][j]) {
                    bfs(i, j);
                    island++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] > 1) {
                    distance(i, j, map[i][j]);
                }
            }
        }

        System.out.println(min);
    }
}