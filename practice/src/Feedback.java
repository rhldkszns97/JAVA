public class Feedback {
    private String customerName;
    private String shopName;
    private String foodName;
    private int grade;
    String text = "";

    /**
     * @Feedback() : 정보를 저장합니다
     */
    Feedback(String customerName, String shopName, String foodName, int grade) {
        this.customerName = customerName;
        this.shopName = shopName;
        this.foodName = foodName;
        this.grade = grade;
    }

    /**
     * @getStars() : 사용자가 입력한 점수가 별점으로 전환
     */
    void getStars() {
        for (int i=0; i<grade; i++) {
            text += "★";
        }
    }


    /**
     * @printInfo() : 출력
     */
    void printInfo() {
        getStars();
        System.out.println(customerName + " [고객님] ");
        System.out.println("-------------------------");
        System.out.println("주문 매장 : " + shopName);
        System.out.println("주문 메뉴 : " + foodName);
        System.out.println("별점 : " + text);
    }
}