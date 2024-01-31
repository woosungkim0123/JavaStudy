package d_exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.function.Function;

public class FunctionalExceptionMain {
    public static void main(String[] args) throws IOException {
        /**
         * 함수형 인터페이스는 확인된 예외를 던지는 동작을 허용하지 않습니다.
         * 예외를 던지는 람다 표현식을 만드려면
         * - 예외를 선언하는 함수형 인터페이스를 직접 정의
         * - try/catch 블록으로 감싸야 합니다.
         */

        // 1. 예외를 선언하는 함수형 인터페이스를 직접 정의 (TestProcessor)
        TestProcessor testProcessor = word -> {
            if (word.equals("exception")) {
                // throw new IOException("예외 발생"); // 컴파일 에러
                throw new RuntimeException("예외 발생");
            }
            return "success";
        };

        // 2. try/catch 블록으로 감싸야 합니다.
        Function<BufferedReader, String> bufferedReader = (b) -> {
            try {
                return b.readLine(); // 예외 발생 가능
            } catch (IOException e) {
                throw new RuntimeException("예외 발생");
            }
        };
    }
}
