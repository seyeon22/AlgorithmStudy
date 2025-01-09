import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[10];

        for (int i = 0; i < 10; i++) {
            nums[i] = 2;
        }

        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        int second = sc.nextInt();


        nums[first - 1]--;
        nums[second - 1]--;

        double probability = 0.0;

        if (first == second) {
            probability = (double) (153 - (10 - first)) / 153;
        } else {
            int cnt = 0;
            int duplication = 0;

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    int opponentSum = (i + 1 + j + 1) % 10;
                    int mySum = (first + second) % 10;

                    if (mySum > opponentSum) {
                        if (nums[i] == 2) {
                            if (i == j) {
                                cnt += 1;
                                duplication++;
                            }
                            else cnt += 2;
                        } else if (nums[i] == 1 || nums[j] == 1) {
                            continue;
                        }
                        // System.out.println(i+1 + " " + (j+1) + " " + cnt);
                    }
                }
            }

            probability = (double) (cnt-duplication) / 153;
        }

        System.out.println(String.format("%.3f", probability));
    }
}
