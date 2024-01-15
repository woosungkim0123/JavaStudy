package e_oop_deep;

public class D_Super {
    public static void main(String[] args) {
        /*
        참조변수 super(this 거의 같다.)
        객체 자신을 가리키는 참조변수, 인스턴스 메서드(생성자)내에만 존재(static 메서드 내에서 사용불가)
        this는 lv와 iv 구별에 사용
        super는 조상의 멤버와 자신의 멤버를 구별할 때 사용
        */
        Child c = new Child();
        c.method();

        /*
        super()는 super는 다름
        super()는 조상의 생성자를 호출해서 초기화

        모든 생성자의 첫 줄에 반드시 다른 생성자를 호출해야 한다. 그렇지 않으면 컴파일러가 생성자의 첫 줄에 super();를 삽입 => PointTest
       */

    }
}

class Parent2 {
    int x = 10; // super.x
    int y = 30;
}

class Child extends Parent2 {
    int x = 20; // this.x
    void method() {
        System.out.println("x=" + x); // 가까운쪽 선택 => this.x
        System.out.println("this.x=" + this.x);
        System.out.println("super.x=" + super.x);

        // 상속을 받았으니 super.x, this.x가 가능(조상꺼긴 하지만 내꺼기도 함)
        System.out.println("y=" + y);
        System.out.println("this.y=" + this.y);
        System.out.println("super.y=" + super.y);
    }
}

class PointParent {
    int x, y;

    PointParent(int x, int y) {
        this.x = this.x;
        this.y = this.y;
    }
}
class PointChild extends PointParent {
    int z;

    PointChild(int x, int y, int z) {
        /*
        잘못된 방식 (조상의 멤버를 초기화 하면 안된다)
        this.x = x;
        this.y = y;
        */
        super(x, y); // 조상클래스의 생성자 PointParent(int x, int y)를 호출
        // ps. 조상님 죄송하지만 조상님이 선언하신 멤버는 조상님이 초기화 해주세요
        this.z = z; // 자신의 멤버 초기화
    }
}

class PointTest { // 컴파일시 extends Object
    int x;
    int y;
    PointTest() {
        this(0, 0); // 생성자 호출 => 조건 만족
    }
    PointTest(int x, int y) {
        // 컴파일시 super() 추가
        // super(); // Object(); 생성자 호출 => 조건만족
        this.x = x;
        this.y = y;
    }
}