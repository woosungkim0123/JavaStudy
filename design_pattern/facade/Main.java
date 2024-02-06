package facade;

import facade.sub.Beverage;
import facade.sub.Facade;
import facade.sub.Movie;
import facade.sub.RemoteControl;

public class Main {
    public static void main(String[] args) {
        // Facade 패턴을 사용한 경우
        Facade facade = new Facade("어벤져스", "콜라");
        facade.viewMovie();

        System.out.println();
        System.out.println("Facade 패턴을 사용하지 않은 경우");
        // Facade 패턴을 사용하지 않은 경우
        Beverage beverage = new Beverage("콜라");
        RemoteControl remoteControl = new RemoteControl();
        Movie movie = new Movie("어벤져스");

        beverage.prepare(); // 음료를 준비합니다.
        remoteControl.turnOn(); // TV를 켭니다.

        // 영화를 검색, 결제, 재생합니다.
        movie.search();
        movie.charge();
        movie.play();
    }
}
