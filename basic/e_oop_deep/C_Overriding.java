package e_oop_deep;

import java.io.IOException;
import java.sql.SQLDataException;

public class C_Overriding {
    public static void main(String[] args) {
        /*
        (메서드)오버라이딩

        override(덮어쓰다)
        상속받은 조상의 메서드를 자신에 맞게 변경하는 것
        내용(구현부, {})만 변경가능, 선언부는 불가능

        조건 3가지
        1. 선언부(반환 타입, 메서드 이름, 매개변수 목록)가 조상 클래스의 메서드와 일치해야 한다.
        2. 접근 제어자를 조상클래스의 메서드보다 좁은 범위로 변경할 수 없다.
            => 접근 제어자(public, protected, private, default)
        3. 예외는 조상 클래스의 메서드보다 많이 선언할 수 없다.
            => 같거나 적어야함

        오버로딩과 오버라이딩은 이름만 비슷하지 서로 다름
        오버로딩 : 이름이 같을 뿐 기존에 없는 새로운 메서드를 정의하는 것(상속과 관계가 없음)
        오버라이딩 : 상속받은 메서드의 내용을 변경하는 것
        */

    }
}
class Point1 {
    int x;
    int y;

    String getLocation() {
        return "x :" + x + ", y :" + y;
    }
}
class Point3D extends Point1 {
    int z;
    // 조상 메서드를 Override
    String getLocation() {
        return "x :" + x + ", y :" + y + ", z : " + z;
    }
}
class Parent_Ex {
    void method() throws IOException, SQLDataException { // 예외선언 2개

    }
}
class Child_Ex extends Parent_Ex{
    void method() throws IOException { // 예외선언 1개

    }
}