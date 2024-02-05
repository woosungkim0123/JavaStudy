package abstract_factory.sub;



public class IPhone implements Phone {

    @Override
    public void register() {
        System.out.println("아이폰을 등록했습니다.");
    }

    @Override
    public void call() {
        System.out.println("아이폰으로 전화를 겁니다.");
    }
}
