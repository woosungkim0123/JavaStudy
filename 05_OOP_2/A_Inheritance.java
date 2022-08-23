public class A_Inheritance {
    public static void main(String[] args) {
        /*
        상속
        기존 클래스로 새로운 클래스를 작성하는 것(코드의 재사용)
        두 클래스를 부모와 자식으로 관계를 맺어주는 것
        자손은 조상의 모든 멤버를 상속받는다.(생성자, 초기화블럭 제외) => 자손의 멤버 개수는 조상보다 적을 수 없다(같거나 많다)
        자손의 변경은 조상에 영향을 미치지 않는다.


        단일 상속(Single Inheritance)
        자바는 단일상속만을 허용(C++은 다중상속 허용)
        하나의 부모만 상속
        class TvDVD extends TV, DVD {} // 에러

        다중상속의 문제점
        부모가 두개일때 이름이 동일하지만 내용은 다른 메서드가 있으면 어떤 것을 상속받아야 하는지 충돌 문제가 있음

        참고 : 인터페이스를 이용하여 충돌문제를 해결하면서 다중 상속과 같은 효과를 낼 수 있음

        인터페이스를 사용하지않고 다중상속처럼 편리하게 작성하는 방법
        하나만 상속관계로 하고 나머지는 포함관계로 하는 것 => Class TvDVD
        비중이 높은 클래스 하나만 상속관계, 나머지는 포함관계
        
        Object 클래스 - 모든 클래스의 조상
        부모가 없는 클래스는 자동적으로 Object 클래스를 상속받게 된다.

        class Tv {
            boolean power;
        }

        컴파일러가 컴파일 시 자동으로 추가

        class Tv extends Object {
            boolean power;
        }

        모든 클래스는 Object 클래스에 정의된 11개의 메서드를 상속받는다.(toString(), equals(Object obj), hashCode(), ...)
        */
        Tv t = new Tv();
        // 두개 결과 값이 같음 => println에 참조변수가 들어오면 내부적으로 toString을 호출함
        System.out.println(t.toString()); // Object 클래스를 상속 받기 때문에 사용가능
        System.out.println(t);
    }
}
// 이 두클래스를 상속관계에 있다고 한다.
class Parent {
    int age; // 멤버 1개
}
class Son extends Parent { // 멤버가 0개 아닌 1개 (자신의 멤버가 0개, 부모 상속 멤버 1개)
    void play() { // 자신 멤버 1개 + 부모로 부터 상속받은 멤버 1개 = 2개
        System.out.println("놀자~");
    }
}

class Point {
    int x;
    int y;
}
// Point3D1과 Point3D2는 실제 객체로 만들어져서 메모리 올라간 형태는 똑같다.
// Point3D1 클래스는 Point 클래스와 관게가 없어서 Point 클래스의 변경에 영향을 안받음
class Point3D1 {
    int x;
    int y;
    int z;
}
// Point3D2 클래스는 Point 클래스와 관게가 있어서 Point 클래스의 변경에 영향을 받음
class Point3D2 extends Point {
    int z;
}

class Tv {
    boolean power;
    int channel;

    void power() { power = !power; }
}
class DVD {
    boolean power;

    void power() { power = !power; }
}
class TvDVD extends Tv {
    DVD dvd = new DVD();

    void play() {
        // 메서드를 만들어 줘야하는 번거로움이 있긴 하지만 안에 코드를 작성할 필요 없이 호출해서 사용하면 됨
        dvd.power();
    }
}
