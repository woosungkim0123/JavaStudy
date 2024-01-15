package d_oop.common;

public class Car {
    public String color; // 진짜 이름 this.color
    public String gearType;
    public int door;

    public Car() {
        this("white", "auto", 4); // Car2(String color, String gearType, int door) 호출
        // 호출할 때 클래스이름인 Car2 대신에 this 사용
        // 같은 클래스 안에 있는 생성자들끼리 호출할 때는 클래스이름 대신 this 사용(규칙)
        // 호출할 때 생성자의 첫줄에서만 가능
    }
    public Car(String color) {
        // 코드 중복을 피하기 위해 주석된 코드대신 다른 생성자를 호출
        // this.color = color
        // gearType = "auto";
        // door = 4;
        this(color, "auto", 4); // Car2(String color, String gearType, int door) 호출
    }
    public Car(String color, String gearType, int door) {
        this.color = color;
        this.gearType = gearType;
        this.door = door;
    }
    public String add () {
        return color + gearType; // this.color, this.gearType이 원래 이름, this가 생략된 것
    }
    public static long add1 (long a, long b) { // lv
        return a + b; // 여긴 지역변수(lv)
        // static 메서드는 객체 생성 없이 호출 하기 때문에 iv 사용불가 => this 사용 불가 (this가 객체 자신을 의미하기 때문, 객체가 있을 수도 있고 없을 수도 있음)
    }
}
