package strategy.sub;

public class NaverPayStrategy implements PaymentStrategy {
    private String userId;
    private String username;
    private String expired;

    public NaverPayStrategy(String userId, String username, String expired) {
        this.userId = userId;
        this.username = username;
        this.expired = expired;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + "원을 네이버페이로 결제합니다.");
    }
}
