import java.util.Date;

public class F_Import {
    public static void main(String[] args) {
        /*
        import문
        클래스를 사용할 때 패키지이름 생략 가능
        컴파일러에게 클래스가 속한 패키지를 알려준다.

        java.lang 패키지의 클래스는 import하지 않고도 사용가능(String, Object, System, Thread), 생략가능
        *은 모든 클래스

        import문은 패키지문과 클래스 선언의 사이에 선언

        import문(컴파일러를 위한것)은 컴파일 시 처리 => 프로그램 성능 영향없음

        import java.util.*;
        import java.text.*;

        위 코드와 이 코드는 다름
        import java.*; // java 패키지의 모든 클래스 (패키지는 포함 안됨)

        이름이 같은 클래스가 속한 두 패키지를 import 할 때는 클래스 앞에 패키지명을 붙여줘야한다. (뭔지 모름)
        import java.sql.*; // java.sql.Date
        import java.util.*; // java.util.Date

        java.util.Date today = new java.util.Date();

        */
        Date today = new Date();

        /*
        static import문
        static멤버(static변수, static 메서드)를 사용할 때 클래스 이름을 생략할 수 있게 해줌

        import static java.lang.Integer.*; // Integer클래스의 모든 static 메서드
        import static java.lang.Math.random; // Math클래스의 random메서드만
        import static java.lang.System.out; // out은 static변수

        System.out.println(Math.random());
        => out.println(random());

        사용이유
        가면 갈수록 코드가 길어짐 => 클래스 이름도 거추장스러움 => 나중에 추가된 것

         */


    }
}
