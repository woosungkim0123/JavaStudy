package e_oop_deep;

public class J_Polymorphism {
    public static void main(String[] args) {
        /*
        다형성(polymorphism)

        여러 가지 형태를 가질 수 있는 능력(사전 의미)
        조상 타입 참조 변수로 자손 타입 객체를 다루는 것

        */
        // 이때까지는 일치 하도록 사용
        TV t = new TV();
        SmartTV s = new SmartTV();

        // 다형성이라는 것은 타입이 불일치하더라도 OK
        TV t1 = new SmartTV(); // 조상 타입 참조 변수로 자손 타입 객체 다루기

        /*
        객체와 참조변수의 타입이 일치할 때와 일치하지 않을 때의 차이
        SmartTV s = new SmartTV(); // 참조 변수와 인스턴스의 타입이 일치
        TV t = new SmartTV(); // 조상 타입 참조변수로 자손 타입 인스턴스 참조

        s는 멤버 개수가 7개로 모든 기능 사용 가능
        t는 멤버 개수가 5개로 인스턴스(SmartTV 제품)은 7개의 멤버를 가지고 있음, 7개 전부가 아닌 일부(5개)만 사용 가능
        예시 : 7개의 기능이 있는 스마트TV를 스마트TV리모콘으로 조작하면 7개 모두 사용 가능하고 일반TV리모콘으로 조작하면 5개만 사용 가능
        이게 단점 같지만 장점이 되기도 함

        반대로 자손 타입의 참조변수로 조상 타입의 객체를 가리킬 수 없다.
        TV t = new SmartTV(); // 가능
        SmartTV s = new TV(); // 에러
        안되는 예시 : 5개의 기능이 있는 TV를 스마트TV리모콘(7개)으로 조작할 때 TV에 없는 기능을 작동시키면 동작을 안함(없는 것을 호출해서 에러)
      */
    }
}

class TV {
    boolean power;
    int channel;

    void power() { power = !power; }
    void channelUp() { ++channel; }
    void channelDown() { --channel; }
}
class SmartTV extends TV {
    String text;
    void caption() {}
}