package d_exception;

/**
 * 함수형 인터페이스를 직접 정의
 */
@FunctionalInterface
public interface TestProcessor {
    String process(String word) throws RuntimeException;
}
