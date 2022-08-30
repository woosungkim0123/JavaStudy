public class I_Encapsulation {
    public static void main(String[] args) {
        /*
        캡슐화
        접근 제어자를 사용 이유 : 데이터를 보호하기 위해서 => 캡슐화의 의미
        */
        Time t = new Time();
        t.hour = 30; // 멤버 변수에 직접 접근. 30시? 범위 외의 값이 들어가는 문제 발생(데이터 보호가 안됨)

        RightTime rt = new RightTime();
        rt.setHour(30); // 값이 안바뀜 => 데이터 보호
        System.out.println(rt.getHour());
        rt.setHour(21);
        System.out.println(rt.getHour());
        /*
        즉, 직접 접근을 막고 메서드를 통한 간접 접근을 허용하는 것을 캡슐화라고 한다. (접근 제어자를 이용한 캡슐화)
        잘못된 데이터가 되는 것을 막기 위한 방법(데이터 보호)
        
        그리고 또 한가지 이유는 내부적으로 사용되는 부분을 감추려고 사용
        내부에서만 사용하는 것을 굳이 public으로 할 필요가 없기 때문에 
        
        접근 제어자의 범위는 좁을 수록 좋음
        */
    }
}
class Time {
    public int hour;
    public int minute;
    public int second;
}
class RightTime {
    private int hour;
    private int minute;
    private int second;
    
    // 외부에서 직접 iv에 접근하는 것을 막고 메서드를 통해 iv 간접 접근은 허용 (이런 식으로 코딩)
    public void setHour(int hour) {
        if(isValidHour(hour)) return;
        this.hour = hour;
    }
    private boolean isValidHour(int hour) {
        return hour < 0 || hour > 23;
    }
    public int getHour() { return this.hour; }
}