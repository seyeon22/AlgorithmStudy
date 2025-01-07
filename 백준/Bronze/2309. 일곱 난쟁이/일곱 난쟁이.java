import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] height = new int[9];
        int sum = 0;

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            height[i] = sc.nextInt();
            sum += height[i];
        }

        int[] sortedHeight = Arrays.stream(height).sorted().toArray();

        for (int i = 0; i < 8; i++) {
            for (int j = i+1; j < 9; j++) {
                if ((sum - 100) == sortedHeight[i]+sortedHeight[j]) {
                    sortedHeight[i] = 0;
                    sortedHeight[j] = 0;
                    break;
                }
            }
            if (sortedHeight[i] == 0) {
                break;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (sortedHeight[i] != 0) {
                System.out.println(sortedHeight[i]);
            }
        }
    }
}