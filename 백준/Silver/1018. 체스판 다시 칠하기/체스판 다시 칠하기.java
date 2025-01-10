import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] dimensions = br.readLine().split(" ");
        int n = Integer.parseInt(dimensions[0]);
        int m = Integer.parseInt(dimensions[1]);

        char[][] board = new char[n][m];
        char[] color = {'W', 'B'};

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int cnt = 0;
        int min = 2500;

        for (int height = 0; height <= n - 8 ; height++) {
            for (int width = 0; width <= m - 8; width++) {
                for (int k = 0; k < 2; k++) {
                    cnt = 0;
                    for (int i = 0; i < 8 ; i++) {
                        for (int j = 0; j < 8 ; j++) {
                            char comparison = board[height+i][width+j];
                            
                            if ((height +width) % 2 == 0) {
                                if ((i + j) % 2 == 0 && (color[k] == comparison)) {
                                    continue;
                                } else if ((i+j) % 2 == 1 && (color[k] != comparison)) {
                                    continue;
                                } else {
                                    cnt++;
                                }
                            } else  {
                                if ((i+j) % 2 == 0 && (color[k] != comparison)) {
                                    continue;
                                } else if ((i+j) % 2 == 1 && (color[k] == comparison)) {
                                    continue;
                                } else {
                                    cnt++;
                                }
                            }
                        }
                    }
                    if (cnt < min) {
                        min = cnt;
                    }
                }
            }
        }
        System.out.println(min);
    }
}