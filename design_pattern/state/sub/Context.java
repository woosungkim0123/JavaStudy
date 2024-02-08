package state.sub;

/**
 * 상태를 관리하거나 경비센터를 호출하는 등의 처리를 위한 인터페이스
 */
public interface Context {
    void setClock(int hour); // 시각설정
    void changeState(State state); // 상태전환
    void callSecurityCenter(String msg); // 경비센터 호출
    void recordLog(String msg); // 경비센터 기록
}
