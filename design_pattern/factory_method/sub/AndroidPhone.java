package factory_method.sub;

public class AndroidPhone implements Phone {

    @Override
    public void register() {
        System.out.println("안드로이드폰을 등록했습니다.");
    }

    @Override
    public void call() {
        System.out.println("안드로이드폰으로 전화를 겁니다.");
    }
}
