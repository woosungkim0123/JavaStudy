package strategy.sub;

public class KakaoPayStrategy implements PaymentStrategy {
    private String userId;
    private String expired;
    private String cvc;

    public KakaoPayStrategy(String userId, String expired, String cvc) {
        this.userId = userId;
        this.expired = expired;
        this.cvc = cvc;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + "원을 카카오페이로 결제합니다.");
    }
}
