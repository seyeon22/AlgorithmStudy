import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        final StringTokenizer st = new StringTokenizer(br.readLine());

        final int[] stock = new int[st.countTokens()];

        for (int i = 0; i < stock.length; i++) {
            stock[i] = Integer.parseInt(st.nextToken());
        }

        int[] jun = new int[2];
        int[] seong = new int[2];

        jun[1] = n;
        seong[1] = n;

        for (int i = 0; i < 14; i++) {
            if (jun[1] >= stock[i]) {
                jun[0] += jun[1]/stock[i];
                jun[1] -= (jun[1]/stock[i])*stock[i];
            }
            if (i >= 3) {  // 가격 3일 연속 상승 -> 전량 매도, 가격 3일 연속 하락 -> 전량 매수
                if (stock[i-3] > stock[i-2] && stock[i-2] > stock[i-1] && seong[1] >= stock[i]) {
                    seong[0] += seong[1]/stock[i];
                    seong[1] -= (seong[1]/stock[i])*stock[i];
                }
                if (stock[i-3] < stock[i-2] && stock[i-2] < stock[i-1] && seong[0] > 0) {
                    seong[1] += seong[0]*stock[i];
                    seong[0] = 0;
                }
            }
        }

        int jun_sum = jun[0]*stock[13] + jun[1];
        int seong_sum = seong[0]*stock[13] + seong[1];

        if (jun_sum == seong_sum) {
            System.out.println("SAMESAME");
        } else if (jun_sum > seong_sum) {
            System.out.println("BNP");
        } else {
            System.out.println("TIMING");
        }
    }
}