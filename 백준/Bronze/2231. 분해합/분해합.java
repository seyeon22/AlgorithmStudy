import java.util.Scanner;

public class Main {
    public static int findConstructor(int a) {
        String num = String.valueOf(a);
        int sum = a;

        for (int i = 0; i < num.length(); i++) {
            sum += num.charAt(i) - '0';
        }

        return sum;
    }

    public static void main(String[] args) {
        String input = "";

        Scanner sc = new Scanner(System.in);
        input = sc.next();  // 숫자 string으로 입력받기

        int si = input.length();  // 자릿수 구함

        int num = Integer.parseInt(input);

        int a = Integer.parseInt(input) - si*9;
        int b = Integer.parseInt(input) - 1;

        for (int i = a; i <= b; i++) {
            if (num == findConstructor(i)) {
                System.out.println(i);
                return;
            }
        }
        System.out.println("0");
    }
}
