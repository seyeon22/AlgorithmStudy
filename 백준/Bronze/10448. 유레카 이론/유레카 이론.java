import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int num = 0;
        int[] numbers = new int[1000];
        int[] triangle = new int[45];

        for (int i = 1; i < 45; i++) {
            triangle[i] = i*(i+1)/2;
        }

        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();

        for (int i = 0; i < num; i++) {
            numbers[i] = sc.nextInt();
            boolean check = false;

            for (int j = 1; j < 45; j++) {
                for (int k = 1; k < 45; k++) {
                    for (int l = 1; l < 45; l++) {
                        if (numbers[i] == (triangle[j]+triangle[k]+triangle[l])) {
                            System.out.println("1");
                            check = true;
                            break;
                        } else if (numbers[i] < (triangle[j]+triangle[k]+triangle[l])) {
                            break;
                        }
                    }
                    if (check) {
                        break;
                    }
                }
                if (check) {
                    break;
                }
            }
            if (!check) {
                System.out.println("0");
            }
        }
    }
}