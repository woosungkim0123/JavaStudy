package decorator.sub;

/**
 * 장식자 추상 클래스
 */
public abstract class CakeDecorator implements Cake {
    private Cake cake;

    public CakeDecorator(Cake cake) {
        this.cake = cake;
    }

    @Override
    public void decorate() {
        cake.decorate(); // 위임
    }
}
