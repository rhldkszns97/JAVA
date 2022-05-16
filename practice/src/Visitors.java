import java.util.Scanner;

public class Visitors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        V1 v1 = new V1();
        V2 v2 = new V2();
        V3 v3 = new V3();
        v1.run(scanner);
        v2.run(scanner);
        v3.run(scanner);
        scanner.close();
    }
}


class V1 {
    int a = 2, b=1;

    void run(Scanner scanner) {
        System.out.println("[인공지능 프로그램 V1]");
        System.out.println("==============================");
        System.out.print("[System] 예측에 영향을 주는 원인(광고비)의 값을 알려주세요 (단위 원) : ");
        int input = scanner.nextInt();
        System.out.println("[안내] 입력된 광고비는 1000 원 입니다.");
        System.out.println("[안내] AI의 예측(클릭 수)은 " + (a*input+b) + "회 입니다.");
        System.out.println();
    }
}

class V2 {

    void run(Scanner scanner) {
        System.out.println("[인공지능 프로그램 V2]");
        System.out.println("==============================");
        System.out.print("[System] a 값을 입력하여 주세요 : ");
        int a = scanner.nextInt();
        System.out.print("[System] b 값을 입력하여 주세요 : ");
        int b = scanner.nextInt();
        System.out.println("[안내] 입력된 '광고비'는 다음과 같습니다.");
        double[] input = new double[4];
        for (int i=0; i<4; i++) {
            System.out.print((i+1) + " 번째) ");
            input[i] = scanner.nextDouble();
        }
        System.out.println("[안내] AI의 '웹 페이지 방문자' 예측 결과는 다음과 같습니다.");
        for (int i=0; i<4; i++) {
            System.out.println(i + " 번째 예측) " + (a*input[i]+b) + "회 방문");
        }
        System.out.println();
    }
}

class V3 {
    int a=2,b=1;

    void run(Scanner scanner) {
        System.out.println("[인공지능 프로그램 V3]");
        System.out.println("==============================");
        System.out.println("[안내] 인공지능 프로그램에 할당된 데이터");
        double[] input = {374,385,375,401};
        for (int i = 0; i < 4; i++) {
            System.out.println((i + 1) + "번 째 데이터) [실제값] 웹 페이지 방문자 수 : " + input[i] +
                    " [인공지능 예측값] 웹 페이지 방문자 수 : " + (a*input[i]+b));
        }
        double sum = 0;
        for (int i = 0; i < 4; i++) {
            double dif = input[i] - (a * input[i] + b);
            System.out.println("[" + i + " 번째 데이터] 실제 값과 예측값의 오차 : " + dif);
            System.out.println("[안내] 오차의 제곱 : " + Math.pow(dif,2));
            sum += Math.pow(dif,2);
        }

        System.out.println("==============================");
        System.out.println("[안내] 인공지능 프로그램의 성능(오차의 제곱 합) : " + sum);

    }
}