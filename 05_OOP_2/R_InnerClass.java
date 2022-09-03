public class R_InnerClass {
    public static void main(String[] args) {
        /*
        내부 클래스(inner class)

        클래스 안의 클래스

        장점
        1. 내부 클래스에서 외부 클래스의 멤버들을 쉽게 접근할 수 있다.
        2. 코드의 복잡성을 줄일 수 있다(캡슐화)

        내부 클래스의 종류와 유효범위(scope)는 변수와 동일

        내부 클래스의 제어자는 변수에 사용 가능한 제어자와 동일(원래 클래스는 2(default, public)개 밖에 안되지만 내부 클래스는 4개가 다됨)

        static 멤버를 가질 수 있는 건 static 내부 클래스 뿐
        내부 클래스에 static 멤버가 필요하면 static 내부 클래스로 작성해야함
        static멤버는 객체 생성 없이 사용할 수 있ㅇ터야 하는데 만약 내부클래스가 static이 아니면 모순이 발생함

        static 내부 클래스에서는 외부 클래스의 인스턴스 멤버에 접근할 수 없다.
        final (상수) 인 경우에는 static 가능(많이 붙임)
        => Card 예시에서 하트와 숫자 같은 경우는 한번 정해지면 변경되면 안되서 final 붙이지만 static은 불가, 카드마다 달라야해서
        => CARD_NUM 같은건 상수에 static 붙임(카드 마다 다른 값이 아닌 항상 고정), 상수가 두가지 케이스 있음

        09:00
        */
    }
}

class A { // B의 외부 클래스
    int i = 100;
    class B { // A의 내부 클래스스
        // 객체생성없이 A의 멤버 접근 가능
        void method() {
            System.out.println(i);
        }
    }

    class InstanceInner {} // iv와 비슷
    static class StaticInner {} // cv와 비슷
    void method1() {
        class LocalInner {} // lv와 비슷
    }
}

