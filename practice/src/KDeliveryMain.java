import java.util.Scanner;

// 클래스를 정의 합니다.
public class KDeliveryMain {
    /**
     * 음식점 등록 개수, 음식 주문 가능 횟수, 리뷰 등록 가능 횟수 정의
     */
    private static int SHOP_MAX = 5;
    private static int ORDER_MAX = 5;
    private static int FEEDBACK_MAX = ORDER_MAX;


    /**
     * 배열을 담을 수 있는 객체 생성
     * 사용 범위, 객체 타입, 객체 이름
     */
    private Shop[] shops = new Shop[SHOP_MAX];
    private Order[] orders = new Order[ORDER_MAX];
    private Feedback[] feedbacks = new Feedback[FEEDBACK_MAX];

    // 해당 변수를 제어하는 Idx변수를 정의하고 초기화
    int shopIdx = 0;
    int orderIdx = 0;
    int feedbackIdx = 0;

    Scanner s = new Scanner(System.in); // 사용자의 입력을 받는 객체 생성

    /**
     * @KDeliveryMainV1() : 매장 정보, 주문 정보, 리뷰 정보 초기화
     * initValues() 메서드 사용
     * */


    /**
     * @initValues() : 객체에 저장될 수 있는 크기 지정
     * SHOP_MAX, ORDER_MAX, FEEDBACK_MAX = 5
     * */


    /**
     * @close() : 프로그램 종료를 위해 사용되는 메서드
     * 사용자가 종료를 선언하면 동작합니다.
     * main()에서 활용됩니다.
     * */

    void close() {
        System.out.println("[안내] 이용해주셔서 감사합니다.");
        System.exit(0);
    }


    /**
     * selectMainMenu() : 기능을 나열하며, 사용자가 원하는 기능을 정수로 받습니다.
     */
    public int selectMainMenu() {
        System.out.println();
        System.out.println("  [치킨의 민족 프로그램 V1] ");
        System.out.println("-------------------------");
        System.out.println("1) [사장님용] 음식점 등록하기");
        System.out.println("2) [고객님과 사장님용] 음식점 별점 조회하기");
        System.out.println("3) [고객님용] 음식 주문하기");
        System.out.println("4) [고객님용] 별점 등록하기");
        System.out.println("5) 프로그램 종료하기");
        System.out.println("-------------------------");
        System.out.println("[시스템] 무엇을 도와드릴까요?");
        System.out.print(">>> ");
        int num = s.nextInt();
        s.nextLine();
        return num;
    }

    /**
     * @selectAddShopMenu() : 음식점의 정보를 등록합니다.
     * @shops : 가게 정보를 저장합니다.
     * @shopIdx : 가게 정보의 인덱스
     */
    public void selectAddShopMenu() {
        System.out.println("[안내] 반갑습니다. 가맹주님!");
        System.out.println("[안내] 음식점 상호는 무엇인가요?");
        System.out.print(">>> ");
        String name = s.nextLine();


        System.out.println("[안내] 대표 메뉴 이름은 무엇인가요?");
        System.out.print(">>> ");
        String menu = s.nextLine();

        System.out.println("[안내] 해당 메뉴 가격은 얼마인가요?");
        System.out.print(">>> ");
        int price = s.nextInt();

        Shop shop = new Shop(name);
        shop.initValues(menu, price);

        shop.addFood();

        shops[shopIdx] = shop;
        shopIdx += 1;
    }

        /**
         * @Shop.java 의 Shop 클래스를 활용한 객체 생성
         * @public 클래스 : 동일 패키지 및 다른 패키지에서 사용가능
         * @addFood() : Shop.java 의 Shop 클래스의 addFood() 메서드
         * 해당 메서드는 매장명, 음식명, 가격을 입력받아 객체에 저장
         * 값이 저장될 때 마다 shopIdx 값 증가
         */



    /**
     * @selectDashboardMenu() : 해당 메서드는 등록된 가게 정보를 출력합니다.
     * Feedback.java 파일의 클래스 및 메서드를 활용합니다.
     * */
    void selectDashboardMenu() {
        for (int i = 0; i < feedbackIdx; i++) {
            feedbacks[i].printInfo();
        }
    }


    /**
     * @selectOrderMenu() : 주문 기능
     * 사용자의 입력을 받아 orders 객체에 저장
     */
    void selectOrderMenu() {
        System.out.println("[안내] 주문자 이름은 무엇인가요?");
        System.out.print(">>> ");
        String customerName = s.nextLine();
        System.out.println("[안내] 음식점 상호는 무엇인가요?");
        System.out.print(">>> ");
        String shopName = s.nextLine();
        System.out.println("[안내] 주문하신 음식 이름은 무엇인가요?");
        System.out.print(">>> ");
        String foodName = s.nextLine();

        Order order = new Order(customerName, shopName, foodName);
        System.out.println("[안내] " + customerName + "님!");
        System.out.println("[안내] " + shopName + " 매장에 " + foodName + " 주문이 완료되었습니다.");
        System.out.println();
        orders[orderIdx] = order;
        orderIdx += 1;
    }

    /**
     * @selectFeedbackMenu() : 메뉴의 피드백을 입력받는 기능
     */
    void selectFeedbackMenu() {
        System.out.println("[안내] 고객님! 별점 등록을 진행합니다.");
        System.out.println("[안내] 주문자 이름은 무엇인가요?");
        System.out.print(">>> ");
        String customerName = s.nextLine();
        System.out.println("[안내] 음식점 상호는 무엇인가요?");
        System.out.print(">>> ");
        String shopName = s.nextLine();
        System.out.println("[안내] 주문하신 음식 이름은 무엇인가요?");
        System.out.print(">>> ");
        String foodName = s.nextLine();
        System.out.println("[안내] 음식맛은 어떠셨나요? (1점 ~ 5점)");
        System.out.print(">>> ");
        int grade = s.nextInt();
        s.nextLine();
        System.out.println("[안내] 리뷰 등록이 완료되었습니다.");

        Feedback feedback = new Feedback(customerName,shopName,foodName,grade);
        feedbacks[feedbackIdx] = feedback;
        feedbackIdx += 1;
    }

    public static void main(String[] args) {
        KDeliveryMain kdeliveryMain = new KDeliveryMain();
        while (true) {
            int num = kdeliveryMain.selectMainMenu();
            switch (num) {
                case (1): kdeliveryMain.selectAddShopMenu(); break;
                case (2): kdeliveryMain.selectDashboardMenu(); break;
                case (3): kdeliveryMain.selectOrderMenu(); break;
                case (4): kdeliveryMain.selectFeedbackMenu(); break;
                case (5): kdeliveryMain.close();
                default:
                    System.out.println(" 1~5 사이의 값을 입력해주세요");
            }
        }
    }
} 