public class L_Polymorphism2 {
    public static void main(String[] args) {
        /*
        다형성

        1. Tv t (조상) = new SmartTv(); (자손)
        2. 참조변수의 형변환 - 리모콘 바꾸기 (사용 가능한 멤버갯수 조절)
        3. instatnceof 형변환 가능여부 확인

        다형성의 장점

        1. 다형적 매개변수
        2. 하나의 배열로 여러 종류 객체 다루기

        매개변수의 다형성

        매개변수가 참조형이면 메서드 호출시 자신과 같은 타입 또는 자손타입의 인스턴스를 넘겨줄 수 있다. => Buyer
        */

        Product p = new Product();
        // 참고 (두개 같음)
        System.out.println(p + "를 구매하셨습니다"); // System.out.println(p.toString + "를 구매하셨습니다");
    }
}

class Product {
    int price;
    int bonusPoint;

    public String toString() {
        return "Product";
    }
}
class Tv1 extends Product {}
class Computer extends Product {}
class Audio extends Product {}

class Buyer {
    int money = 1000;
    int bonusPoint = 0;
    /*
    메서드를 추가할 때 매개변수 타입을 Tv1으로 하면 Tv1 밖에 못들어옴
    void buy(Tv1 t) {
        money -= t.price;
        bonusPoint += t.bonusPoint;
    }
    // 오버로딩
    void buy(Computer c) {
        money -= c.price;
        bonusPoint += c.bonusPoint;
    }
    void buy(Audio a) {
        money -= a.price;
        bonusPoint += a.bonusPoint;
    }

    물건 종류가 점점 많아지면 계속 추가할 수가 없음 => 많은 메서드를 오버로딩하면 관리 힘들고 코드 중복 발생
    */
    // 이렇게 변경
    void buy(Product p) { // 다형성에 의해서 Tv1, Computer, Audio 다 들어올 수 있음
        money -= p.price;
        bonusPoint += p.bonusPoint;
    }
    // 메서드를 여러개 만들 필요 없이 매개변수 타입이 Product(조상)인 하나로 모든 물건을 살 수 있음 => 다형성의 첫번째 장점

}