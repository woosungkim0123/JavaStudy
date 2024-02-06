package facade.sub;

public class Movie {

    private String title;

    public Movie(String title) {
        this.title = title;
    }

    public void search() {
        System.out.println("영화 " + title + "을 검색합니다.");
    }

    public void charge() {
        System.out.println("영화 " + title + "을 결제합니다.");
    }

    public void play() {
        System.out.println("영화 " + title + "을 재생합니다.");
    }
}
