package e_oop_deep;

public class M_AbstractClass {
    public static void main(String[] args) {
        /*
        추상 클래스(abstract class)

        미완성 설계도. 미완성메서드(=추상메서드)를 가지고 있는 클래스

        추상 클래스는 설계도가 미완성이라 제품(인스턴스) 생성 불가
        다른 클래스 작성에 도움을 주기 위한 것

        */
        // Player p = new Player(); 에러
        AudioPlayer ap = new AudioPlayer();

        // 추상메서드는 꼭 필요하지만 자손마다 다르게 구현될 것으로 예상되는 경우 사용

        /*
        추상 클래스의 작성

        여러 클래스에 공통적으로 사용될 수 있는 추상클래스를 바로 작성하거나 기존 클래스의 공통 부분을 뽑아서 추상클래스를 만든다.

        추상화(불명확) <--> 구체화(명확)

        구체적인 것이 좋지만 때로는 불명확한 것이 좋을 때도 있음
        (예 : 말을 애매하게 해놓으면 피해나갈 구멍이 생김)

        추상화된 코드는 구체화된 코드보다 유연하다. 변경에 유리
        GregorianCalendar cal = new GregorianCalendar(); => 구체적

        Calendar cal = Calendar.getInstance() => 추상적
        (추상클래스)             (Calendar 자손 객체 반환)

        getInstance 메서드가 뭘 반환할지 모름(불분명) => 추상화화
        */


   }
}
abstract class Player {
    boolean pause;
    int currentPos;

    Player() {
        pause = false;
        currentPos = 0;
    }
    // 추상메서드 => 자손마다 다르게 구현하려고
    // 상속을 받으면 코드를 만들어서 설계도를 완성해야하는구나 라는 강제성부여
    // Player라면 play기능과 stop기능이 있어야해 => 필수기능이라서 상속을 통해서 맞게 구현을 해야해(강제성)
    abstract void play(int pos);
    abstract void stop();
    void play() {
        play(currentPos); // 인스턴스 메서드인데 추상메서드 호출 가능
        // 나중에 상속을 통해서 자손이 play 몸통을 완성하고 그때는 호출 가능, 지금은 불가능
        // 객체 생성 후에 호출할 수 있는데 추상클래스라 객체 생성 불가
    }

}
class AudioPlayer extends Player {
    @Override
    void play(int pos) {/* 내용 생략*/} // 추상 메서드를 구현
    @Override
    void stop() {/* 내용 생략*/} // 추상 메서드를 구현
}

// 추상메서드 일부만 구현
abstract class AbstractPlayer extends Player { // abstarct 안 붙이면 에러
    void play(int pos) {}
    // 상속받아서 보이지는 않지만 abstract void stop();가 있어서 abstarct를 붙여줘야함
}