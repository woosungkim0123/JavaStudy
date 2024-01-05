public class FunctionalMain {
    public static void main(String[] args) {

        int number2 = 10;

        // 순수함수
        System.out.println("=== 순수함수 ===");

        Example example = (number) -> number + 10;
        System.out.println(example.doSomething(10));
        System.out.println(example.doSomething(10));
        System.out.println(example.doSomething(10));

        System.out.println("=== 순수함수가 아닌 경우 ===");

        // 순수함수가 아닌경우 - 외부 변수 참조, 외부 변수 변경
        Example example3 = new Example() {
            int number3 = 10;
            @Override
            public int doSomething(int number) {
                number3++;
                return number + number3;
            }
        };

        System.out.println(example3.doSomething(10));
        System.out.println(example3.doSomething(10));
        System.out.println(example3.doSomething(10));
    }
}
