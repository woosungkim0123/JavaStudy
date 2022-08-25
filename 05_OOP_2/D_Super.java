public class D_Super {
    public static void main(String[] args) {
        /*
        참조변수 super(this 거의 같다.)
        객체 자신을 가리키는 참조변수, 인스턴스 메서드(생성자)내에만 존재(static 메서드 내에서 사용불가)
        this는 lv와 iv 구별에 사용
        super는 조상의 멤버와 자신의 멤버를 구별할 때 사용
        */

    }
}

class Parent2 { int x = 10; /* super */}

class Child extends Parent {
    int x = 20;
    void method() {
        System.out.println("x=" + x);
    }
}