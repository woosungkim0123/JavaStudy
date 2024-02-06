package facade.sub;

public class Facade {

    private String movieTitle;
    private String beverageName;

    public Facade(String movieTitle, String beverageName) {
        this.movieTitle = movieTitle;
        this.beverageName = beverageName;
    }

    public void viewMovie() {
        Beverage beverage = new Beverage(beverageName);
        RemoteControl remoteControl = new RemoteControl();
        Movie movie = new Movie(movieTitle);

        beverage.prepare(); // 음료를 준비합니다.
        remoteControl.turnOn(); // TV를 켭니다.

        // 영화를 검색, 결제, 재생합니다.
        movie.search();
        movie.charge();
        movie.play();
    }
}
