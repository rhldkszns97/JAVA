import java.util.Scanner;

public class MyStorage {
    // showMenu() 메서드가 호출되면 프로그램의 기능들을 보여줄 수 있도록 정의합니다.
    static void showMenu(){
        // 사용자를 위해 해당 기능들 앞에 번호를 넣어 알아보기 쉽도록 합니다.
        //TODO:
        System.out.println("1. 물건 정보(제품명) 등록하기");
        System.out.println("2. 물건 정보(제품명) 등록 취소하기");
        System.out.println("3. 물건 넣기 (제품 입고)");
        System.out.println("4. 물건 빼기 (제품 출고)");
        System.out.println("5. 재고 조회");
        System.out.println("6. 프로그램 종료");
        System.out.println("------------------------------");
    }

    // selectMenu() 메서드는 사용자가 프로그램의 기능을 선택할 수 있도록 합니다.
    // 인자는 입력을 받기 위한 Scanner 클래스의 객체(s) 를 전달받습니다.
    static int selectMenu(Scanner s){
        // 해당 메서드가 호출되면 프로그램의 기능을 호출할 수 있도록 안내 메시지를 출력합니다.
        // 프로그램의 기능은 번호(정수)로 전달받습니다.
        // 해당 프로그램은 사용자가 선택한 번호(select)를 반환하도록 합니다.
        //TODO:
        System.out.print("[System] 원하는 기능의 번호를 입력하세요 : ");
        return s.nextInt();
    }

    static void prod_input(Scanner s, String[] products) {
        boolean flag = true;

        for (int i=0; i< products.length; i++) {
            if (products[i].equals("등록 가능")) {
                System.out.print("[System] 제품 등록을 원하는 제품명을 입력하세요 : ");
                products[i] = s.next();
                System.out.println("[System]등록이 완료됬습니다.");
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println("매장 및 창고가 꽉 차 있습니다.");
        }

        System.out.println("[System] 현재 등록된 제품 목록 ▼");

        for (int i=0; i< products.length; i++) {
            System.out.println("> " + products[i]);
        }

        System.out.println("------------------------------");
    }

    static void prod_remove(Scanner s, String[] products, int[] counts) {
        System.out.print("[System] 제품 등록 취소를 원하는 제품명을 입력하세요 : ");
        String product = s.next();
        boolean flag = true;
        for (int i=0; i< products.length; i++) {
            if (products[i].equals(product)) {
                products[i] = "등록 가능";
                System.out.println("[System] 제품 취소가 완료됬습니다.");
                counts[i] = 0;
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println("제품명이 등록되어 있지 않습니다.");
        }
        System.out.println("------------------------------");
    }

    static void prod_amount_add(Scanner s, String[] products, int[] counts) {
        System.out.println("[System] 물건의 수량을 추가합니다.(입고)");
        System.out.println("[System] 현재 등록된 제품 및 수량 ▼");

        for (int i=0; i< products.length; i++) {
            System.out.println("> " + products[i] + " : " + counts[i]+"개");
        }

        System.out.print("[System] 수량을 추가할 제품명을 입력하세요 : ");
        String product = s.next();
        System.out.print("[System] 추가할 수량을 입력해주세요 : ");
        int count = s.nextInt();

        boolean flag = true;
        for (int i=0; i< products.length; i++) {
            if (products[i].equals(product)) {
                counts[i] += count;
                System.out.println("[Clear] 정상적으로 제품의 수량 추가가 완료되었습니다.");
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println("제품명이 등록되어 있지 않습니다. 먼저 제품명을 등록하세요.");
        }

        System.out.println("[System] 현재 등록된 제품 및 수량 ▼");

        for (int i=0; i< products.length; i++) {
            System.out.println("> " + products[i] + " : " + counts[i]+"개");
        }

        System.out.println("------------------------------");
    }

    static void prod_amount_decrease(Scanner s, String[] products, int[] counts) {
        System.out.println("[System] 제품의 출고를 진행합니다.");
        System.out.println("[System] 현재 등록된 물건 목록 및 수량 ▼");

        for (int i=0; i< products.length; i++) {
            System.out.println("> " + products[i] + " : " + counts[i]+"개");
        }

        System.out.print("[System] 출고를 진행할 제품명을 입력하세요 : ");
        String product = s.next();
        System.out.print("[System] 원하는 출고량을 입력하세요 : ");
        int count = s.nextInt();

        boolean flag = true;
        for (int i=0; i< products.length; i++) {
            if (products[i].equals(product)) {
                counts[i] -= count;
                System.out.println("[Clear] 출고가 완료되었습니다.");
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println("등록된 제품명이 없어 출고에 실패했습니다. 먼저 제품명을 등록하세요.");
        }

        System.out.println("[System] 현재 등록된 제품 및 수량 ▼");

        for (int i=0; i< products.length; i++) {
            System.out.println("> " + products[i] + " : " + counts[i]+"개");
        }

        System.out.println("------------------------------");

    }

    static void prod_search(String[] products, int[] counts) {
        System.out.println("[System] 현재 등록된 제품 및 수량 ▼");

        for (int i=0; i< products.length; i++) {
            System.out.println("> " + products[i] + " : " + counts[i]+"개");
        }
    }

    // main() 메서드는 점장님의 이름을 인자(args)로 전달 받습니다.
    public static void main(String[] args){
        // 해당 프로그램의 버전, 점장님의 이름, 프로그램의 기능을 출력합니다.
        //TODO:
        System.out.println("[Item_Storage_V1]");
        System.out.println("------------------------------");
        System.out.println("[System] 코드스테이츠 점장님 어서오세요.");
        System.out.println("[System] 해당 프로그램의 기능입니다.");

        // 위에서 정의한 메서드들을 알맞게 배치하여 줍니다.
        // 사용자의 기능 입력을 받기 위한 Scanner() 메서드를 사용합니다.
        Scanner scanner = new Scanner(System.in);
        String[] products = new String[]{"등록 가능","등록 가능","등록 가능","등록 가능","등록 가능"};
        int[] counts = new int[5];

        // 프로그래밍 요청사항 6번을 확인해 보세요.
        // 사용자가 특정 번호를 입력하기 전 까지 프로그램은 종료되지 않도록 합니다.
        // 사용자의 입력에 따라 프로그램의 기능들이 실행될 수 있도록 합니다.
        // switch() 를 사용하여 줍니다.
        boolean stop = false;
        while (!stop) {
            showMenu();
            int num = selectMenu(scanner);
            switch (num){
                case(1): prod_input(scanner, products); break;
                case(2): prod_remove(scanner, products, counts); break;
                case(3): prod_amount_add(scanner, products, counts); break;
                case(4): prod_amount_decrease(scanner, products, counts); break;
                case(5): prod_search(products,counts); break;
                case(6): {
                    System.out.println("[System] 프로그램을 종료합니다.");
                    System.out.println("감사합니다.");
                    stop = true;
                    break;
                }
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }
}