public class Order {
    private String customerName;
    private String shopName;
    private String foodName;

    /**
     *@Order():주문 정보를 저장합니다.
     **/
    Order(String customerName, String shopName, String foodName) {
        this.customerName = customerName;
        this.shopName = shopName;
        this.foodName = foodName;
    }
}