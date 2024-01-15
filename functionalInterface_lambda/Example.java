
@FunctionalInterface // 함수형 인터페이스라는 것을 명시적으로 선언
public interface Example {

    int doSomething(int number); // 추상메서드 한개

    static void printSomething() {
        System.out.println("Hello World! 1");
    }

    default void printSomethingElse() {
        System.out.println("Hello World! 2");
    }
}
