package d_oop;

public class C_CallStack {
    public static void main(String[] args) {
        /*
        호출스택(call stack)
        메서드 수행에 필요한 메모리가 제공되는 공간
        메서드가 호출되면 호출스택에 메모리 할당. 종료되면 해제
        아래 있는 메서드가 위의 메서드를 호출한 것(맨위 메서드 하나만 실행 중. 나머지는 대기 상태)
        쓰레드마다 스택을 가지고 있음. 즉, 싱글 쓰레드는 스택이 한개, 멀티는 여러개
        */

        // 기본형 매개변수 : 변수의 값을 읽기만 할 수 있다
        Data d = new Data(); // 객체 생성 => 메모리에 올라감 => 메모리 주소를 d에 담음(참조변수)
        d.x = 10; // 메모리 주소에 있는 x 변경
        System.out.println("main() : x = " + d.x); // 10
        change(d.x);
        System.out.println("After change(d.x)");
        System.out.println("main() : x = " + d.x); // 메모리 주소에 있는 x(10) 출력

        // 참조형 매개변수 : 변수의 값을 읽고 변경할 수 있다.
        Data d2 = new Data();
        d2.x = 10;
        System.out.println("main()2 : x = " + d2.x); // 10 출력
        change2(d2);
        System.out.println("After change2(d2)");
        System.out.println("main()2 : x = " + d2.x); // 메모리 주소에 있는 x(1000) 출력

        // 참조형 반환타입
        Data da = new Data();
        da.x = 10;

        Data da2 = copy(da); // static 메서드이고 같은 클래스 안에서 있어서 호출할 때 앞에 참조변수가 없음
        System.out.println("da.x = " + da.x); // 10
        System.out.println("da2.x = " + da2.x); // 10
    }
    // static 메서드는 객체 생성없이 호출 가능
    static void change(int x){ // 기본형 매개변수라 읽기만 가능
        x = 1000; // lv(지역변수를 변경한 것)
        System.out.println("change() : x = " + x);
        // 끝나고 change는 callStack에서 사라짐
    }
    static void change2(Data d2) {
        d2.x = 1000;
        System.out.println("change2() : x = " + d2.x); // 1000 출력
    }
    static Data copy(Data da) {
        Data tmp = new Data();
        tmp.x = da.x;
        return tmp;
    }
}
class Data { int x; }