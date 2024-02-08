package template_method.sub;

public abstract class AbstractDisplay {
    public abstract void open();
    public abstract void print();
    public abstract void close();

    // final은 메서드를 오버라이드 할 수 없게 한다.
    public final void display() {
        open(); // 변하는 부분

        // 변하지 않는 부분
        for (int i = 0; i < 5; i++) {
            print();
        }

        close(); // 변하는 부분
    }
}
