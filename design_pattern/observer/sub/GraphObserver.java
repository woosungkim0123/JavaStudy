package observer.sub;

/**
 *  *처럼 간이 그래프를 표시하는 클래스
 */
public class GraphObserver implements Observer {
    @Override
    public void update(NumberGenerator generator) {
        System.out.print("GraphObserver: 옵저버에서 요청 받음 ");
        int count = generator.getNumber();
        for (int i = 0; i < count; i++) {
            System.out.print("*");
        }
        System.out.println("");
        try {
            Thread.sleep(100); // 관찰을 위한 시간 지연
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
