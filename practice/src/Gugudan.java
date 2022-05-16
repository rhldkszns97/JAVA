import java.util.Scanner;

public class Gugudan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("[안내]희망하는 구구단을 숫자로 입력해 주세요 (2 ~ 9) : ");
        int input = scanner.nextInt();

        if (input < 2 || input > 9) {
            System.out.println("[경고]구구단은 2단 ~ 9단 까지만 선택할 수 있습니다.");
            System.out.println("프로그램을 종료합니다");
            System.exit(0);
        }

        System.out.println(input + "단이 입력되었습니다.");
        for (int i = 1; i < 10; i++) {
            System.out.printf("%d * %d = %d\n", input, i, input * i);
        }
    }
}
