package observer.sub;

import java.util.Random;

public class RandomNumberGenerator extends NumberGenerator {
    private Random random = new Random(); // 난수발생기
    private int number; // 현재의 수

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void execute() {
        number = random.nextInt(50);
        System.out.println("값이 변경되어서 Generator에서 옵저버에 요청 보냅니다~");
        notifyObservers(); // Observer에게 통지
    }
}
