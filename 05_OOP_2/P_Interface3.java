public class P_Interface3 {
    public static void main(String[] args) {
        /*
        인터페이스의 근본적인 개념

        장점 1 : 두 대상(객체) 간의 연결, 대화, 소통을 돕는 중간 역할
        inter(~사이) + face(얼굴, 대상)
        인간 -> 기계껍데기(인터페이스) -> 기계
        인간 -> 윈도우(GUI- Graphic User Interface) -> 컴퓨터

        컴퓨터가 바뀌어도 윈도우 사용법은 안변함, 컴퓨터가 바뀌어도 사용법은 안바뀜(변경에 유리)

        장점 2 : 선언(설계)와 구현을 분리시킬 수 있게 한다. => A!!!!!!!!!!!!

        A클래스(User)가 B클래스(Provider)를 사용 (A가 B에 의존한다) (강한 결합)
        만약 B를 C로 변경하고 싶으면 A의 코드를 변경해야함 (변경 불가피)
        만약 B가 인터페이스가 중간에 끼여있으면 A는 인터페이스하고만 관계있음(B하고 직접적인 연관이 없음)
        인터페이스 덕분에 B가 변경되어도 A 변경 불필요 (느슨한 결합)
        알맹이를 C로 바꾸어도 A는 모름 = 음료수 자판기 껍데기만 안바뀌면 기계를 바뀌어도 사용자는 모름
        */
        // 직접적인 관계의 두 클래스 => B!!!!!!!!!!!!
        User u = new User();
        // u.methodA(new Provider());
        u.methodA(new ProviderCopy());
        // 간접적인 관계의 두 클래스 => C!!!!!!!!!!!!

        User1 u1 = new User1();
        u1.methodA(new Provider1());
        u1.methodA(new Provider2());

        // 변경하긴 해야하나 User1 부분을 손댈 필요가 없어짐 => 변경 부분 적어짐짐

    }}


// A
// 껍데기 + 알맹이
// 유연x, 변경에 불리
class B {
    public void method() {}
}
// 껍데기
interface I {
    public void method();
}
// 알맹이
class B1 implements I {
    public void method(){}
}
// 분리, B1(알맹이)를 다른걸로 바꿀 수 있음(변경에 유리), 유연한 코드


// B
class User {
    /*
    변경하려면
    public void methodA(Provider p) {
        p.methodB();
    }*/
    public void methodA(ProviderCopy p) {
        p.methodB();
    }
}
class Provider {
    public void methodB() {
        System.out.println("Provider");
    }
}
// 이걸로 변경하려면 User 클래스도 변경해야함
class ProviderCopy {
    public void methodB() {
        System.out.println("ProviderCopy");
    }
}



// C
class User1 {
    public void methodA(Ino i) { // B와 관계 없음, 인터페이스하고만 관계
        i.methodB();
    }
}
interface Ino { void methodB ();}
class Provider1 implements Ino {
    public void methodB() {
        System.out.println("Provider1");
    }
}
// 만약 Provider2로 변경한다고 해도 User1은 건드릴 필요가 없음
class Provider2 implements Ino {
    public void methodB() {
        System.out.println("Provider2");
    }
}





