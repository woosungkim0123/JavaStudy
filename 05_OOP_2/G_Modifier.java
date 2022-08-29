public class G_Modifier {
    public static void main(String[] args) {
        /*
        제어자(modifier)
        클래스와 클래스의 멤버(멤버 변수, 메서드)에 부가적인 의미 부여

        제어자 종류(크게 두분류)
        접근 제어자 : public, protected, (default), private => 하나의 대상에 4개 중 하나만 붙일 수 있음
        그 외 : static, final, abstract, native, transient, synchronized, volatile, strictfp
        */
    }
    // 하나의 대상에 여러 제어자를 같이 사용 가능(접근 제어자는 하나만, 그리고 관례적으로 제일 왼쪽에)
    public static final int WIDTH = 200;
    /*
    static - 클래스의, 공통적인
    대상 : 멤버변수, 메서드
    */
    // 클래스 변수(간단 초기화, 명시적)
    static int width = 200;
    // 클래스 초기화 블럭(복잡한 초기화)
    static {}
    // 클래스 메서드
    // iv, 인스턴스 메서드 사용 불가(인스턴스 멤버 사용 불가)
    static int max(int a, int b) {
        return a > b ? a : b;
    }
    
    /*
    final - 마지막의, 변경될 수 없는
    대상: 전부다
    
    class 앞에 붙으면 변경, 확장 될 수 없는 클래스가 된다. => 조상이 될 수 없는 클래스(제일 마지막) 
    대표적인 예 : String, Math 등
    보안 문제 때문에 => 패스워드를 문자열로 저장하는데 상속이 가능하면 자손에서 조상 멤버에 접근할 수 있기 때문에
    Math는 static 메서드 집합이라서 상속받아 쓸 일이 없어서 final로 해둠
    
    변수 앞에 붙으면 값을 변경할 수 없는 변수(상수)
    
    메서드 앞에 붙으면 변경불가한 메서드가 됨(오버라이딩 할 수 없는 메서드), 오버라이딩은 조상 메서드를 덮어 쓰는 것
    오버라이딩 못하게 막을 때 메서드 앞에 final
    
    */
    
    /*
    abstract - 추상의, 미완성의
    대상: 클래스, 메서드
    
    몸통이 없는 메서드를 추상메서드라고 함
    
    추상 메서드가 있으면 무조건 추상 클래스

    추상클래스를 보면 추상메서드를 가지고 있구나 => 추상클래스를 상속받아서 완전한 클래스(구상 클래스)를 만든 후에 객체 생성 가능


    */
    abstract class AbstractTest { // 추상 클래스(추상 메서드를 포함한 클래스)
        abstract void move(); // 추상 메서드(선언부만 있고 구현부가 없는 메서드)
        // 미완성 메서드를 가지고 있으니 클래스도 미완성
    }
    // 추상 클래스 = 미완성 클래스 = 미완성 설계도 = 객체를 만들 수 없음
    // AbstractTest a = new AbstractTest() 에러 : 추상 클래스의 인스턴스 생성불가
}
