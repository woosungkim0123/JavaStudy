import java.util.function.*;

public class DefaultFunctionalInterface {
    public static void main(String[] args) {

        /**
         * Function<T, R> - T 타입을 받아서 R 타입을 리턴하는 함수형 인터페이스
         */
        System.out.println("=== Function<T, R> ===");

        // 따로 분리해서 사용하는 경우
        FunctionPlus10 plus10Function = new FunctionPlus10();
        System.out.println(plus10Function.apply(10));

        // 람다로 사용하는 경우 (익명 클래스)
        Function<Integer, Integer> plus10 = number -> number + 10;
        System.out.println(plus10.apply(11));

        // compose 사용 - multiply2 먼저 실행 후 plus10 실행
        Function<Integer, Integer> multiply2 = number -> number * 2;
        Function<Integer, Integer> multiply2AndPlus10 = plus10.compose(multiply2);
        System.out.println(multiply2AndPlus10.apply(20)); // 20 * 2 + 10 = 50

        // andThen 사용 - plus10 먼저 실행 후 multiply2 실행
        Function<Integer, Integer> plus10AndMultiply2 = plus10.andThen(multiply2);
        System.out.println(plus10AndMultiply2.apply(20)); // (20 + 10) * 2 = 60


        /**
         * BiFunction<T, U, R> - T 타입과 U 타입을 받아서 R 타입을 리턴하는 함수형 인터페이스
         */
        System.out.println("=== BiFunction<T, U, R> ===");

        BiFunction<Integer, Integer, Integer> multiply = (number1, number2) -> number1 * number2;

        System.out.println(multiply.apply(10, 20)); // 200


        /**
         * Consumer<T> - T 타입을 받아서 아무값도 리턴하지 않는 함수형 인터페이스
         */
        System.out.println("=== Consumer<T> ===");

        Consumer<Integer> printT = number -> System.out.println(number);
        printT.accept(10);


        /**
         * Supplier - T 타입의 값을 제공하는 함수형 인터페이스
         */

        System.out.println("=== Supplier ===");

        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10.get());


        /**
         * Predicate<T> - T 타입을 받아서 boolean 을 리턴하는 함수형 인터페이스
         */
        System.out.println("=== Predicate<T> ===");

        Predicate<Integer> isEven = number -> number % 2 == 0;
        System.out.println(isEven.test(10));


        /**
         * UnaryOperator<T> - T 타입을 받아서 T 타입을 리턴하는 함수형 인터페이스
         */
        System.out.println("=== UnaryOperator<T> ===");

        UnaryOperator<Integer> plus20 = number -> number + 20;
        System.out.println(plus20.apply(10));


        /**
         * BinaryOperator<T> - T 타입을 두개 받아서 T 타입을 리턴하는 함수형 인터페이스
         */
        System.out.println("=== BinaryOperator<T> ===");

        BinaryOperator<Integer> sum = (number1, number2) -> number1 + number2;
        System.out.println(sum.apply(10, 20));

    }
}
