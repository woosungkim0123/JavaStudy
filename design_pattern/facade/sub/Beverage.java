package facade.sub;

public class Beverage {

    private String name;

    public Beverage(String name) {
        this.name = name;
    }

    public void prepare() {
        System.out.println(name + " 음료를 준비합니다.");
    }
}
