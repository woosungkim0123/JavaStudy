public class E_Overloading {
    public static void main(String[] args) {
        /*
        (메서드)오버로딩 (overloading : 과적하다)
        한 클래스 안에 같은 이름의 메서드 여러 개 정의하는 것
        매개변수 타입은 다르고 코드가 다르더라도 의미상으로 같은 작업을 수행하는 경우 오버로딩을 함

        정확한 명칭은 메서드 오버로딩, 오버로딩에 종류가 몇개 있음, c++에서는 연산자 오버로딩을 지원함
        자바에도 연산자 오버로딩이 있음 => +가 덧셈, 부호, 문자열 결합에 쓰임 (자바에서 제공은 하지만 따로 구현은 못함)
        그래서 자바에서 구현을 못하기 때문에 오버로딩이라고 하면 메서드 오버로딩을 의미한다.
        원래 쌓아야하는 것보다 많이 쌓음 => 기본이 메서드 : 메서드이름 = 1 : 1 인데 n : 1 정의

        오버로딩의 대표적인 예 println, 매개변수가 다 다름
        컴파일러가 매개변수가 어떤 타입인지 확인해서 거기에 맞는 메서드랑 연결해줌

        void println()
        void println(boolean x)
        void println(long x)
        ...

        오버로딩 성립조건
        1. 메서드 이름이 같아야한다.
        2. 매개변수 개수 or 타입이 달라야 한다.
        3. 반환 타입은 영향없다.
        */
        class OverloadingTest {
            /*
            오버 로딩 X (메서드 중복정의 => 에러)
            int add(int a, int b) {return a + b;}
            int add(int x, int y) {return x + y;}

            반환타입만 다르면 오버로딩 아님 (메서드 중복정의 => 에러)
            int add(int a, int b) {return a + b;}
            long add(int x, int y) {return x + y;}
            */
            // 오버로딩 성립
            static long add(int a, long b) {return a + b;}
            static long add(long a, int b) {return a + b;}
        }

        // 호출 시 1번 호출
        OverloadingTest.add(3, 3L);
        // add(3, 3) 호출 시 둘 중 어떤 것을 호출할 지 모름 => ambiguous(모호하다) 에러

    }

}
