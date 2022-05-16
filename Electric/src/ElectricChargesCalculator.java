import java.util.Scanner;

public class ElectricChargesCalculator {
    public static void main(String[] args) {
        System.out.println("======================");
        System.out.println("  주택용 전기요금 계산기 ");
        System.out.println("======================");

        Scanner input = new Scanner(System.in);
        System.out.print("Kwh를 입력하세요 : ");
        int kwh = input.nextInt();
        double charges = 0;
        while (kwh != 0) {
            if (kwh <= 100) {
                charges += 60.7 * kwh;
                kwh = 0;
            }
            else if (kwh <= 200) {
                charges += 125.9 * (kwh - 100);
                kwh = 100;
            }
            else if (kwh <= 300) {
                charges += 187.9 * (kwh - 200);
                kwh = 200;
            }
            else if (kwh <= 400) {
                charges += 280.6 * (kwh - 300);
                kwh = 300;
            }
            else if (kwh <= 500) {
                charges += 417.7 * (kwh - 400);
                kwh = 400;
            }
            else {
                charges += 670.6 * (kwh - 500);
                kwh = 500;
            }

        }
        System.out.println("전기요금 : " + charges + "원");
    }
}


