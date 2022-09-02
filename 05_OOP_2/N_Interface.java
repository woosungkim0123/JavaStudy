public class N_Interface {
    /*
    인터페이스

    추상 메서드의 집합(프로그래밍 관점) (핵심)
    그 외에도 static 메서드, 상수, 디폴트 메서드 등이 interface의 요소 (부수적)

    구현된 것이 전혀 없는 설계도, 껍데기(모든 멤버가 public)

    추상클래스와 인터페이스 차이
    추상클래스는 일반 클래스인데 추상메서드를 가지고 있는 것이고 인터페이스는 추상메서드만 가지고 있음(다른 것들은 부수적인 것이라 신경 x)
    즉, 추상클래스에는 생성자도 있고 iv, 인터페이스는 멤버변수를 가질 수 없음
    추상클래스는 일부가 미완성, 인터페이스는 구현된 것이 아무것도 없는 것(추상메서드만 적어둔 것이라)

    인터페이스의 조상은 인터페이스만 가능(Object가 최고 조상 아님)
    다중 상속이 가능(추상 메서드는 충돌해도 문제 없음 => 선언부 밖에 없으니까)

    인터페이스 구현
    인터페이스에 정의된 추상 메서드를 완성하는 것
    class 클래스이름 implements 인터페이스이름 {
        인터페이스에 정의된 추상메서드를 모두 구현
    }

    추상클래스는 extends(상속)를 사용해서 완성하는데 인터페이스는 implements(구현)을 사용해서 완성
    implements 사용한다는 것 빼고 추상클래스 완성하는거랑 똑같음

    */


}

interface PlayingCard {
    // 변수는 안됨
    // 모든 인터페이스의 멤버는 public
    // 메서드가 모두 추상메서드
    public static final int SPADE = 1; // 상수 public abstract final 생략 가능
    public abstract String getCardNum();
    String getCardKind(); // public abstract 생략 가능

}

class Unit {}
interface Fightable {
    void move(int x, int y);
    void attack(Unit u);
}

// Fighter 클래스는 Fightable 인터페이스를 구현했다.
class Fighter implements Fightable {
    public void move(int x, int y) {}
    public void attack(Unit u) {}
}
// 일부만 구현하는 경우 abstract 붙여야함
abstract class Fighter1 implements Fightable {
    public void move(int x, int y) {}
}