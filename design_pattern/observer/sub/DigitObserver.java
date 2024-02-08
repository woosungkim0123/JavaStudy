package observer.sub;

/**
 * 숫자로 표시하는 Observer
 */
public class DigitObserver implements Observer {
    @Override
    public void update(NumberGenerator generator) {
        System.out.println("DigitObserver 옵저버에서 요청 받음: " + generator.getNumber());
        try {
            Thread.sleep(100); // 관찰을 위한 시간 지연
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
