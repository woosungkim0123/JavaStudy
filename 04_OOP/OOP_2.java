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
class Time {
    int hour;
    int minute;
    int second;
    // 똑같은 이름이 두개있음 => 생성자 오버로딩
    Time() {}  // 매개변수 없는 생성자
    Time(int hour1, int minute1, int second1) { // 매개변수 있는 생성자
        // 인스턴스 초기화 작업
        hour = hour1;
        minute = minute1;
        second = second1;
    }

}
class Car2 {
    String color; // 진짜 이름 this.color
    String gearType;
    int door;

    Car2() {
        this("white", "auto", 4); // Car2(String color, String gearType, int door) 호출
        // 호출할 때 클래스이름인 Car2 대신에 this 사용
        // 같은 클래스 안에 있는 생성자들끼리 호출할 때는 클래스이름 대신 this 사용(규칙)
        // 호출할 때 생성자의 첫줄에서만 가능
    }
    Car2(String color) {
        // 코드 중복을 피하기 위해 주석된 코드대신 다른 생성자를 호출
        // this.color = color
        // gearType = "auto";
        // door = 4;
        this(color, "auto", 4); // Car2(String color, String gearType, int door) 호출
    }
    Car2(String color, String gearType, int door) {
        this.color = color;
        this.gearType = gearType;
        this.door = door;
    }
    String add () {
        return color + gearType; // this.color, this.gearType이 원래 이름, this가 생략된 것
    }
    static long add1 (long a, long b) { // lv
        return a + b; // 여긴 지역변수(lv)
        // static 메서드는 객체 생성 없이 호출 하기 때문에 iv 사용불가 => this 사용 불가 (this가 객체 자신을 의미하기 때문, 객체가 있을 수도 있고 없을 수도 있음)
    }
}
class InitTest {
    int x; // 자동 초기화
    int y = x;
    
