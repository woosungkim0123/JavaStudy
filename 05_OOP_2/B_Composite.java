public class B_Composite {
    public static void main(String[] args) {
        /*
        포함(Composite)
        클래스들간의 관계는 크게 상속하고 포함으로 나눌 수 있음
        클래스 멤버로 참조변수를 선언하는 것
        작은 단위의 클래스를 만들고 이 들을 조합해서 클래스를 만든다.
        */
        Circle1 c = new Circle1();

        /*
        상속관계 : A는 B이다(is-a)
        포함관계 : A는 B를 가지고 있다(has-a)

        원(Circle)이 점(Point)이다. => 상속관계계
        원(Circle)이 점(Point)를 가지고 있다. => 포함관계

        포함관계가 문장이 자연스러움(절대적인 것은 아님)
        대부분(90% 이상)이 포함, 상속은 여러가지 제약이 많아서 꼭 필요할 때만 사용
        */
    }
}

class Circle1 {
    int x; // 원점의 x좌표 c.x
    int y; // 원점의 y좌표 c.y
    int r; // 반지름 c.r
}
// 포함 예시 (Circle2가 Point를 포함하고 있음)
class Circle2 {
    Point c = new Point(); // c.c.x, c.c.y
    int r; // c.r
}
// 위 두개는 메모리 저장구조가 다름 c에 Point의 메모리 주소가 저장된다. 저장공간은 3개로 똑같음
// 어느쪽이 좋다고 말못함. Circle2가 복잡도가 조금 더 줄어든 코드

