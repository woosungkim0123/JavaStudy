public class A_Inheritance {
    public static void main(String[] args) {
        /*
        상속
        기존 클래스로 새로운 클래스를 작성하는 것(코드의 재사용)
        두 클래스를 부모와 자식으로 관계를 맺어주는 것
        자손은 조상의 모든 멤버를 상속받는다.(생성자, 초기화블럭 제외) => 자손의 멤버 개수는 조상보다 적을 수 없다(같거나 많다)
        자손의 변경은 조상에 영향을 미치지 않는다.
        */

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