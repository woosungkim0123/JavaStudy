package proxy.sub;

public class RealSubject implements Subject {

    @Override
    public String operation() {
        System.out.println("실제 객체 호출");
        sleep(1000); // 데이터베이스 조회에 1초 걸림을 가정
        return "data";
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
