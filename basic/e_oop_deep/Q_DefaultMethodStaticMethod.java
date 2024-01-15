package e_oop_deep;

public class Q_DefaultMethodStaticMethod {
    public static void main(String[] args) {
        /*
        인터페이스에 디폴트 메서드, static 메서드 추가(JDK 1.8)

        인터페이스에 발생한 문제
        인터페이스에 새로운 메서드(추상 메서드)를 추가하기 어려움 => 추가하면 인터페이스를 사용한 곳에 모두 구현해야함
        이 문제를 해결하기위해 나온 것이 디폴트 메서드
        
        몸통이 있는 메서드를 추가할 수 있게 해줌
        디폴트 메서드는 인스턴스 메서드(인터페이스 원칙 위반) => 예외 사항

        디폴트 메서드가 기존 메서드와 충돌할 때 해결책

        1. 여러 인터페이스의 디폴트 메서드 간의 충돌
            - 인터페이스를 구현한 클래스에서 디폴트 메서드를 오버라이딩
        2. 디폴트 메서드와 조상 클래스의 메서드 간의 충돌
            - 조상 클래스의 메서드가 상속되고, 디폴트 메서드는 무시된다.
        */
   }
}
interface MyInterface {
    void method();
    default void newMethod() {}
}
