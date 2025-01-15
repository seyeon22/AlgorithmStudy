import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int[][] board = new int[5][5];
        final int[][] check = new int[5][5];

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                check[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;

        for (int i = 0; i < 5; i++) {
            boolean bingoDone = false;
            for (int l = 0; l < 5; l++) {
                boolean done = false;
                int bingo = 0;
                cnt++;

                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 5; k++) {
                        if (check[i][l] == board[j][k]) {
                            board[j][k] = 0;  // 여기서 0으로 만들고
                            done = true;
                            break;
                        }
                    }
                    if (done) break;
                }
                // 가로 확인
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 5; k++) {
                        if (board[j][k] != 0) break;
                        else if (k == 4 && board[j][4] == 0) bingo++;
                    }
                }

                // 세로 확인
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 5; k++) {
                        if (board[k][j] != 0) break;
                        else if (k == 4 && board[4][j] == 0) bingo++;
                    }
                }

                // 대각선 확인
                for (int j = 0, k = 0; j < 5 && k < 5; j++, k++) {
                    if (board[j][k] != 0) break;
                    else if (j == 4 && k == 4 && board[4][4] == 0) bingo++;
                }

                for (int j = 4, k = 0; j >= 0 && k < 5; j--, k++) {
                    if (board[j][k] != 0) break;
                    else if (j == 0 && k == 4 && board[0][4] == 0) {
                        bingo++;
                    }
                }

                if (bingo >=3) {
                    System.out.println(cnt);
                    bingoDone = true;
                    break;
                }
            }
            if (bingoDone) break;
        }
    }
}