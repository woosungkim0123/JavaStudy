package d_oop.common;

public class Time {
    public int hour;
    public int minute;
    public int second;
    // 똑같은 이름이 두개있음 => 생성자 오버로딩
    public Time() {}  // 매개변수 없는 생성자
    public Time(int hour1, int minute1, int second1) { // 매개변수 있는 생성자
        // 인스턴스 초기화 작업
        hour = hour1;
        minute = minute1;
        second = second1;
    }
}
