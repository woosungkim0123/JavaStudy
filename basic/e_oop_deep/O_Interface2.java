package e_oop_deep;

public class O_Interface2 {
    public static void main(String[] args) {
        /*
        인터페이스를 이용한 다형성

        인터페이스 타입 매개변수는 인터페이스 구현한 클래스의 객체만 가능(해당 인터페이스를 구현한 애들만 들어와!)

        인터페이스를 메서드의 리턴타입으로 지정할 수 있다.(해당 인스턴스를 구현한 클래스의 인스턴스를 반환

        */
        Human h = new Human();
        h.move(100, 200);
        Human h2 = new Human();
        h.attack(h2);

        Action ac = h.getAction(); // 반환 타입이 리턴 반환타입과 일치해야함(기본형도 마찬가지)

        Unit2 u1 = new Human();
        // u1.attack(h2); Unit2 안에 attack이 없음(다형성)

        Action a1 = new Human();
        a1.move(100, 200);
        a1.attack(new Human());
        // h4.stop() 에러
    }

}
abstract class Unit2 {
    int x, y;
    abstract void move(int x, int y);
    void stop() { System.out.println("멈춥니다");}
}
interface Action { // 인터페이스의 모든 메서드는 public, abstract
    void move(int x, int y);
    void attack(Action a);
}
class Human extends Unit2 implements Action {
    // Action은 부모는 아닌데 부모나 다름 없음 => 다중상속(충돌문제) => interface는 몸통이 없어서 선언부가 충돌해도 상관없음(Unit2 사용)
    // 인터페이스를 통해서 다중 상속의 문제를 해결하면서 다중상속과 같은 효과를 냄

    public void move(int x, int y) { // 오버라이딩시 조상(pulic 생략된 것)보다 접근제어자가 좁으면 안된다.(default는 public 범위가 좁음)
        System.out.println("["+x+","+y+"]로 이동");
    }
    public void attack(Action a) {
        System.out.println(a + "를 공격");
    }
    Action getAction() { // 인터페이스를 구현한 애를 반환 => 왜 인터페이스 타입으로? 애매하게(추상화)
        // Action을 구현한 다른 클래스가 있다면 그걸 쓸 수도 있으니까
        Human h3 = new Human();
        return h3; // (Action) h3 가 원래 의미 => 다형성 형변환
        // 정리 : 반환타입이 인터페이스일때는 그 인터페이스를 구현한 객체를 반환한다.
    }
}