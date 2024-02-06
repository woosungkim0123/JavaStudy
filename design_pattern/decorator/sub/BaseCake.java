package decorator.sub;

/**
 * 장식이 될 케이크의 기본 형태
 */
public class BaseCake implements Cake {
    @Override
    public void decorate() {
        System.out.println("아무것도 없는 상태의 케이크");
    }
}
