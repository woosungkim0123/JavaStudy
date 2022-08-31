public class K_ReferenceVariableChange {
    public static void main(String[] args) {
        /*
        참조변수의 형변환

        기본형의 형변환(3.6 - (int) -> 3)
        참조형의 형변환은 사용할 수 있는 멤버의 갯수를 조절하는 것 (주소값, 객체 하나도 안변함)

        조상 자손 관계의 참조변수는 서로 형변환 가능
        */
        FireEngine f = new FireEngine(); // 타입 일치 (5개 멤버 모두 사용 가능)
        Car c = (Car) f; // 타입이 Car (4개 멤버 사용 가능) => 형변환 생략가능
        // f가 주소 0x100을 가리키고 있는데 c도 0x100을 가리키는 것 (같은 객체를 가르킴)
        // 같은 객체를 가리키고 있는 건 맞지만 사용할 수 있는 갯수에 제한이 있다.

        FireEngine f2 = (FireEngine) c; // 5개 모두 사용 가능 => 형변환 생략불가

        // 리모콘을 변경함으로써 객체에서 사용할 수 있는 멤버를 늘였다 줄였다 하는 것 => 참조변수 형변환

        Car c1 = new Car(); // 4개
        FireEngine fe = (FireEngine) c1; // 형변환 실행 에러
        fe.water(); // 컴파일 오케이
        // 실제 가리키는 객체의 갯수가 4개 이기 때문에 4개를 넘어서면 안됨
        // 형변환은 가능 하지만 실제 인스턴스 갯수가 4개 이기 때문에 형변환을 하면 안된다.
        // 결론 : 참조변수 간의 형변환이 중요한 것이 아니라 실제 가리키는 객체가 무엇인지가 중요
    }
}

class Car {
    // 4개
}
class FireEngine extends Car {
    // 1개
    void water() {
    }
}
