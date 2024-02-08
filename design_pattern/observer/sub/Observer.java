package observer.sub;

/**
 * update 메소드는 NumberGenerator의 상태가 변경되었을 때 호출된다.
 */
public interface Observer {
    void update(NumberGenerator generator);
}