    void method1() {
        int i; // 지역변수
        // int j = i; 에러 => 지역변수를 초기화 하지않고 사용
        // 값을 몰라서 에러가 남
        // 호출스택 메모리가 재사용이 빈번한 메모리, 메서드가 호출될 때마다 메모리 공간을 0을 초기화하면 성능이 떨어짐
        // 성능을 높이려고 새로운 값으로 덮어쓰는 방식을 사용함
        // 지역변수는 메서드가 호출되서 작업하는 동안만 존재하기 때문에 생명주기가 굉장히 짧음 => 이걸 0으로 초기화하면 성능이 떨어짐
        // 그래서 새로운 값으로 덮어씀(초기화) => 옛날에 다른데 쓰던 값을 덮는 것. 다른 데 쓰던 값은 뭔지는 모름
        // 그래서 i가 무슨 값인지 모르는 것 => 수동 초기화 필요
        // 인스턴스 변수는 유지기간이 길다보니 초기화하고 써도 괜찮(자동 초기화)
        // 또 다른 이유는 객체는 여러 변수를 묶어놓은 것이다 보니 변수를 다 0으로 초기화하려면(배열 등) 초기화 할 변수가 너무 많음


    }
}
public class OOP_2 {
    public static void main(String[] args) {
        /*
        클래스 메서드(static 메서드)와 인스턴스 메서드 => TestClass 보기

        인스턴스 메서드
        인스턴스 생성 후, 참조변수.메서드이름() 으로 호출
        인스턴스 변수 사용 여부 O

        클래스 메서드(static 메서드)
        객체생성없이 클래스이름.메서드이름() 으로 호출
        예 : Math.random() => Math 클래스의 static 메서드
        인스턴스 변수 사용 여부 X

        메서드에서 static을 사용 여부는 인스턴스 멤버(iv, im) 사용여부 라고 할 수 있다.
        객체 == 인스턴스 멤버(iv, im)의 묶음 == iv 묶음
        클래스메서드는 iv가 필요없음 == 객체가 필요없음

        정리
        변수의 경우 static을 언제 붙임? => 속성(멤버 변수) 중에서 공통 속성에 static을 붙인다.
        메서드의 경우 인스턴스 멤버(iv, im)을 사용하지 않는 메서드에 static을 붙인다. (근데 어차피 im이 iv를 사용하는 메서드)
        메서드도 공통으로 사용하는 메서드에 static 붙인다? => X

        (메서드)오버로딩 (overloading : 과적하다)
        정확한 명칭은 메서드 오버로딩, 오버로딩에 종류가 몇개 있음, c++에서는 연산자 오버로딩을 지원함
        자바에도 연산자 오버로딩이 있음 => +가 덧셈, 부호, 문자열 결합에 쓰임 (자바에서 제공은 하지만 따로 구현은 못함)
        그래서 자바에서 구현을 못하기 때문에 오버로딩이라고 하면 메서드 오버로딩을 의미한다.
        원래 쌓아야하는 것보다 많이 쌓음 => 기본이 메서드 : 메서드이름 = 1 : 1 인데 n : 1 정의
        한 클래스 안에 같은 이름의 메서드 여러 개 정의하는 것
        매개변수 타입은 다르고 코드가 다르더라도 의미상으로 같은 작업을 수행하는 경우 오버로딩을 함

        오버로딩의 대표적인 예 println
        매개변수가 다 다름
        void println()
        void println(boolean x)
        void println(long x)
        ...
        컴파일러가 매개변수가 어떤 타입인지 확인해서 거기에 맞는 메서드랑 연결해줌

        오버로딩 성립조건
        1. 메서드 이름이 같아야한다.
        2. 매개변수 개수 or 타입이 달라야 한다.
        3. 반환 타입은 영향없다.

        오버 로딩 아님 (메서드 중복정의 => 에러)
        int add(int a, int b) {return a + b;}
        int add(int x, int y) {return x + y;}

        반환타입만 다르면 오버로딩 아님 (메서드 중복정의 => 에러)
        int add(int a, int b) {return a + b;}
        long add(int x, int y) {return x + y;}

        오버로딩 성립
        long add(int a, long b) {return a + b;}
        long add(long a, int b) {return a + b;}
        add(3, 3L) 호출 시 1번 호출
        여기서 조심해야하는 것
        add(3, 3) 호출 시 둘 중 어떤 것을 호출할 지 모름 => ambiguous(모호하다) 에러
        */


        // 생성자(constructor)
        // 인스턴스가 생성될 때마다 호출되는 인스턴스 초기화 메서드
        Time t = new Time(); // 기본 생성자 호출 ( Time() 이 부분이 생성자를 호출하는 것, 만들어 준적이 없는데? 기본 생성자임 )
        t.hour = 12; // 초기화
        t.minute = 34; // 초기화
        t.hour = 30; // 초기화

        // 한번에 가능
        // 생성자를 추가해줘야야 사용가능. 우리가 안만들어도 기본적으로 컴파일러가 만들어줌 => 그래서 안만들고도 사용했었음
        Time t1 = new Time(12, 34, 30); // 생성자 호출
        System.out.println(t1.hour);
        /*
        생성자는 기본적으로 메서드고 지켜야할 룰이 있음
        1. 이름이 클래스 이름과 같아야 한다.
        2. 리턴값이 없음(void 안붙임, 항상 반환값이 없으니까)
        3. 모든 클래스는 반드시 생성자를 가져야한다.(1개 이상)

        기본 생성자
        매개변수가 없는 생성자
        원래 직접 추가해줘야하나 생성자가 클래스 안에 하나도 없을 때 컴파일러가 자동으로 추가해줌, 생성자가 하나라도 있으면 추가 안해줌
        기본 생성자는 항상 만들어야 한다가 원칙 => 컴파일러가 자동 추가해주는 기능에 의지해도되지만 제대로 된 클래스라면 직접 만들어주기

        매개변수가 있는 생성자
        매개변수 있는 생성자 하는 이유는 밖에 쓸 코드를 안으로 감춘 것뿐
        객체를 생성하는 쪽에서는 코드가 간결해짐.
        그리고 클래스를 만들 때 한번만 잘 만들어 놓으면 사용하는 쪽에선 편리하게 여러번 사용할 수 있는 장점

        두개가 같은 코드
        Car c = new Car();
        c.color = "white";
        c.gearType = "auto";
        c.door = 4;

        Car c = new Car("white", "auto", 4);

        순서
        1. 참조변수 c가 메모리에 공간 할당당
        2. new 연산자가 객체를 만들어서 메모리 할당(주소 0x100, color, gearType, door) : 객체 생성 (생성자가 객체를 만드는 것이 아닌 new 연산자가 객체를 만듬)
        3. 생성자가 호출 => 객체 메모리에 값이 들어감 : 객체 초기화
        4. c 메모리 공간에 객체 주소 대입

        생성자 this
        생성자에서 다른 생성자 호출할 때 사용

        이름이 같은 생성자들끼리 하는 일(iv 초기화)이 비슷해서 서로 호출하는 경우가 많음 => 코드 중복 제거

        참조변수 this
        생성자 this = this(), 참조변수 this = this
        비슷하게 생겼지만 전혀 다름. 연관 짓지 말기(별도로 생각)
        인스턴스 자신을 가리키는 참조변수
        인스턴스 메서드(생성자 포함)에서 사용가능
        지역변수(lv)와 인스턴스 변수(iv)를 구별할 때 사용
        
        변수 초기화
        지역변수는 수동 초기화 해야함(사용전 꼭) => InitTest
        
        멤버변수(iv, cv)의 초기화

        1. 명시적 초기화(=) : 간단 초기화
        class Car {
            int door = 4; // 기본형 변수의 초기화
            Engine e = new Engine(); // 참조형 변수의 초기화
            참조형 변수가 가질 수 있는 값은 null(기본값) 아니면 객체주소 둘중 하나
            Engine e; 이런식으로 선언하면 안된다. 참조형에는 객체를 만들어서 넣어줘야함. (엔진자리(참조형 변수)만 있고 엔진(객체)이 비어 있는 꼴)
            참조형 변수는 객체를 넣어주는 것이 초기화. null 넣는 것도 초기화는 맞는데 참조형 초기화라면 객체를 생성해서 넣어줘야함.
       }

       2. 초기화 블럭 : cv 초기화, 복잡한 초기화
       여러 문장을 넣을 수 있음(대입 연산자가 안됨)
       인스턴스 초기화 블럭 : {}
       클래스 초기화 블럭 : static {}

       3. 생성자 : iv 초기화, 복잡한 초기화

       cv, iv 초기화 종류는 총 3가지
       1. 자동 초기화 => 0 으로 초기화
       2. 간단 초기화 => 대입 연산자
       3. 복잡 초기화 => {}(iv초기화, 거의 안씀(신경x)), static{}(cv 초기화), 생성자(iv 초기화)

        초기화 시점
        클래스 변수 초기화 시점 : 클래스가 처음 로딩될 때 단 한번 (클래스가 메모리에 올라갈 때)
        인스턴스 변수 초기화 시점 : 인스턴스가 생성될 때 마다

         클래스가 생성되면 cv가 먼저 초기화 (1번)
         cv = 0 (자동)
         cv = 1 (명시적 초기화)
         cv = 2 (초기화 블럭)

         iv 초기화 (객체가 만들어 질때마다)
         iv = 0; (자동)
         iv = 1; (명시적)
         iv = 2; (인스턴스 초기화블럭);
         iv = 3; (생성자)
       */


    }
    class StaticBlockTest {
        // 배열 arr을 난수로 채우고 싶음
        static int[] arr = new int[10]; // 간단 초기화
        // cv 복잡 초기화
        static {
            for(int i = 0; i < arr.length; i++) {
                arr[i] = (int)(Math.random() * 10) + 1;
            }
        }
    }
    class InitTest {
        // 명시적 초기화 (간단)
        static int cv = 1;
        int iv = 1;
        // 초기화 블럭(복잡)
        static { cv = 2;}
        { iv = 2; }
        InitTest() { // 생성자
            iv = 3;
        }
    }
}
