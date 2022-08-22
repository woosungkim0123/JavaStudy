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
class Car {
    String color; // 진짜 이름 this.color
    String gearType;
    int door;

    Car() {
        this("white", "auto", 4); // Car2(String color, String gearType, int door) 호출
        // 호출할 때 클래스이름인 Car2 대신에 this 사용
        // 같은 클래스 안에 있는 생성자들끼리 호출할 때는 클래스이름 대신 this 사용(규칙)
        // 호출할 때 생성자의 첫줄에서만 가능
    }
    Car(String color) {
        // 코드 중복을 피하기 위해 주석된 코드대신 다른 생성자를 호출
        // this.color = color
        // gearType = "auto";
        // door = 4;
        this(color, "auto", 4); // Car2(String color, String gearType, int door) 호출
    }
    Car(String color, String gearType, int door) {
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
class InitTest1 {
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
class InitTest2 {
    // 명시적 초기화 (간단)
    static int cv = 1;
    int iv = 1;
    // 초기화 블럭(복잡)
    static { cv = 2;}
    { iv = 2; }
    InitTest2() { // 생성자
        iv = 3;
    }
    /*
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

public class F_Constructor {
    public static void main(String[] args) {
        // 생성자(constructor)
        // 인스턴스가 생성될 때마다 호출되는 인스턴스 초기화 메서드
        Time t = new Time(); // 기본 생성자 호출 ( Time() 이 부분이 생성자를 호출하는 것, 만들어 준적이 없는데? 기본 생성자임 )
        t.hour = 12; // 초기화
        t.minute = 34; // 초기화
        t.hour = 30; // 초기화

        // 한번에 하려면 생성자를 추가해줘야야 사용가능. 우리가 안만들어도 기본적으로 컴파일러가 만들어줌 => 그래서 안만들고도 사용했었음
        Time t1 = new Time(12, 34, 30); // 생성자 호출
        System.out.println(t1.hour);

        /*
        생성자는 기본적으로 메서드고 지켜야할 룰이 있음
        1. 이름이 클래스 이름과 같아야 한다.
        2. 리턴값이 없음 (void 안붙임, 항상 반환값이 없으니까)
        3. 모든 클래스는 반드시 생성자를 가져야한다.(1개 이상)

        기본 생성자
        매개변수가 없는 생성자
        원래 직접 추가해줘야하나 생성자가 클래스 안에 하나도 없을 때 컴파일러가 자동으로 추가해줌, 생성자가 하나라도 있으면 추가 안해줌
        기본 생성자는 항상 만들어야 한다가 원칙 => 컴파일러가 자동 추가해주는 기능에 의지해도되지만 제대로 된 클래스라면 직접 만들어주기

        매개변수가 있는 생성자
        매개변수 있는 생성자를 사용하는 이유는 밖에 쓸 코드를 안으로 감출 수 있어서
        객체를 생성하는 쪽에서는 코드가 간결해짐.
        그리고 클래스를 만들 때 한번만 잘 만들어 놓으면 사용하는 쪽에선 편리하게 여러번 사용할 수 있는 장점
        */

        // 두개가 같은 코드
        Car c1 = new Car();
        c1.color = "white";
        c1.gearType = "auto";
        c1.door = 4;

        Car c = new Car("white", "auto", 4);
        /*
        순서
        1. 참조변수 c가 메모리에 공간 할당당
        2. new 연산자가 객체를 만들어서 메모리 할당(주소 0x100, color, gearType, door) : 객체 생성 (생성자가 객체를 만드는 것이 아닌 new 연산자가 객체를 만듬)
        3. 생성자가 호출 => 객체 메모리에 값이 들어감 : 객체 초기화
        4. c 메모리 공간에 객체 주소 대입

        생성자 this => Car class
        생성자에서 다른 생성자 호출할 때 사용
        이름이 같은 생성자들끼리 하는 일(iv 초기화)이 비슷해서 서로 호출하는 경우가 많음 => 코드 중복 제거

        참조변수 this
        생성자 this = this(), 참조변수 this = this
        비슷하게 생겼지만 전혀 다름. 연관 짓지 말기(별도로 생각)
        인스턴스 자신을 가리키는 참조변수, 인스턴스 메서드(생성자 포함)에서 사용가능
        지역변수(lv)와 인스턴스 변수(iv)를 구별할 때 사용


        변수 초기화
        지역변수는 수동 초기화 해야함(사용전 꼭) => InitTest1

        멤버변수(iv, cv)의 초기화
        1. 명시적 초기화(=) : 간단 초기화
        class Car {
            int door = 4; // 기본형 변수의 초기화
            Engine e = new Engine(); // 참조형 변수의 초기화
            참조형 변수가 가질 수 있는 값은 null(기본값) 아니면 객체주소 둘중 하나
            Engine e; 이런식으로 선언하면 안된다. 참조형에는 객체를 만들어서 넣어줘야함. (엔진자리(참조형 변수)만 있고 엔진(객체)이 비어 있는 꼴)
            참조형 변수는 객체를 넣어주는 것이 초기화. null 넣는 것도 초기화는 맞는데 참조형 초기화라면 객체를 생성해서 넣어줘야함.
        }

        2. 초기화 블럭 : cv 초기화, 복잡한 초기화 => StaticBlockTest Class
        여러 문장을 넣을 수 있음(대입 연산자가 안됨)
        인스턴스 초기화 블럭 : {}
        클래스 초기화 블럭 : static {}

        3. 생성자 : iv 초기화, 복잡한 초기화

        cv, iv 초기화 종류는 총 3가지
        1. 자동 초기화 => 0 으로 초기화
        2. 간단 초기화 => 대입 연산자
        3. 복잡 초기화 => {}(iv초기화, 거의 안씀(신경x)), static{}(cv 초기화), 생성자(iv 초기화)

        초기화 시점 => InitTest2
        클래스 변수 초기화 시점 : 클래스가 처음 로딩될 때 단 한번 (클래스가 메모리에 올라갈 때)
        인스턴스 변수 초기화 시점 : 인스턴스가 생성될 때 마다
        */
    }
}
