public class D_ClassMethodAndInstanceMethod {
    public static void main(String[] args) {
        /*
        클래스 메서드(static 메서드)와 인스턴스 메서드

        인스턴스 메서드
        인스턴스 생성 후, 참조변수.메서드이름() 으로 호출
        인스턴스 변수 사용 여부 O

        클래스 메서드(static 메서드)
        객체생성없이 클래스이름.메서드이름() 으로 호출
        예 : Math.random() => Math 클래스의 static 메서드
        인스턴스 변수 사용 여부 X

        메서드에서 static 사용 여부는 인스턴스 멤버(iv, im) 사용여부 라고 할 수 있다.
        객체 == 인스턴스 멤버(iv, im)의 묶음 == iv 묶음
        클래스메서드는 iv가 필요없음 == 객체가 필요없음

        정리
        변수의 경우 static => 속성(멤버 변수) 중에서 공통 속성에 static을 붙인다.
        메서드의 경우 인스턴스 멤버(iv, im)을 사용하지 않는 메서드에 static을 붙인다.
        근데 어차피 im이 iv를 사용하는 메서드라서 iv를 사용하지 않는 메서드라고 해도 무방
        메서드도 공통으로 사용하는 메서드에 static 붙인다? => X
        */
    }
}
class TestClass {
    int iv; // 인스턴스 변수 (객체 생성 후 사용가능)
    static int cv; // 언제나 사용가능 (객체 생성 안해도 메모리에 올라가 있기 때문)

    // 변수 호출
    void instanceMethod() { // 인스턴스 메서드 : 객체 생성 후 호출가능
        System.out.println(iv);
        System.out.println(cv);
    }
    static void staticMethod() { // 클래스 메서드 : 객체 생성 없이 호출 가능
        // System.out.println(iv); 오류 : 인스턴스 변수를 사용할 수 없다.
        System.out.println(cv); // 클래스 변수 사용 가능
    }
    // 메서드 호출
    void instanceMethod2() {
        instanceMethod();
        staticMethod();
    }
    static void staticMethod2() {
        // instanceMethod(); 오류 발생
        staticMethod();
    }
}
