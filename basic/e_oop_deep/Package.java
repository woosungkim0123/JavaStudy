package e_oop_deep;

public class Package {
    public static void main(String[] args) {
        /*
        패캐지
        서로 관련된 클래스의 묶음
        클래스는 클래스 파일(*.class), 패키지는 폴더. 하위 패키지는 하위 폴더

        패키지 선언
        패키지는 소스파일의 첫 번째 문장으로 단 한번 선언
        같은 소스 파일의 클래스들은 모두 같은 패키지에 속하게 된다.
        패키지 선언이 없으면 이름없는(unnamed = default) 패키지에 속하게 된다.
        */
        System.out.println("hello");
        // 컴파일 된 곳(out)에서 java com.codechobo.e_oop_deep.Package

        /*
        매번 특정 폴더로 이동해서 실행 => 불편 => 불편함을 없애기 위해 classpath
        classpath에 경로를 저장해놓으면 패키지로 이동하지 않아도 실행 가능

        classpath
        클래스 파일의 위치를 알려주는 경로(path)
        환경변수(os 레벨에서 관리하는 변수) classpath로 관리하며, 경로간의 구분자는 ;를 사용
        classpath(환경변수)에 패키지의 루트를 등록해줘야 함

        */

    }
}
